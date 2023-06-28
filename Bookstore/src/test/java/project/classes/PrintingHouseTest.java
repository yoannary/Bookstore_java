package project.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.common.EnoughPaperException;
import project.types.EmployeeType;
import project.types.PaperType;
import project.types.SizeType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintingHouseTest {

    @Test
    @DisplayName("Add employee")
    void addEmployee() {
        PrintingHouse printingHouse = new PrintingHouse();
        Employee employee = new Employee("Yoanna", EmployeeType.WORKER);
        List<Employee> updatedList = new ArrayList<>(List.of(employee));
        printingHouse.addEmployee(employee);

        assertNotNull(printingHouse.getEmployees());
        assertEquals(updatedList, printingHouse.getEmployees());
        assertEquals(1, printingHouse.getEmployees().size());
    }



    @Test
    @DisplayName("Add machine")
    void addMachine() {
        PrintingHouse printingHouse = new PrintingHouse();
        Machine machine = new Machine(400);
        List<Machine> updatedList = new ArrayList<>(List.of(machine));
        printingHouse.addMachine(machine);

        assertNotNull(printingHouse.getMachines());
        assertEquals(updatedList, printingHouse.getMachines());
        assertEquals(1, printingHouse.getMachines().size());
    }

    @Test
    @DisplayName("Add edition")
    void addEdition() {
        PrintingHouse printingHouse = new PrintingHouse();
        Edition edition = new Edition("Book", 150, SizeType.A1, PaperType.NORMAL);
        List<Edition> updatedList = new ArrayList<>(List.of(edition));
        printingHouse.addEdition(edition);

        assertNotNull(printingHouse.getEditions());
        assertEquals(updatedList, printingHouse.getEditions());
        assertEquals(1, printingHouse.getEditions().size());
    }

    @Test
    @DisplayName("Calculate Income")
    void calculateIncome() {
        PrintingHouse printingHouse = new PrintingHouse();
        Edition edition = new Edition("Book", 150, SizeType.A1, PaperType.NORMAL, 100);
        printingHouse.addEdition(edition);

        assertEquals(24000, printingHouse.calculateIncome());
    }

    @Test
    @DisplayName("Print editions")
    void printEditions() {
        PrintingHouse printingHouse = new PrintingHouse();
        Machine machine = new Machine(400);
        Edition edition = new Edition("Book", 150, SizeType.A1, PaperType.NORMAL);
        printingHouse.addEdition(edition);
        printingHouse.addMachine(machine);

        try {
            printingHouse.printEditions();
        } catch (EnoughPaperException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(250, machine.getLeftPaper());
    }
}