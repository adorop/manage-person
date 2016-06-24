package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.utils.FromConsoleBuilder;
import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.exceptions.DaoException;

public class SaveCommand<T> extends Command {

    Class<T> persistedClass;
    DAO<T> dao;

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
