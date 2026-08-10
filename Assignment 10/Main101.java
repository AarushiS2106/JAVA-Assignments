import java.util.Scanner;

abstract class Payment {

    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract void makePayment();

    void displayAmount() {
        System.out.println("Payment Amount: Rs." + amount);
    }
}

class CreditCard extends Payment {

    String cardNumber;

    CreditCard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    void makePayment() {
        System.out.println("\nPayment Method: Credit Card");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Payment Successful!");
    }
}

class UPI extends Payment {

    String upiId;

    UPI(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    void makePayment() {
        System.out.println("\nPayment Method: UPI");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Payment Successful!");
    }
}

public class Main101 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== PAYMENT SYSTEM =====");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Payment Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Card Number: ");
                String cardNumber = sc.nextLine();

                Payment payment = new CreditCard(amount, cardNumber);

                System.out.println();
                payment.displayAmount();
                payment.makePayment();

            } else if (choice == 2) {

                System.out.print("\nEnter Payment Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                Payment payment = new UPI(amount, upiId);

                System.out.println();
                payment.displayAmount();
                payment.makePayment();

            } else if (choice == 3) {

                System.out.println("\nExiting Payment System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}