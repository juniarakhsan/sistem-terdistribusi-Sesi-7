import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface HelloService extends Remote {
    String sayHello() throws RemoteException;
}

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    public HelloServiceImpl() throws RemoteException {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello from the server!";
    }

    public static void main(String[] args) {
        try {
            HelloService service = new HelloServiceImpl();
            Naming.rebind("HelloService", service);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}