import java.sql.*;

public class Main192 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");

            System.out.println("\n===== PRODUCT DETAILS =====");

            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Product Name: " + rs.getString("product_name"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: Rs." + rs.getDouble("price"));
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