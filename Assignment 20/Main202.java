import java.sql.*;
import java.util.Scanner;

public class Main202 {
    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== STUDENT CRUD SYSTEM =====");
                System.out.println("1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter marks: ");
                    double marks = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO students VALUES (?, ?, ?, ?)"
                    );

                    ps.setInt(1, roll);
                    ps.setString(2, name);
                    ps.setString(3, course);
                    ps.setDouble(4, marks);

                    ps.executeUpdate();

                    System.out.println("Student created successfully.");
                    ps.close();

                } else if (choice == 2) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM students");

                    System.out.println("\n----- STUDENT RECORDS -----");

                    while (rs.next()) {
                        System.out.println("Roll No: " + rs.getInt("roll_no"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Course: " + rs.getString("course"));
                        System.out.println("Marks: " + rs.getDouble("marks"));
                        System.out.println("---------------------------");
                    }

                    rs.close();
                    stmt.close();

                } else if (choice == 3) {
                    System.out.print("Enter roll number to update: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter new marks: ");
                    double marks = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET name = ?, course = ?, marks = ? WHERE roll_no = ?"
                    );

                    ps.setString(1, name);
                    ps.setString(2, course);
                    ps.setDouble(3, marks);
                    ps.setInt(4, roll);

                    int rows = ps.executeUpdate();

                    System.out.println(rows > 0
                        ? "Student updated successfully."
                        : "Student not found.");

                    ps.close();

                } else if (choice == 4) {
                    System.out.print("Enter roll number to delete: ");
                    int roll = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM students WHERE roll_no = ?"
                    );

                    ps.setInt(1, roll);

                    int rows = ps.executeUpdate();

                    System.out.println(rows > 0
                        ? "Student deleted successfully."
                        : "Student not found.");

                    ps.close();

                } else if (choice == 5) {
                    System.out.println("\nExiting Student CRUD System...");
                    break;

                } else {
                    System.out.println("\nInvalid choice! Please try again.");
                }
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}