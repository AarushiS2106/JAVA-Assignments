import java.util.Scanner;

class AgeNotEligibleException extends Exception {

    public AgeNotEligibleException(String message) {
        super(message);
    }
}

public class Main161 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new AgeNotEligibleException("You are not eligible to vote. Minimum age is 18.");
            }

            System.out.println("You are eligible to vote.");

        } catch (AgeNotEligibleException e) {
            System.out.println("Voting Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}