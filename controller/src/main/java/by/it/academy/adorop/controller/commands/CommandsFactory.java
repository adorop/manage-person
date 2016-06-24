package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.dao.AddressDAO;
import by.it.academy.adorop.dao.DepartmentDAO;
import by.it.academy.adorop.dao.EmployeeDAO;
import by.it.academy.adorop.dao.StudentDAO;
import by.it.academy.adorop.entities.Address;
import by.it.academy.adorop.entities.Department;
import by.it.academy.adorop.entities.Employee;
import by.it.academy.adorop.entities.Student;

public class CommandsFactory {
    private CommandsFactory() {
    }

    public static Command createShowMenuCommand() {
        return new ShowMenuCommand();
    }

    public static Command createCommand(String request) {
        Command command;

        switch (request) {
            case "1":
                command = new SaveCommand<>(Student.class, StudentDAO.getInstance());
                break;
            case "2":
                command = new SaveCommand<>(Employee.class, EmployeeDAO.getInstance());
                break;
            case "3":
                command = new SaveCommand<>(Department.class, DepartmentDAO.getInstance());
                break;
            case "4":
                command = new FindCommand<>(StudentDAO.getInstance());
                break;
            case "5":
                command = new FindCommand<>(EmployeeDAO.getInstance());
                break;
            case "6":
                command = new FindCommand<>(DepartmentDAO.getInstance());
                break;
            case "7":
                command = new AddEmployeeToDepartmentCommand();
                break;
            case "8":
                command = new DeleteEmployeeFromDepartmentCommand();
                break;
            case "9":
                command = new AddAddressCommand();
                break;
            case "10":
                command = new ExitCommand();
                break;
            default:
                System.out.println("Should be a number from 1 to 10");
                command = new ShowMenuCommand();
                break;
        }
        return command;
    }
}
