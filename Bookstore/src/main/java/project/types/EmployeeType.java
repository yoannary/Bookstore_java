package project.types;

public enum EmployeeType {
    WORKER(1200),MANAGER(2500);
    private double salary;
    EmployeeType(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
}
