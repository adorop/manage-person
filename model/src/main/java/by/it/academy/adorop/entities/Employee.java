package by.it.academy.adorop.entities;

public class Employee extends Person {

    private String company;
    private Double salary;
    private Department department;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        if (company != null ? !company.equals(employee.company) : employee.company != null) return false;
        return !(salary != null ? !salary.equals(employee.salary) : employee.salary != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", firstName=" + getFirstName() + '\'' +
                ", lastName=" + getLastName() + '\'' +
                ", age=" + getAge() + '\'' +
                ", address=" + getAddress() + '\'' +
                ", company='" + company + '\'' +
//                ", department='" + department.getName() + '\'' +
                ", salary=" + salary +
                '}';
    }
}
