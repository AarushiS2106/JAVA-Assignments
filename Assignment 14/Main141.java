import java.util.Scanner;

public class Main141 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 10000;

        try {
            System.out.print("Enter withdrawal amount: ");
            double withdrawal = sc.nextDouble();

            if (withdrawal <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
            }

            if (withdrawal > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            balance = balance - withdrawal;

            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: Rs. " + balance);

        } catch (IllegalArgumentException e) {
            System.out.println("ATM Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input.");

        } finally {
            sc.close();
        }
    }
}