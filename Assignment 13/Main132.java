import java.io.*;
import java.util.Scanner;

class Patient {

    int patientId;
    String name;
    int age;
    String diagnosis;

    Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    void display() {
        System.out.println("\n----- Patient Details -----");
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Diagnosis  : " + diagnosis);
    }
}

public class Main132 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String fileName = "patient.txt";

        while (true) {

            System.out.println("\n===== PATIENT FILE SYSTEM =====");
            System.out.println("1. Write Patient Details");
            System.out.println("2. Read Patient Details");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("\nEnter Patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Patient Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Patient Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Diagnosis: ");
                String diagnosis = sc.nextLine();

                Patient patient =
                        new Patient(id, name, age, diagnosis);

                try {

                    FileWriter fw = new FileWriter(fileName);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write("Patient ID: " + patient.patientId);
                    bw.newLine();

                    bw.write("Name: " + patient.name);
                    bw.newLine();

                    bw.write("Age: " + patient.age);
                    bw.newLine();

                    bw.write("Diagnosis: " + patient.diagnosis);
                    bw.newLine();

                    bw.close();

                    System.out.println("\nPatient details written to file successfully!");

                } catch (IOException e) {

                    System.out.println("Error writing to file.");
                }

            } else if (choice == 2) {

                try {

                    FileReader fr = new FileReader(fileName);
                    BufferedReader br = new BufferedReader(fr);

                    String line;

                    System.out.println("\n----- Patient Details From File -----");

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                    br.close();

                } catch (FileNotFoundException e) {

                    System.out.println("\nNo patient details found.");
                    System.out.println("Please write patient details first.");

                } catch (IOException e) {

                    System.out.println("Error reading file.");
                }

            } else if (choice == 3) {

                System.out.println("\nExiting Patient File System...");
                break;

            } else {

                System.out.println("\nInvalid choice! Please try again.");
            }
        }

        sc.close();
    }
}