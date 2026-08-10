import java.util.Scanner;

interface Printable {
    void print();
}

class Student implements Printable {

    int rollNo;
    String name;
    String course;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    public void print() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
    }
}

class Employee implements Printable {

    int employeeId;
    String name;
    String department;

    Employee(int employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
    }

    public void print() {
        System.out.println("\n----- Employee Details -----");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
    }
}

public class Main111 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Student");
        System.out.println("2. Employee");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {

            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            Printable student = new Student(rollNo, name, course);
            student.print();

        } else if (choice == 2) {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            Printable employee = new Employee(id, name, department);
            employee.print();

        } else {
            System.out.println("Invalid choice!");
        }

        sc.close();
    }
}