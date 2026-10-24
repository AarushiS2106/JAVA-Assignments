
import java.rmi.*;
import java.rmi.registry.*;

public class main287 {
    public static void main(String[] args) {
        try {
            main285 obj = new main286();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost/TemperatureService", obj);

            System.out.println("Temperature Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
