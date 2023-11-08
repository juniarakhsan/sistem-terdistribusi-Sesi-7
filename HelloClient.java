import java.rmi.Naming;

public class HelloClient {
    public static void main(String[] args) {
        try {
            HelloService service = (HelloService) Naming.lookup("rmi://localhost/HelloService");
            String message = service.sayHello();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
