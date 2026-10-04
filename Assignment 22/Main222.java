import java.sql.*;
import java.util.Scanner;

public class Main222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter staff type (Doctor/Nurse): ");
            String staffType = sc.nextLine();

            System.out.print("Enter login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            String sql = "SELECT * FROM staff WHERE staff_type = ? AND login_id = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, staffType);
            ps.setString(2, loginId);
            ps.setString(3, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\nAuthentication successful.");
                System.out.println("Access granted to " + staffType + " portal.");
            } else {
                System.out.println("\nAuthentication failed.");
                System.out.println("Access denied. Invalid login details.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}