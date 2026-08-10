import java.util.Scanner;

class Vehicle {

    String vehicleNumber;
    String vehicleType;
    String ownerName;

    Vehicle(String vehicleNumber, String vehicleType, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
    }

    void displayVehicleDetails() {
        System.out.println("\n----- Vehicle Details -----");
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Owner Name     : " + ownerName);
    }
}

class VehicleInsurance extends Vehicle {

    String insuranceCompany;
    double premium;

    VehicleInsurance(String vehicleNumber, String vehicleType,
                     String ownerName, String insuranceCompany,
                     double premium) {

        super(vehicleNumber, vehicleType, ownerName);

        this.insuranceCompany = insuranceCompany;
        this.premium = premium;
    }

    void displayInsuranceDetails() {

        // Accessing parent class information using super
        super.displayVehicleDetails();

        System.out.println("\n----- Insurance Details -----");
        System.out.println("Insurance Company : " + insuranceCompany);
        System.out.println("Premium           : ₹" + premium);
    }
}

public class Main82 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehicleInsurance insurance = null;

        while (true) {

            System.out.println("\n===== VEHICLE INSURANCE SYSTEM =====");
            System.out.println("1. Add Vehicle Insurance");
            System.out.println("2. Display Insurance Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Vehicle Number: ");
                String number = sc.nextLine();

                System.out.print("Enter Vehicle Type: ");
                String type = sc.nextLine();

                System.out.print("Enter Owner Name: ");
                String owner = sc.nextLine();

                System.out.print("Enter Insurance Company: ");
                String company = sc.nextLine();

                System.out.print("Enter Insurance Premium: ");
                double premium = sc.nextDouble();
                sc.nextLine();

                insurance = new VehicleInsurance(
                        number, type, owner, company, premium
                );

                System.out.println("\nVehicle insurance added successfully!");

            } else if (choice == 2) {

                if (insurance == null) {

                    System.out.println("\nNo insurance details available.");

                } else {

                    insurance.displayInsuranceDetails();
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Vehicle Insurance System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}