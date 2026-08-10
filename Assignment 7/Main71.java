import java.util.Scanner;

interface Area {
    void calculateArea();
}

class Shape {

    String color;

    Shape(String color) {
        this.color = color;
    }
}

class Circle extends Shape implements Area {

    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void calculateArea() {
        System.out.println("\n----- Circle Details -----");
        System.out.println("Color: " + color);
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + (3.14 * radius * radius));
    }
}

class Rectangle extends Shape implements Area {

    double length;
    double breadth;

    Rectangle(String color, double length, double breadth) {
        super(color);
        this.length = length;
        this.breadth = breadth;
    }

    public void calculateArea() {
        System.out.println("\n----- Rectangle Details -----");
        System.out.println("Color: " + color);
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Area: " + (length * breadth));
    }
}

public class Main71 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== SHAPE MENU =====");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter shape color: ");
                String color = sc.nextLine();

                System.out.print("Enter radius: ");
                double radius = sc.nextDouble();

                Circle c = new Circle(color, radius);
                c.calculateArea();

            } else if (choice == 2) {

                System.out.print("Enter shape color: ");
                String color = sc.nextLine();

                System.out.print("Enter length: ");
                double length = sc.nextDouble();

                System.out.print("Enter breadth: ");
                double breadth = sc.nextDouble();

                Rectangle r = new Rectangle(color, length, breadth);
                r.calculateArea();

            } else if (choice == 3) {

                System.out.println("\nExiting Shape Application...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}