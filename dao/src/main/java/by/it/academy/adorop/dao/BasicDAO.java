package by.it.academy.adorop.dao;

import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.dao.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class BasicDAO<T> implements DAO<T> {

    static Logger logger = Logger.getLogger(BasicDAO.class);

    Session session;
    Transaction transaction;

    BasicDAO() {
        session = HibernateUtil.getSession();
    }

    @Override
    public T create(T object) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            return object;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public T get(Serializable id) throws DaoException {
        try {
            transaction = session.beginTransaction();
            T retrievedObject = (T) session.get(getPersistentClass(), id);
            transaction.commit();
            return retrievedObject;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public T update(T object) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.merge(object);
            transaction.commit();
            return object;
        } catch (Exception e) {
            transaction.rollback();
            logger.error(e);
            throw new DaoException();
        }
    }

    @Override
    public void delete(Serializable id) throws DaoException {
        try {
            transaction = session.beginTransaction();
            T attachedObject = (T) session.load(getPersistentClass(), id);
            session.delete(attachedObject);
        } catch (HibernateException e) {
            transaction.rollback();
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
