import java.util.Scanner;

public class Main152 {

    public static void verifyPIN(int pin) throws Exception {

        int correctPIN = 1234;

        if (pin != correctPIN) {
            throw new Exception("Invalid PIN.");
        }

        System.out.println("PIN verified successfully.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter ATM PIN: ");
            int pin = sc.nextInt();

            verifyPIN(pin);

        } catch (Exception e) {
            System.out.println("Verification Error: " + e.getMessage());

        } finally {
            System.out.println("PIN verification process has completed.");
            sc.close();
        }
    }
}
