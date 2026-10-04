import java.sql.*;
import java.util.Scanner;

public class Main201 {
    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {
                System.out.println("\n===== EMPLOYEE CRUD SYSTEM =====");
                System.out.println("1. Create Employee");
                System.out.println("2. Read Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter employee name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO employees VALUES (?, ?, ?, ?)"
                    );

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setString(3, department);
                    ps.setDouble(4, salary);

                    ps.executeUpdate();

                    System.out.println("Employee created successfully.");
                    ps.close();

                } else if (choice == 2) {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

                    System.out.println("\n----- EMPLOYEE RECORDS -----");

                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Name: " + rs.getString("name"));
                        System.out.println("Department: " + rs.getString("department"));
                        System.out.println("Salary: Rs." + rs.getDouble("salary"));
                        System.out.println("----------------------------");
                    }

                    rs.close();
                    stmt.close();

                } else if (choice == 3) {
                    System.out.print("Enter employee ID to update: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new salary: ");
                    double salary = sc.nextDouble();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE employees SET salary = ? WHERE id = ?"
                    );

                    ps.setDouble(1, salary);
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();

                    System.out.println(rows > 0
                        ? "Employee updated successfully."
                        : "Employee not found.");

                    ps.close();

                } else if (choice == 4) {
                    System.out.print("Enter employee ID to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM employees WHERE id = ?"
                    );

                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();

                    System.out.println(rows > 0
                        ? "Employee deleted successfully."
                        : "Employee not found.");

                    ps.close();

                } else if (choice == 5) {
                    System.out.println("\nExiting Employee CRUD System...");
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