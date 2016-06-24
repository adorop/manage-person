package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.commands.exceptions.NoSuchEntityException;
import by.it.academy.adorop.dao.DAO;
import by.it.academy.adorop.dao.DepartmentDAO;
import by.it.academy.adorop.dao.EmployeeDAO;
import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.entities.Department;
import by.it.academy.adorop.entities.Employee;

import static by.it.academy.adorop.controller.utils.InputReader.*;

public class DeleteEmployeeFromDepartmentCommand extends Command {

    private DAO<Employee> employeeDAO = EmployeeDAO.getInstance();
    private DAO<Department> departmentDAO = DepartmentDAO.getInstance();

    @Override
    public void execute() {
        try {
            print("Insert employee id - ");
            Employee employee = getEntity(employeeDAO, readInteger());

            print("Insert department id - ");
            Department department = getEntity(departmentDAO, readInteger());

            department.removeEmployee(employee);
            System.out.println(departmentDAO.update(department));
        } catch (DaoException e) {
            logger.error(e);
        } catch (NoSuchEntityException e) {
            catchNoSuchEntityException();
        }
    }
}
