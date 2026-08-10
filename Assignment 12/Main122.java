import java.util.Scanner;
import library.Book;

public class Main122 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author Name: ");
                String author = sc.nextLine();

                System.out.print("Enter Book Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                Book book =
                        new Book(id, title, author, price);

                book.display();

            } else if (choice == 2) {

                System.out.println("\nBook details are displayed when the book is added.");

            } else if (choice == 3) {

                System.out.println("\nExiting Library Management System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}
