import java.util.Scanner;

public class Main142 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new IllegalArgumentException("Product quantity must be greater than zero.");
            }

            System.out.println("Product quantity accepted: " + quantity);

        } catch (IllegalArgumentException e) {
            System.out.println("Shopping Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Invalid input.");

        } finally {
            sc.close();
        }
    }
}