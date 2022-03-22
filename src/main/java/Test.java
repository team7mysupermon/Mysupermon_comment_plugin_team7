import netscape.javascript.JSObject;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        //To get package, class and method name
        Object object = new Object(){};

        String query = "Select * from difar";

        System.out.println(combine(query, object));
    }

    public static String combine(String query, Object classObject) {
        HashMap<String, Object> map = new HashMap<>();

        map.putIfAbsent("METHODNAME", getMethodName(classObject));
        map.putIfAbsent("HOST_NAME", getHostName());
        map.putIfAbsent("LOCALHOST", getLocalHostName());
        map.putIfAbsent("PACKAGENAME", getPackageName(classObject));
        map.putIfAbsent("CLASSNAME", getClassName(classObject));
        map.putIfAbsent("CURRENT_TIME", getTimeNow());
        map.putIfAbsent("IP_ADDRESS", getIP());

        return query + map.toString();
    }

    private static String getLocalHostName() {
        return getHostName() + "/" + getIP();
    }

    private static String getHostName() {
        String value = "";

        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            value = inetAddress.getHostName();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    private static String getIP() {
        String value = "";

        try {
            //To get the IP address
            InetAddress inetAddress = InetAddress.getLocalHost();

            //Gets the IP address
            value = inetAddress.getHostAddress();

        } catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }

    private static String getTimeNow() {
        //The specific format the time should be printed in
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

        //Gets the current time
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    private static String getPackageName(Object classObject) {
        return classObject.getClass().getPackage().getName();
    }

    private static String getClassName(Object classObject) {
        return classObject.getClass().getName();
    }

    private static String getMethodName(Object classObject) {
        return classObject.getClass().getEnclosingMethod().getName();
    }
}
