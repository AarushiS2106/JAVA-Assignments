import java.util.Scanner;

class StudentMarks {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== STUDENT MARKS SYSTEM ==========");
            System.out.println("1. Calculate Total Marks");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch(choice) {

                case 1:

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks in   Mathematics: ");
                    String mark1 = sc.nextLine();

                    System.out.print("Enter Marks in Physics: ");
                    String mark2 = sc.nextLine();

                    System.out.print("Enter Marks in Chemistry: ");
                    String mark3 = sc.nextLine();

                    // Convert String to Integer
                    int m1 = Integer.parseInt(mark1);
                    int m2 = Integer.parseInt(mark2);
                    int m3 = Integer.parseInt(mark3);

                    int total = m1 + m2 + m3;
                    double average = total / 3.0;

                    System.out.println("\n----- RESULT -----");
                    System.out.println("Student Name : " + name);
                    System.out.println("Mathematics    : " + m1);
                    System.out.println("Physics     : " + m2);
                    System.out.println("Chemistry    : " + m3);
                    System.out.println("Total Marks  : " + total);
                    System.out.println("Average      : " + average);

                    break;

                case 2:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while(choice != 2);

        sc.close();
    }
}