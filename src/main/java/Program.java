import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
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

    public static Connection connectDB(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * This method inserts a row into an exsisting table.
     * @param conn an connection to a exsisting database.
     * @param tableTitle the title of an exsisting table in the database.
     * @param collumNames names of the collums in the database, where you want to insert data. Must be on form X,Y,Z
     *                    Eg. "ID,NAME,AGE,ADDRESS,SALARY"
     * @param values values matching the collumNames. Must be on form X, Y, Z
     *               Eg. "1, 'Paul', 32, 'California', 20000.00"
     */
    public static void insert(Connection conn, String tableTitle, String collumNames, String values){
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO " + tableTitle + "(" + collumNames + ") VALUES (" + values + ");";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }


    public static void createTable(Connection conn, String tableTitle, String primaryKeyID, String primaryKeyType,TableCollum... collums){

        try {
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE " + tableTitle + " (" + primaryKeyID + " " + primaryKeyType + " PRIMARY KEY     NOT NULL";
            for (TableCollum tc: collums){
                if (tc.Not_Nullable){
                    sql = sql + ", " + tc.name + "           " + tc.type + "    NOT NULL";
                }else {
                    sql = sql + ", " + tc.name + "           " + tc.type;
                }
            }
            sql = sql + ")";

            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    static class TableCollum{
        String name;
        String type;
        boolean Not_Nullable;
        public TableCollum (String _name, String _type, boolean _not_Nullable) {
            this.name = _name;
            this.type = _type;
            this.Not_Nullable = _not_Nullable;
        }
    }


}




