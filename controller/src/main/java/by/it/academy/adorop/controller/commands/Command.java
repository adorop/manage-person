package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.commands.exceptions.NoSuchEntityException;
import by.it.academy.adorop.dao.impl.DAO;
import by.it.academy.adorop.dao.exceptions.DaoException;
import org.apache.log4j.Logger;

import java.io.Serializable;

public abstract class Command {

    protected static Logger logger = Logger.getLogger(Command.class);

    public abstract void execute();

    protected void print(String message) {
        System.out.print(message);
    }

    protected <T> T getEntity(DAO<T> dao, Serializable id) throws DaoException, NoSuchEntityException {
        T result = dao.get(id);
        if (result == null) {
            throw new NoSuchEntityException();
        } else {
            return result;
        }
    }

    protected void catchNoSuchEntityException() {
        System.out.println("No such entity");
        execute();
    }
}
