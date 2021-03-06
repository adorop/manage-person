package by.it.academy.adorop.controller.commands;

import by.it.academy.adorop.controller.commands.exceptions.NoSuchEntityException;
import by.it.academy.adorop.dao.impl.DAO;
import by.it.academy.adorop.dao.exceptions.DaoException;
import by.it.academy.adorop.entities.Department;
import by.it.academy.adorop.entities.Employee;

import static by.it.academy.adorop.controller.utils.InputReader.readInteger;

public class AddEmployeeToDepartmentCommand extends Command {

    private DAO<Employee> employeeDAO;
    private DAO<Department> departmentDAO;

    public void setEmployeeDAO(DAO<Employee> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void setDepartmentDAO(DAO<Department> departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void execute() {

        try {
            print("Insert employee id - ");
            Employee employee = getEntity(employeeDAO, readInteger());

            print("Insert department id - ");
            Department department = getEntity(departmentDAO, readInteger());

            department.addEmployee(employee);
            System.out.println(departmentDAO.update(department));
        } catch (NumberFormatException e) {
            System.out.println("Should be a number");
            execute();
        } catch (DaoException e) {
            logger.error(e);
        } catch (NoSuchEntityException e) {
            catchNoSuchEntityException();
        }
    }


}
