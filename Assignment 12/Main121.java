import java.util.Scanner;
import student.Student;
import faculty.Faculty;

public class Main121 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== COLLEGE MANAGEMENT SYSTEM =====");
            System.out.println("1. Student");
            System.out.println("2. Faculty");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Roll Number: ");
                int rollNo = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                Student student =
                        new Student(rollNo, name, course);

                student.display();

            } else if (choice == 2) {

                System.out.print("\nEnter Faculty ID: ");
                int facultyId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Faculty Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                Faculty faculty =
                        new Faculty(facultyId, name, department);

                faculty.display();

            } else if (choice == 3) {

                System.out.println("\nExiting College Management System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}