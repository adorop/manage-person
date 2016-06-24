package by.it.academy.adorop.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

public class SessionFactoryBuilder {

    private Properties hibernateSettings;
    private Collection<String> mappingResources;
    private PhysicalNamingStrategy physicalNamingStrategy;

    public SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = buildServiceRegistry();
        MetadataSources metadataSources = setupMetadataSources(serviceRegistry);
        Metadata metadata = buildMetadata(metadataSources);
        return metadata.buildSessionFactory();
    }

    public void setHibernateSettings(Properties hibernateSettings) {
        this.hibernateSettings = hibernateSettings;
    }

    public void setMappingResources(Collection<String> mappingResources) {
        this.mappingResources = mappingResources;
    }

    public void setPhysicalNamingStrategy(PhysicalNamingStrategy physicalNamingStrategy) {
        this.physicalNamingStrategy = physicalNamingStrategy;
    }

    private Metadata buildMetadata(MetadataSources metadataSources) {
        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
        if (physicalNamingStrategy != null) {
            metadataBuilder.applyPhysicalNamingStrategy(physicalNamingStrategy);
        }
        return metadataBuilder.build();
    }

    private MetadataSources setupMetadataSources(ServiceRegistry serviceRegistry) {
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        setup(metadataSources);
        return metadataSources;
    }

    private ServiceRegistry buildServiceRegistry() {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(getHibernateSettings());

        return serviceRegistryBuilder.build();
    }

    private void setup(MetadataSources metadataSources) {
        for (String resource : mappingResources) {
            metadataSources.addResource(resource);
        }
    }

    private Map getHibernateSettings() {
        Map<String, String> settings = new HashMap<>();

        Enumeration<?> propertyNames = hibernateSettings.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String propertyName = (String) propertyNames.nextElement();
            settings.put(propertyName, hibernateSettings.getProperty(propertyName));
        }
        return settings;
    }
}
