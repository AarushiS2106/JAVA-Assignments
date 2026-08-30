import java.util.Scanner;

class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Main162 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            if (age < 18) {
                throw new InvalidAgeException("User is not eligible for a driving license.");
            }

            System.out.println("User is eligible for a driving license.");

        } catch (InvalidAgeException e) {
            System.out.println("License Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
