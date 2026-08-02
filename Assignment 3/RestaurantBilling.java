import java.util.Scanner;

class RestaurantBilling {

    static int totalOrders = 0;

    // Dine-In Bill
    void calculateBill(double amount) {
        totalOrders++;
        System.out.println("\n----- BILL -----");
        System.out.println("Order Type : Dine-In");
        System.out.println("Food Amount: Rs. " + amount);
        System.out.println("Total Bill : Rs. " + amount);
    }

    // Takeaway Bill
    void calculateBill(double amount, boolean takeaway) {
        totalOrders++;
        double packingCharge = 20;

        System.out.println("\n----- BILL -----");
        System.out.println("Order Type      : Takeaway");
        System.out.println("Food Amount     : Rs. " + amount);
        System.out.println("Packing Charge  : Rs. " + packingCharge);
        System.out.println("Total Bill      : Rs. " + (amount + packingCharge));
    }

    // Delivery Bill1
    
    void calculateBill(double amount, double deliveryCharge) {
        totalOrders++;
        System.out.println("\n----- BILL -----");
        System.out.println("Order Type       : Delivery");
        System.out.println("Food Amount      : Rs. " + amount);
        System.out.println("Delivery Charge  : Rs. " + deliveryCharge);
        System.out.println("Total Bill       : Rs. " + (amount + deliveryCharge));
    }

    static void displayTotalOrders() {
        System.out.println("\nTotal Orders Processed = " + totalOrders);
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        RestaurantBilling rb = new RestaurantBilling();

        int choice;

        do {

            System.out.println("\n========== RESTAURANT BILLING ==========");
            System.out.println("1. Dine-In");
            System.out.println("2. Takeaway");
            System.out.println("3. Delivery");
            System.out.println("4. Display Total Orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Food Amount: ");
                    double dineAmount = sc.nextDouble();

                    rb.calculateBill(dineAmount);
                    break;

                case 2:
                    System.out.print("Enter Food Amount: ");
                    double takeAmount = sc.nextDouble();

                    rb.calculateBill(takeAmount, true);
                    break;

                case 3:
                    System.out.print("Enter Food Amount: ");
                    double delAmount = sc.nextDouble();

                    System.out.print("Enter Delivery Charge: ");
                    double deliveryCharge = sc.nextDouble();

                    rb.calculateBill(delAmount, deliveryCharge);
                    break;

                case 4:
                    RestaurantBilling.displayTotalOrders();
                    break;

                case 5:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while(choice != 5);

        sc.close();
    }
}
