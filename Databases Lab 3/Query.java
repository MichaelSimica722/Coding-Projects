package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Query
{

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String CONN_STRING = "jdbc:mysql://localhost/";

public static void main(String args[]) throws IOException {


    Connection conn = null;
    Statement stmt = null;
    try
    {
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to SQL...");
        conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e){
        //Handle errors for Class.forName
        System.out.println("Fail to connect to the database");
        e.printStackTrace();
    }

    char console_input;
    console_input = (char) System.in.read();


    switch (console_input) {

        default:
            System.out.println("Unknown Option Selected");
            break;
        case '1':
            System.out.println("Create Database Option Selected ");
            System.out.println("Creating database...");
            try {
                stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String user_input = " Example";

            String sql = "CREATE DATABASE" + user_input ;
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Database created successfully...");
            break;
        case '2':
            System.out.println("Second Option Selected ");
            break;
    }

}
}
