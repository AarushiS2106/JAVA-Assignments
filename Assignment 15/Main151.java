import java.util.Scanner;

public class Main151 {

    public static void verifyPassword(String password) throws Exception {

        String correctPassword = "java123";

        if (!password.equals(correctPassword)) {
            throw new Exception("Invalid password.");
        }

        System.out.println("Login successful.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            verifyPassword(password);

        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());

        } finally {
            System.out.println("Login process completed.");
            sc.close();
        }
    }
}