package project.classes;

import project.common.Constants;
import project.common.EnoughPaperException;
import project.types.EmployeeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingHouse {
    private List<Employee> employees;
    private List<Machine> machines;
    private List<Edition> editions;
    public PrintingHouse() {
        this.employees = new ArrayList<>();
        this.machines = new ArrayList<>();
        this.editions = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    public void addMachine(Machine machine) {
        this.machines.add(machine);
    }
    public void addEdition(Edition edition) {
        this.editions.add(edition);
    }

    public List<Employee> getEmployees() { return employees; }
    public List<Machine> getMachines() { return machines; }
    public List<Edition> getEditions() { return editions; }

    private boolean hasEnoughPaper(Edition edition) {
        int totalPaperRequired = edition.getNumOfPages() * edition.getPageSize();
        for (Machine machine : this.machines) {
            totalPaperRequired -= machine.getLeftPaper();
        }
        return totalPaperRequired <= 0;
    }
    public double calculateIncome() {
        // Calculate the total cost of printing the editions.
        double sumIncome = 0;
        for (Edition edition : this.editions) {
            double sumDiscount = 0;
            double editionPrice = edition.getPricePerPage()* edition.getNumOfPages();
            if (edition.getNumOfPages() > Constants.NUM_OF_PAGES_FOR_DISCOUNT) {
                sumDiscount = editionPrice * Constants.BOOK_DISCOUNT;
            }
            sumIncome += (editionPrice - sumDiscount) * edition.getNumOfMonthlyOrdered();
        }

        return sumIncome;
    }
    public void payEmployees() {
        double totalIncome = this.calculateIncome();
        for (Employee employee : this.employees) {
            employee.sumEmployeeSalary(employee.getSalary());
        }
        // All managers get a bonus if the revenue of the printing house is more than a certain value.
        if (totalIncome > Constants.ALL_INCOME_FOR_BONUS) {
            for (Employee employee : this.employees) {
                if (employee.getType() == EmployeeType.MANAGER) {
                    employee.sumEmployeeSalary(employee.getSalary() * Constants.INCOME_BONUS);
                }
            }
        }
    }

    public void initNumberOfOrders() {
        Scanner input = new Scanner(System.in);
        for (Edition edition : this.editions) {
            System.out.println("Enter number of editions to print for " + edition.getName());
            int numEditionsToPrint = input.nextInt();
            edition.setNumOfMonthlyOrdered(edition.getNumOfMonthlyOrdered() + numEditionsToPrint);
        }
    }

    public void printEditions() throws EnoughPaperException {
        for (Edition edition : this.editions) {
            // Check if there is enough paper to print the edition.
            if (!this.hasEnoughPaper(edition)) {
                throw new EnoughPaperException("Not enough paper for " + edition.getName());
            }

            for (Machine machine : this.machines) {
                machine.printEdition(edition);
            }
        }
    }
}
