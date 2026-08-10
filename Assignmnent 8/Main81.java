import java.util.Scanner;

class Employee {

    String name;
    int employeeId;
    double salary;

    Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : ₹" + salary);
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, int employeeId, double salary, String department) {
        super(name, employeeId, salary);
        this.department = department;
    }

    void displayManagerDetails() {

        // Calling parent class method using super
        super.displayDetails();

        System.out.println("Department  : " + department);
    }
}

public class Main81 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Manager manager = null;

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Manager");
            System.out.println("2. Display Manager Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                manager = new Manager(name, id, salary, department);

                System.out.println("\nManager added successfully!");

            } else if (choice == 2) {

                if (manager == null) {

                    System.out.println("\nNo manager details available.");

                } else {

                    manager.displayManagerDetails();
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Employee Management System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}