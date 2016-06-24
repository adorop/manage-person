package by.it.academy.adorop.dao.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SessionFactoryBuilder {

    public SessionFactory buildSessionFactory() {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        serviceRegistryBuilder.applySettings(getSettings());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        setup(metadataSources);

        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
        metadataBuilder.applyPhysicalNamingStrategy(new CustomNamingStrategy());
        Metadata metadata = metadataBuilder.build();

        return metadata.buildSessionFactory();
    }

    private void setup(MetadataSources metadataSources) {
        metadataSources.addResource("address.hbm.xml");
        metadataSources.addResource("department.hbm.xml");
        metadataSources.addResource("global.hbm.xml");
        metadataSources.addResource("person.hbm.xml");
//        metadataSources.addJar(new File(""));
    }

    private Map getSettings() {
        Map<String, String> settings = new HashMap<>();
        settings.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/manage_person");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "1234");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");
        settings.put("hibernate.hbm2ddl.auto", "create-drop");
        return settings;
    }
}
