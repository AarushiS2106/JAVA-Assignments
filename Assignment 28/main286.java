
import java.rmi.*;
import java.rmi.server.*;

public class main286 extends UnicastRemoteObject
        implements main285 {

    public main286() throws RemoteException {
        super();
    }

    public double toFahrenheit(double celsius)
            throws RemoteException {
        return (celsius * 9 / 5) + 32;
    }
}
