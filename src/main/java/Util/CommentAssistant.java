package Util;

import org.json.JSONObject;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class CommentAssistant {
    private static String methodName;
    private static String hostName;
    private static String localHostName;
    private static String IP;
    private static String className;
    private static String time;
    private static String packageName;


    public static String addSystemData(String query) {
        HashMap<String, Object> map = new HashMap<>();

        setVariables();

        //Put in the order that they are in the JSON object
        map.putIfAbsent("METHODNAME", methodName);
        map.putIfAbsent("HOST_NAME", hostName);
        map.putIfAbsent("LOCALHOST", localHostName);
        map.putIfAbsent("IP_ADDRESS", IP);
        map.putIfAbsent("CLASSNAME", className);
        map.putIfAbsent("CURRENT_TIME", time);
        map.putIfAbsent("PACKAGENAME", packageName);

        JSONObject json = new JSONObject(map);

        return query.concat("/*" + json + "*/");
    }

    private static void setVariables() {
        // Set all variables
        setHostName();
        setMethodName();
        setClassName();
        setPackageName();
        setTime();
        setIP();
        // OBS must be run after setIP and setHostname
        setLocalHostName();
    }

    private static void setHostName() {
        hostName = "";
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void setIP() {
        IP = "";

        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setLocalHostName() {
        localHostName = hostName + "/" + IP;
    }

    private static void setTime() {
        //The specific format the time should be printed in
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

        //Gets the current time
        LocalDateTime now = LocalDateTime.now();

        time = dtf.format(now);
    }

    private static StackTraceElement getStackTraceElement() {
        return Thread.currentThread().getStackTrace()[5];
    }

    private static void setMethodName() {
        methodName = getStackTraceElement().getMethodName();
    }

    private static void setClassName() {
        className = getStackTraceElement().getClassName();
    }

    private static void setPackageName() {
        Class<?> c = null;

        try {
            c = Class.forName(getStackTraceElement().getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        packageName = c != null ? c.getPackage().getName() : "";
    }

    
    // Getters
    public static String getMethodName() {
        return methodName;
    }

    public static String getClassName() {
        return className;
    }
    
    public static String getPackageName() {
        return packageName;
    }

    public static String getIP() {
        return IP;
    }

    public static String getHostName() {
        return hostName;
    }

    public static String getLocalHostName() {
        return localHostName;
    }
    
    public static String getTime() {
        return time;
    }
}
