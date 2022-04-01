import org.json.JSONObject;

import javax.sql.DataSource;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Test extends org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate {
    public Test(DataSource dataSource) {
        super(dataSource);
    }

    public static void main(String[] args) {
        //To get package, class and method name
        Object object = new Object(){};

        String query = "Select * from difar";

        System.out.println(combine(query, object));
    }

    public static String combine(String query, Object classObject) {
        HashMap<String, Object> map = new HashMap<>();

        map.putIfAbsent("METHODNAME", getMethodNameFromException());
        map.putIfAbsent("HOST_NAME", getHostName());
        map.putIfAbsent("LOCALHOST", getLocalHostName());
        map.putIfAbsent("PACKAGENAME", getPackageName(classObject));
        map.putIfAbsent("CLASSNAME", getClassNameFromClassWithNameAsInput("Test"));
        map.putIfAbsent("CURRENT_TIME", getTimeNow());
        map.putIfAbsent("IP_ADDRESS", getIP());

        JSONObject json = new JSONObject(map);

        query = query.concat("/*" + json + "*/");

        return query;
    }

    private static String getLocalHostName() {
        return getHostName() + "/" + getIP();
    }

    private static String getHostName() {
        String value = "";

        try {
            //To get the IP address
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
        String value = "";
        try {
            value = classObject.getClass().getPackage().getName();
        } catch (NullPointerException e) {
            System.out.println("No package found");
        }
        return value;
    }

    private static String getClassName(Object classObject) {
        String value = "";
        try {
            value = classObject.getClass().getName();
        } catch (NullPointerException e) {
            System.out.println("No class found");
        }
        return value;
    }

    private static String getMethodName(Object classObject) {
        String value = "";
        try {
            value = classObject.getClass().getEnclosingMethod().getName();
        } catch (NullPointerException e) {
            System.out.println("No method found");
        }
        return value;
    }

    private static String getMethodNameFromException(){
        String methodName = new Exception().getStackTrace()[2].getMethodName();
        return methodName;
    }

    public static String getClassNameFromException(){
        String className = new Exception().getStackTrace()[0].getClassName();
        String thread = Thread.currentThread().getStackTrace()[3].getClassName();
        return thread;
    }

    public static String getClassNameFromClassWithNameAsInput(String className) {
        Class c = null;

        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return c.getName();
    }
}
