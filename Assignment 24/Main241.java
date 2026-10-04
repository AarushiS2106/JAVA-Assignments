import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main241 extends JFrame {
    JTextField bookId, bookName, author;
    JTextArea output;

    Main241() {
        setTitle("Library Management System");
        setSize(500, 450);
        setLayout(new FlowLayout());

        add(new JLabel("Book ID:"));
        bookId = new JTextField(10);
        add(bookId);

        add(new JLabel("Book Name:"));
        bookName = new JTextField(15);
        add(bookName);

        add(new JLabel("Author:"));
        author = new JTextField(15);
        add(author);

        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        JButton deleteButton = new JButton("Delete Book");

        add(addButton);
        add(viewButton);
        add(deleteButton);

        output = new JTextArea(15, 40);
        add(new JScrollPane(output));

        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
        deleteButton.addActionListener(e -> deleteBook());

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

    void addBook() {
        String sql = "INSERT INTO books VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookId.getText()));
            ps.setString(2, bookName.getText());
            ps.setString(3, author.getText());

            ps.executeUpdate();

            output.setText("Book added successfully.");

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    void viewBooks() {
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {

            output.setText("----- LIBRARY BOOKS -----\n");

            while (rs.next()) {
                output.append(
                    "Book ID: " + rs.getInt("book_id") +
                    " | Book: " + rs.getString("book_name") +
                    " | Author: " + rs.getString("author") + "\n"
                );
            }

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    void deleteBook() {
        String sql = "DELETE FROM books WHERE book_id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(bookId.getText()));

            int rows = ps.executeUpdate();

            output.setText(rows > 0
                ? "Book deleted successfully."
                : "Book not found.");

        } catch (Exception ex) {
            output.setText("Database Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main241::new);
    }
}