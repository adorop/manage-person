package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.Controller;
import by.it.academy.adorop.controller.utils.CommandsContextUtil;

public class ExitCommand extends Command {

    @Override
    public void execute() {
        CommandsContextUtil.closeContext();
        System.exit(0);
    }
}
