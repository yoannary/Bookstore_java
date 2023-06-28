package project.classes;

import project.types.EmployeeType;

public class Employee {
    private String name;
    private EmployeeType type;
    private double salary;
    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
        this.salary = type.getSalary();
    }
    public String getName() {
        return name;
    }
    public EmployeeType getType() {
        return type;
    }
    public double getSalary() {
        return salary;
    }
    public void sumEmployeeSalary(double moneyToAdd) {
        this.salary += moneyToAdd;
    }
}
