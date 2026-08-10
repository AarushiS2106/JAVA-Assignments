import java.io.*;
import java.util.Scanner;

class Employee {

    int employeeId;
    String name;
    double salary;

    Employee(int employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : Rs." + salary);
    }
}

public class Main131 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fileName = "employee.txt";

        while (true) {

            System.out.println("\n===== EMPLOYEE FILE SYSTEM =====");
            System.out.println("1. Write Employee Details");
            System.out.println("2. Read Employee Details");
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

                Employee employee =
                        new Employee(id, name, salary);

                try {

                    FileWriter fw = new FileWriter(fileName);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("Employee ID: " + employee.employeeId);
                    bw.newLine();

                    bw.write("Name: " + employee.name);
                    bw.newLine();

                    bw.write("Salary: Rs." + employee.salary);
                    bw.newLine();

                    bw.close();

                    System.out.println("\nEmployee details written to file successfully!");

                } catch (IOException e) {

                    System.out.println("Error writing to file.");
                }

            } else if (choice == 2) {

                try {

                    FileReader fr = new FileReader(fileName);
                    BufferedReader br = new BufferedReader(fr);

                    String line;

                    System.out.println("\n----- Employee Details From File -----");

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close();

                } catch (FileNotFoundException e) {

                    System.out.println("\nNo employee details found.");
                    System.out.println("Please write employee details first.");

                } catch (IOException e) {

                    System.out.println("Error reading file.");
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Employee File System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
