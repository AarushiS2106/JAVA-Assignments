import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main242 extends JFrame {
    JTextField bookId, studentName, issueDate, returnDate;
    JTextArea output;

    Main242() {
        setTitle("Book Issue Tracking System");
        setSize(550, 500);
        setLayout(new FlowLayout());

        add(new JLabel("Book ID:"));
        bookId = new JTextField(10);
        add(bookId);

        add(new JLabel("Student Name:"));
        studentName = new JTextField(15);
        add(studentName);

        add(new JLabel("Issue Date:"));
        issueDate = new JTextField(10);
        add(issueDate);

        add(new JLabel("Return Date:"));
        returnDate = new JTextField(10);
        add(returnDate);

        JButton issueButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");

        add(issueButton);
        add(viewButton);
        add(deleteButton);

        output = new JTextArea(15, 45);
        add(new JScrollPane(output));

        issueButton.addActionListener(e -> addRecord());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/library",
            "root",
            "root"
        );
    }

    void addRecord() {
        String sql = "INSERT INTO book_issues VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookId.getText()));
            ps.setString(2, studentName.getText());
            ps.setString(3, issueDate.getText());
            ps.setString(4, returnDate.getText());

            ps.executeUpdate();

            output.setText("Book issue record added successfully.");

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    void viewRecords() {
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM book_issues")) {

            output.setText("----- BOOK ISSUE RECORDS -----\n");

            while (rs.next()) {
                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    " | Student: " + rs.getString("student_name") +
                    " | Issue Date: " + rs.getString("issue_date") +
                    " | Return Date: " + rs.getString("return_date") + "\n"
                );
            }

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    void deleteRecord() {
        String sql = "DELETE FROM book_issues WHERE book_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookId.getText()));

            int rows = ps.executeUpdate();

            output.setText(rows > 0
                ? "Issue record deleted successfully."
                : "Record not found.");

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main242::new);
    }
}