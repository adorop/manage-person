package by.it.academy.adorop.dao;

import by.it.academy.adorop.entities.Employee;

public class EmployeeDAO extends BasicDAO<Employee> {

    private static EmployeeDAO INSTANCE = new EmployeeDAO();

    private EmployeeDAO() {
    }

    public static EmployeeDAO getInstance() {
        return INSTANCE;
    }
}
