import java.sql.*;

public class Main212 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            if (con != null) {
                System.out.println("Connection Status: Connected");
                System.out.println("Student database is connected successfully.");
            } else {
                System.out.println("Connection Status: Not Connected");
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}