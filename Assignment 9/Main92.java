import java.util.Scanner;

class Book {

    final String isbn;
    String title;
    String author;
    double price;

    Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {

        System.out.println("\n----- Library Book Details -----");
        System.out.println("ISBN   : " + isbn);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : Rs." + price);
    }
}

public class Main92 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book book = null;

        while (true) {

            System.out.println("\n===== LIBRARY BOOK SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Book ISBN: ");
                String isbn = sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Author Name: ");
                String author = sc.nextLine();

                System.out.print("Enter Book Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                book = new Book(isbn, title, author, price);

                System.out.println("\nBook added successfully!");
                System.out.println("ISBN is final and cannot be changed.");

            } else if (choice == 2) {

                if (book == null) {

                    System.out.println("\nNo book has been added.");

                } else {

                    book.displayDetails();
                    System.out.println(
                        "\nISBN is final and cannot be changed."
                    );
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Library Book System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}