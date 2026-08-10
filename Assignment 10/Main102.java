import java.util.Scanner;

abstract class FoodOrder {

    String customerName;
    double price;

    FoodOrder(String customerName, double price) {
        this.customerName = customerName;
        this.price = price;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    double serviceCharge;

    DineInOrder(String customerName, double price, double serviceCharge) {
        super(customerName, price);
        this.serviceCharge = serviceCharge;
    }

    void calculateBill() {

        double total = price + serviceCharge;

        System.out.println("\n----- Dine-In Order -----");
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Food Price     : Rs." + price);
        System.out.println("Service Charge : Rs." + serviceCharge);
        System.out.println("Total Bill     : Rs." + total);
    }
}

class TakeAwayOrder extends FoodOrder {

    double packingCharge;

    TakeAwayOrder(String customerName, double price, double packingCharge) {
        super(customerName, price);
        this.packingCharge = packingCharge;
    }

    void calculateBill() {

        double total = price + packingCharge;

        System.out.println("\n----- Take-Away Order -----");
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Food Price     : Rs." + price);
        System.out.println("Packing Charge : Rs." + packingCharge);
        System.out.println("Total Bill     : Rs." + total);
    }
}

public class Main102 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== FOOD ORDER SYSTEM =====");
            System.out.println("1. Dine-In");
            System.out.println("2. Take-Away");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Food Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Service Charge: ");
                double serviceCharge = sc.nextDouble();
                sc.nextLine();

                FoodOrder order =
                        new DineInOrder(name, price, serviceCharge);

                order.calculateBill();

            } else if (choice == 2) {

                System.out.print("\nEnter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Food Price: ");
                double price = sc.nextDouble();

                System.out.print("Enter Packing Charge: ");
                double packingCharge = sc.nextDouble();
                sc.nextLine();

                FoodOrder order =
                        new TakeAwayOrder(name, price, packingCharge);

                order.calculateBill();

            } else if (choice == 3) {

                System.out.println("\nExiting Food Order System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}