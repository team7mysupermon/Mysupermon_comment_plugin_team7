import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class Program {
    
    public static void main(String[] args)
    {
        Connection db = connectDB();

        try {
            db.getSchema();
            db.close();
            if(db.isClosed()) System.out.println("Is closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private static final String url = "jdbc:postgresql://3.127.18.115:5432/Orders_DB?useSSL=false";
    private static final String user = "postgres";
    private static final String password = "devaten@2022";
    public static Connection connectDB()
    {


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(conn.getCatalog());
            System.out.println(conn.getSchema());
            System.out.println(conn.getClientInfo());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    }

