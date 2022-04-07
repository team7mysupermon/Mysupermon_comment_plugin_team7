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
    private static String finalString;


    public static String addSystemData(String query) {
        HashMap<String, Object> map = new HashMap<>();

        setVariables();

        // Put in the order that they are in the JSON object
        map.putIfAbsent("METHODNAME", methodName);
        map.putIfAbsent("HOST_NAME", hostName);
        map.putIfAbsent("LOCALHOST", localHostName);
        map.putIfAbsent("IP_ADDRESS", IP);
        map.putIfAbsent("CLASSNAME", className);
        map.putIfAbsent("CURRENT_TIME", time);
        map.putIfAbsent("PACKAGENAME", packageName);

        JSONObject json = new JSONObject(map);

        finalString = query.concat("/*" + json + "*/");

        return finalString;
    }

    private static void setVariables() {
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
            System.out.println(e.getMessage());
        }

    }

    private static void setIP() {
        IP = "";

        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void setLocalHostName() {
        localHostName = hostName + "/" + IP;
    }

    private static void setTime() {
        // The specific format the time should be printed in
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");

        // Gets the current time
        LocalDateTime now = LocalDateTime.now();

        time = dtf.format(now);
    }

    private static StackTraceElement getStackTraceElement() {

        Class <?> c;
        var thread = Thread.currentThread();
        var stacktrace = thread.getStackTrace();
        try {

            for (StackTraceElement element : stacktrace) {
                c = Class.forName(element.getClassName());
                var packagename = c.getPackage().getName();
                if (!packagename.equals("Util") && !packagename.equals("NamedJDBC") && !packagename.equals("java.lang")) {
                    return element;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return null;
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
            System.out.println(e.getMessage());
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

    public static String getFinalString() {
        return finalString;
    }
}
