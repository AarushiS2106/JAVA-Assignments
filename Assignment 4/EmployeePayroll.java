import java.util.Scanner;

class EmployeePayroll {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n========== EMPLOYEE PAYROLL SYSTEM ==========");
            System.out.println("1. Calculate Net Salary");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch(choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    Integer empId = Integer.valueOf(sc.nextLine());

                    System.out.print("Enter Employee Name: ");
                    String empName = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    Double basicSalary = Double.valueOf(sc.nextLine());

                    System.out.print("Enter Bonus: ");
                    Double bonus = Double.valueOf(sc.nextLine());

                    // Validation
                    if (basicSalary <= 0) {
                        System.out.println("Error: Basic Salary must be greater than 0.");
                    }
                    else if (bonus < 0) {
                        System.out.println("Error: Bonus cannot be negative.");
                    }
                    else {

                        Double netSalary = basicSalary + bonus;

                        System.out.println("\n========== EMPLOYEE PAYSLIP ==========");
                        System.out.println("Employee ID   : " + empId);
                        System.out.println("Employee Name : " + empName);
                        System.out.println("Basic Salary  : Rs. " + basicSalary);
                        System.out.println("Bonus         : Rs. " + bonus);
                        System.out.println("--------------------------------------");
                        System.out.println("Net Salary    : Rs. " + netSalary);
                    }

                    break;

                case 2:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");

            }

        } while(choice != 2);

        sc.close();
    }
}
