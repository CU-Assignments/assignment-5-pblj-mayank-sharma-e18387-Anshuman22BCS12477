import java.io.*;
import java.util.Scanner;


public class EmployeeManagement {
    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:\n1. Add an Employee\n2. Display All Employees\n3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee(scanner);
                case 2 -> displayEmployees();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 3);
    }

    private static void addEmployee(Scanner scanner) {
        try (ObjectOutputStream oos = new AppendableObjectOutputStream(
                new FileOutputStream(FILE_NAME, true))) {
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();

            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();

            Employee emp = new Employee(id, name, designation, salary);
            oos.writeObject(emp);
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing employee data: " + e.getMessage());
        }
    }

    private static void displayEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Employee Records:");
            while (true) {
                Employee emp = (Employee) ois.readObject();
                System.out.println(emp);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }
    }
}

