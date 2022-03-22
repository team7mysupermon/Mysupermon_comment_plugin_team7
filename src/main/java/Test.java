import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        try {
            //To get the IP address
            InetAddress inetAddress = InetAddress.getLocalHost();

            //Gets the IP address
            String ipAddress = inetAddress.getHostAddress();

            //To get package, class and method name
            Object object = new Object(){};

            //Gets method and class name
            String methodName = object.getClass().getEnclosingMethod().getName();
            String className = object.getClass().getName();

            //The specific format the time should be printed in
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

            //Gets the current time
            LocalDateTime now = LocalDateTime.now();

            //Prints out everything
            System.out.println("IP address: " + ipAddress + "\n" + "Method name: " + methodName);
            System.out.println("Class name: " + className);
            System.out.println(dtf.format(now));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
