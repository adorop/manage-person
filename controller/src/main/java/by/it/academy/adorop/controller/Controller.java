package by.it.academy.adorop.controller;

import by.it.academy.adorop.controller.commands.Command;
import by.it.academy.adorop.controller.commands.CommandsFactory;
import by.it.academy.adorop.controller.utils.InputReader;

public class Controller {

    public static void main(String[] args) {
        while (true) {
            CommandsFactory.createShowMenuCommand().execute();
            String request = InputReader.readString();
            Command command = CommandsFactory.createCommand(request);
            command.execute();
        }
    }
}
