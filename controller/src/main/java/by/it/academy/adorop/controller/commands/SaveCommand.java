package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.utils.FromConsoleBuilder;
import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.PersonDAO;
import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.entities.Address;
import by.it.academy.adorop.entities.Person;

import static by.it.academy.adorop.controller.utils.InputReader.*;

public class SaveCommand<T> extends Command {

    DAO<T> dao;
    Class<T> persistedClass;

    public SaveCommand(Class<T> persistedClass, DAO<T> dao) {
        this.persistedClass = persistedClass;
        this.dao = dao;
    }

    @Override
    public void execute() {
        try {
            T newObject = FromConsoleBuilder.buildObject(persistedClass);
            System.out.println(dao.create(newObject));
        } catch (DaoException e) {
            logger.error(e);
        } catch (NumberFormatException e) {
            System.out.println("Should be a number");
            execute();
        }
    }
}
