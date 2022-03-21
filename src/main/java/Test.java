import java.net.InetAddress;

public class Test {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            String ipAddress = inetAddress.getHostAddress();
            System.out.println("IP address: " + ipAddress);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
