package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.utils.HibernateUtil;

public class ExitCommand extends Command {

    @Override
    public void execute() {
        HibernateUtil.realizeResources();
        System.exit(0);
    }
}
