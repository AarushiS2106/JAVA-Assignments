import java.util.Scanner;

class FoodOrder {

    String customerName;
    String foodItem;
    int quantity;

    FoodOrder(String customerName, String foodItem, int quantity) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    // Inner Class
    class OrderDetails {

        void display() {
            System.out.println("\n----- Order Details -----");
            System.out.println("Customer Name : " + customerName);
            System.out.println("Food Item     : " + foodItem);
            System.out.println("Quantity      : " + quantity);
        }
    }
}

// Interface for delivery status
interface DeliveryStatus {
    void updateStatus();
}

public class Main62 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodOrder order = null;

        while (true) {

            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");
            System.out.println("1. Place New Order");
            System.out.println("2. View Order Details");
            System.out.println("3. Update Delivery Status");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter Customer Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Enter Food Item: ");
                    String item = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    order = new FoodOrder(customer, item, quantity);

                    System.out.println("\nOrder placed successfully!");

                    break;

                case 2:

                    if (order == null) {

                        System.out.println("\nNo order has been placed yet.");

                    } else {

                        // Creating object of Inner Class
                        FoodOrder.OrderDetails details =
                                order.new OrderDetails();

                        details.display();
                    }

                    break;

                case 3:

                    if (order == null) {

                        System.out.println("\nPlease place an order first.");

                    } else {

                        // Anonymous Class
                        DeliveryStatus status = new DeliveryStatus() {

                            public void updateStatus() {
                                System.out.println(
                                    "\nDelivery Status: Order Delivered Successfully!"
                                );
                            }
                        };

                        status.updateStatus();
                    }

                    break;

                case 4:

                    System.out.println("\nThank you for using the Food Delivery System!");
                    sc.close();
                    return;

                default:

                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
    }
}