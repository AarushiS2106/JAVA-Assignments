import java.sql.*;

public class Main191 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("\n===== STUDENT RECORDS =====");

            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("Marks: " + rs.getDouble("marks"));
                System.out.println("---------------------------");
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
