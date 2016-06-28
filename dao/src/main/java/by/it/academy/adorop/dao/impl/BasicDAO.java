package by.it.academy.adorop.dao.impl;

import by.it.academy.adorop.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class BasicDAO<T> implements DAO<T> {

    static Logger logger = Logger.getLogger(BasicDAO.class);

    Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public T create(T object) throws DaoException {
        try {
            session.save(object);
            return object;
        } catch (Exception e) {
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public T get(Serializable id) throws DaoException {
        try {
            System.out.println(session);
            T retrievedObject = (T) session.get(getPersistentClass(), id);
            return retrievedObject;
        } catch (Exception e) {
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public T update(T object) throws DaoException {
        try {
            session.merge(object);
            return object;
        } catch (Exception e) {
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public void delete(Serializable id) throws DaoException {
        try {
            T attachedObject = (T) session.load(getPersistentClass(), id);
            session.delete(attachedObject);
        } catch (HibernateException e) {
            logger.error(e);
            throw new DaoException();
        }
    }

    @SuppressWarnings("unchecked")
    private Class getPersistentClass() {
       return (Class<T>) ((ParameterizedType) getClass()
               .getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
