import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

public class Program {
    
    public static void main(String[] args)
    {
        Connection db = connectDB();

        if (db == null) 
        {
            System.out.println("database is null");
            return;
        }
    }

    public static Connection connectDB()
    {
        String url = "jdbc:postgresql://3.127.18.115/Orders_DB";

        Properties props = new Properties();
        props.setProperty("allowPublicKeyRetrieval", "true");
        props.setProperty("user","postgres");
        props.setProperty("password","devaten@2022");
        props.setProperty("ssl","false");
        props.setProperty("serverTimezone", "UTC");

        Connection conn;

        try {

            conn = DriverManager.getConnection(url, props);
            System.out.println("Connection established");
            return conn;

        } catch (Exception e) {

            e.getStackTrace();
            return null;

        }
    }

}
