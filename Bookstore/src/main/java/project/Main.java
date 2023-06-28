package project;

import project.classes.Edition;
import project.classes.Employee;
import project.classes.Machine;
import project.classes.PrintingHouse;
import project.types.EmployeeType;
import project.types.PaperType;
import project.types.SizeType;

public class Main {
    public static void main(String[] args) {
        // Create a printing house.
        PrintingHouse printingHouse = new PrintingHouse();

        // Add machines to the printing house.
        printingHouse.addMachine(new Machine(400));
        printingHouse.addMachine(new Machine(400));

        // Add employees to the printing house.
        printingHouse.addEmployee(new Employee("Yoanna", EmployeeType.WORKER));
        printingHouse.addEmployee(new Employee("Pesho", EmployeeType.WORKER));
        printingHouse.addEmployee(new Employee("Maria", EmployeeType.MANAGER));

        // Add editions to the printing house.
        printingHouse.addEdition(new Edition("Book", 150, SizeType.A1, PaperType.NORMAL));
        printingHouse.addEdition(new Edition("Poster", 20, SizeType.A2, PaperType.GLOSSY));
        printingHouse.addEdition(new Edition("Newspaper", 40, SizeType.A4, PaperType.PAPER_FOR_NEWSPAPER));

        printingHouse.initNumberOfOrders();
        // Print the editions.
        try {
            printingHouse.printEditions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Calculate the income
        double income = printingHouse.calculateIncome();
        System.out.println("Income: " + income);

        // We can sum the income
        printingHouse.payEmployees();
    }
}
