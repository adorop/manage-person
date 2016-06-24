package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.utils.CommandsContextUtil;

public class CommandsFactory {

    public static final String SAVE_STUDENT = "1";
    public static final String SAVE_EMPLOYEE = "2";
    public static final String SAVE_DEPARTMENT = "3";
    public static final String FIND_STUDENT = "4";
    public static final String FIND_EMPLOYEE = "5";
    public static final String FIND_DEPARTMENT = "6";
    public static final String ADD_EMPLOYEE_TO_DEPARTMENT = "7";
    public static final String DELETE_EMPLOYEE_FROM_DEPARTMENT = "8";
    public static final String ADD_ADDRESS = "9";
    public static final String EXIT = "10";

    private CommandsFactory() {
    }

    public static Command createShowMenuCommand() {
        return new ShowMenuCommand();
    }

    public static Command createCommand(String request) {

        String beanName;

        switch (request) {
            case SAVE_STUDENT:
                beanName = "saveStudentCommand";
                break;
            case SAVE_EMPLOYEE:
                beanName = "saveEmployeeCommand";
                break;
            case SAVE_DEPARTMENT:
                beanName = "saveDepartmentCommand";
                break;
            case FIND_STUDENT:
                beanName = "findStudentCommand";
                break;
            case FIND_EMPLOYEE:
                beanName = "findEmployeeCommand";
                break;
            case FIND_DEPARTMENT:
                beanName = "findDepartmentCommand";
                break;
            case ADD_EMPLOYEE_TO_DEPARTMENT:
                beanName = "addEmployeeToDepartmentCommand";
                break;
            case DELETE_EMPLOYEE_FROM_DEPARTMENT:
                beanName = "deleteEmployeeFromDepartmentCommand";
                break;
            case ADD_ADDRESS:
                beanName = "addAddressCommand";
                break;
            case EXIT:
                beanName = "exitCommand";
                break;
            default:
                System.out.println("Should be a number from 1 to 10");
                beanName = "showMenuCommand";
                break;
        }
        return CommandsContextUtil.getCommand(beanName);
    }
}
