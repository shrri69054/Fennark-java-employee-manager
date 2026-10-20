import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Employee Manager ===");
            System.out.println("1. Add employee");
            System.out.println("2. List all employees");
            System.out.println("3. Search by department");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            switch (sc.nextLine().trim()) {
                case "1" -> addEmployee();
                case "2" -> listAll();
                case "3" -> searchByDepartment();
                case "4" -> { System.out.println("Goodbye!"); return; }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Name: ");
        String name = sc.nextLine().trim();
        int id = readId();
        for (Employee e : employees) {
            if (e.getId() == id) {
                System.out.println("An employee with that ID already exists.");
                return;
            }
        }
        System.out.print("Department: ");
        String dept = sc.nextLine().trim();
        employees.add(new Employee(name, id, dept));
        System.out.println("Employee added.");
    }

    private static int readId() {
        while (true) {
            System.out.print("ID: ");
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void listAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) System.out.println(e);
    }

    private static void searchByDepartment() {
        System.out.print("Department: ");
        String dept = sc.nextLine().trim();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(dept)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("No employees in that department.");
    }
}
