
import java.rmi.*;
import java.rmi.registry.*;

public class main283 {
    public static void main(String[] args) {
        try {
            main281 obj = new main282();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost/CalculatorService", obj);

            System.out.println("Calculator Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

