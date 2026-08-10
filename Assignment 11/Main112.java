import java.util.Scanner;

interface Switchable {
    void turnOn();
}

class Light implements Switchable {

    String room;

    Light(String room) {
        this.room = room;
    }

    public void turnOn() {
        System.out.println("\nLight in " + room + " is ON.");
    }
}

class Fan implements Switchable {

    String room;
    int speed;

    Fan(String room, int speed) {
        this.room = room;
        this.speed = speed;
    }

    public void turnOn() {
        System.out.println("\nFan in " + room + " is ON.");
        System.out.println("Fan Speed: " + speed);
    }
}

public class Main112 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== HOME APPLIANCE SYSTEM =====");
            System.out.println("1. Light");
            System.out.println("2. Fan");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Room Name: ");
                String room = sc.nextLine();

                Switchable device = new Light(room);
                device.turnOn();

            } else if (choice == 2) {

                System.out.print("\nEnter Room Name: ");
                String room = sc.nextLine();

                System.out.print("Enter Fan Speed (1-5): ");
                int speed = sc.nextInt();
                sc.nextLine();

                Switchable device = new Fan(room, speed);
                device.turnOn();

            } else if (choice == 3) {

                System.out.println("\nExiting Home Appliance System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}