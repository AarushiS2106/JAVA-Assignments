import java.util.Scanner;

class Calculator {

    static int count = 0;

    int add(int a, int b) {
        count++;
        return a + b;
    }

    double add(double a, double b) {
        count++;
        return a + b;
    }

    static void displayCount() {
        System.out.println("Total Calculations Performed: " + count);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator();

        int choice;

        do {
            System.out.println("\n===== CALCULATOR =====");
            System.out.println("1. Add Integers");
            System.out.println("2. Add Decimal Numbers");
            System.out.println("3. Display Total Calculations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter first integer: ");
                    int a = sc.nextInt();

                    System.out.print("Enter second integer: ");
                    int b = sc.nextInt();

                    System.out.println("Sum = " + c.add(a, b));
                    break;

                case 2:
                    System.out.print("Enter first decimal: ");
                    double x = sc.nextDouble();

                    System.out.print("Enter second decimal: ");
                    double y = sc.nextDouble();

                    System.out.println("Sum = " + c.add(x, y));
                    break;

                case 3:
                    displayCount();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while(choice != 4);

        sc.close();
    }
}
