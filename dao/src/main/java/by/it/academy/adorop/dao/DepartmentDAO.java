package by.it.academy.adorop.dao;

import by.it.academy.adorop.entities.Department;

public class DepartmentDAO extends BasicDAO<Department> {

    private static DepartmentDAO INSTANCE = new DepartmentDAO();

    private DepartmentDAO() {
    }

    public static DepartmentDAO getInstance() {
        return INSTANCE;
    }
}
