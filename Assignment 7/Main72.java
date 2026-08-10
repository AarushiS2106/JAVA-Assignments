import java.util.Scanner;

interface Product {
    void displayDetails();
}

class ProductBase {

    String productName;
    double price;

    ProductBase(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}

class Electronic extends ProductBase implements Product {

    Electronic(String productName, double price) {
        super(productName, price);
    }

    public void displayDetails() {
        System.out.println("\n----- Electronic Product -----");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs." + price);
    }
}

class Clothing extends ProductBase implements Product {

    Clothing(String productName, double price) {
        super(productName, price);
    }

    public void displayDetails() {
        System.out.println("\n----- Clothing Product -----");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs." + price);
    }
}

class Grocery extends ProductBase implements Product {

    Grocery(String productName, double price) {
        super(productName, price);
    }

    public void displayDetails() {
        System.out.println("\n----- Grocery Product -----");
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs." + price);
    }
}

public class Main72 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== E-COMMERCE PRODUCT SYSTEM =====");
            System.out.println("1. Electronic");
            System.out.println("2. Clothing");
            System.out.println("3. Grocery");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter product name: ");
                String name = sc.nextLine();

                System.out.print("Enter product price: ");
                double price = sc.nextDouble();

                Product product = new Electronic(name, price);
                product.displayDetails();

            } else if (choice == 2) {

                System.out.print("Enter product name: ");
                String name = sc.nextLine();

                System.out.print("Enter product price: ");
                double price = sc.nextDouble();

                Product product = new Clothing(name, price);
                product.displayDetails();

            } else if (choice == 3) {

                System.out.print("Enter product name: ");
                String name = sc.nextLine();

                System.out.print("Enter product price: ");
                double price = sc.nextDouble();

                Product product = new Grocery(name, price);
                product.displayDetails();

            } else if (choice == 4) {

                System.out.println("\nExiting E-Commerce Product System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}