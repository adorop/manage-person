package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.commands.exceptions.NoSuchEntityException;
import by.it.academy.adorop.controller.utils.InputReader;
import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.exceptions.DaoException;

public class FindCommand<T> extends Command {

    private DAO<T> dao;

    FindCommand(DAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public void execute() {
        try {
            print("Insert id - ");
            T retrievedObject = getEntity(dao, InputReader.readInteger());
            System.out.println(retrievedObject);

        } catch (DaoException e) {
            logger.error(e);
        } catch (NoSuchEntityException e) {
            catchNoSuchEntityException();
        }

    }
}
