import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

class CourseRegistration {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> registeredCourses = new ArrayList<String>();
        Vector<String> completedCourses = new Vector<String>();

        int choice;

        do {

            System.out.println("\n===== COURSE REGISTRATION SYSTEM =====");
            System.out.println("1. Register Course");
            System.out.println("2. Remove Registered Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. Mark Course as Completed");
            System.out.println("5. View Completed Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Course Name: ");
                    String course = sc.nextLine();

                    registeredCourses.add(course);

                    System.out.println("Course Registered Successfully.");
                    break;

                case 2:

                    if(registeredCourses.isEmpty()) {
                        System.out.println("No Registered Courses.");
                    }
                    else {

                        System.out.print("Enter Course to Remove: ");
                        course = sc.nextLine();

                        if(registeredCourses.remove(course))
                            System.out.println("Course Removed Successfully.");
                        else
                            System.out.println("Course Not Found.");
                    }

                    break;

                case 3:

                    if(registeredCourses.isEmpty()) {
                        System.out.println("No Registered Courses.");
                    }
                    else {

                        StringBuffer sb = new StringBuffer();

                        sb.append("\n----- REGISTERED COURSES -----\n");

                        for(int i = 0; i < registeredCourses.size(); i++) {

                            sb.append(i + 1)
                              .append(". ")
                              .append(registeredCourses.get(i))
                              .append("\n");
                        }

                        System.out.println(sb);
                    }

                    break;

                case 4:

                    if(registeredCourses.isEmpty()) {
                        System.out.println("No Registered Courses.");
                    }
                    else {

                        System.out.print("Enter Completed Course: ");
                        course = sc.nextLine();

                        if(registeredCourses.remove(course)) {

                            completedCourses.add(course);

                            System.out.println("Course Marked as Completed.");
                        }
                        else {
                            System.out.println("Course Not Found.");
                        }
                    }

                    break;

                case 5:

                    if(completedCourses.isEmpty()) {
                        System.out.println("No Completed Courses.");
                    }
                    else {

                        System.out.println("\n----- COMPLETED COURSES -----");

                        for(int i = 0; i < completedCourses.size(); i++) {
                            System.out.println((i + 1) + ". " + completedCourses.get(i));
                        }
                    }

                    break;

                case 6:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        } while(choice != 6);

        sc.close();
    }
}
