package hust.hieutm.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtils {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/myblog";
    private static String username = "root";
    private static String password = "020304";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection con){
        if (con != null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void rollback(Connection con){
        try {
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
