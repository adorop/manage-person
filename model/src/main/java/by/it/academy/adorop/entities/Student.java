package by.it.academy.adorop.entities;

public class Student extends Person {

    private String faculty;
    private Double mark;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (faculty != null ? !faculty.equals(student.faculty) : student.faculty != null) return false;
        return !(mark != null ? !mark.equals(student.mark) : student.mark != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstName=" + getFirstName() + '\'' +
                ", lastName=" + getLastName() + '\'' +
                ", age=" + getAge() + '\'' +
                ", address=" + getAddress() + '\'' +
                ", faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }
}
