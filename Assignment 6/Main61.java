import java.util.Scanner;

class Vehicle {

    String name;
    int modelYear;

    // Constructor
    Vehicle(String name, int modelYear) {
        this.name = name;
        this.modelYear = modelYear;
    }

    // Inner Class
    class Details {

        void display() {
            System.out.println("\n----- Vehicle Details -----");
            System.out.println("Vehicle Name : " + name);
            System.out.println("Model Year   : " + modelYear);
        }
    }
}

// Interface
interface Action {
    void perform();
}

public class Main61 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Model Year: ");
        int year = sc.nextInt();

        // Create Vehicle object
        Vehicle v = new Vehicle(name, year);

        // Create Inner Class object
        Vehicle.Details d = v.new Details();
        d.display();

        // Anonymous Class
        Action a = new Action() {

            public void perform() {
                System.out.println("\nVehicle Started Successfully!");
            }
        };

        System.out.println("\nVehicle Action:");
        a.perform();

        sc.close();
    }
}