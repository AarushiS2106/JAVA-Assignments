import java.util.Scanner;

class BankAccount {

    final int accountNumber;
    String accountHolder;
    double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("\n----- Bank Account Details -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class Main91 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankAccount account = null;

        while (true) {

            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Account Number: ");
                int accountNumber = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Account Holder Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Account Balance: ");
                double balance = sc.nextDouble();
                sc.nextLine();

                account = new BankAccount(
                        accountNumber, name, balance
                );

                System.out.println("\nBank account created successfully!");
                System.out.println("Account number is final and cannot be changed.");

            } else if (choice == 2) {

                if (account == null) {

                    System.out.println("\nNo bank account has been created.");

                } else {

                    account.displayDetails();
                    System.out.println(
                        "\nAccount number is final and cannot be changed."
                    );
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Bank Account System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}