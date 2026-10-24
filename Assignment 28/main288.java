
import java.rmi.*;
import java.util.Scanner;

public class main288 {
    public static void main(String[] args) {
        try {
            main285 obj = (main285)
                Naming.lookup("rmi://localhost/TemperatureService");

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();

            double fahrenheit = obj.toFahrenheit(celsius);

            System.out.println(
                "Temperature in Fahrenheit: " + fahrenheit
            );

            sc.close();

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
