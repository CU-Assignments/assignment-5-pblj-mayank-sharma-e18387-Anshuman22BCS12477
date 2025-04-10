// File: Employee.java
import java.io.Serializable;

public class Employee implements Serializable {
    private int empId;
    private String name;
    private String designation;
    private double salary;

    public Employee(int empId, String name, String designation, double salary) {
        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + empId +
                ", Name: " + name +
                ", Designation: " + designation +
                ", Salary: " + salary;
    }
}
