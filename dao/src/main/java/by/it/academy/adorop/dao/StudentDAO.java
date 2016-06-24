package by.it.academy.adorop.dao;

import by.it.academy.adorop.entities.Student;

public class StudentDAO extends BasicDAO<Student> {

    private static StudentDAO INSTANCE = new StudentDAO();

    public static StudentDAO getInstance() {
        return INSTANCE;
    }

    private StudentDAO() {
    }
}
