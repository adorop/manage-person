package by.it.academy.adorop.dao;

import by.it.academy.adorop.dao.exceptions.DaoException;

import java.io.Serializable;

public interface DAO<T> {
    T create(T object) throws DaoException;
    T get(Serializable id) throws DaoException;
    T update(T object) throws DaoException;
    void delete(Serializable id) throws DaoException;
}
