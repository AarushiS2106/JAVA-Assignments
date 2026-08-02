import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<String>();

        int choice;

        do {

            System.out.println("\n========== TO-DO LIST ==========");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter Task: ");
                    String task = sc.nextLine();

                    tasks.add(task);

                    System.out.println("Task Added Successfully.");
                    break;

                case 2:

                    if(tasks.isEmpty()) {
                        System.out.println("No Tasks Available.");
                    }
                    else {

                        System.out.print("Enter Task to Remove: ");
                        task = sc.nextLine();

                        if(tasks.remove(task))
                            System.out.println("Task Removed Successfully.");
                        else
                            System.out.println("Task Not Found.");
                    }

                    break;

                case 3:

                    if(tasks.isEmpty()) {
                        System.out.println("No Tasks Available.");
                    }
                    else {

                        StringBuffer sb = new StringBuffer();

                        sb.append("\n------ TO-DO LIST ------\n");

                        for(int i = 0; i < tasks.size(); i++) {
                            sb.append(i + 1)
                              .append(". ")
                              .append(tasks.get(i))
                              .append("\n");
                        }

                        System.out.println(sb);
                    }

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
