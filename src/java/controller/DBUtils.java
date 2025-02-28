package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;encrypt=false;characterEncoding=UTF-8";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException ex) { // loi load driver jdbc
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = DBUtils.getConnection();
            System.out.println(conn);
        } catch (SQLException ex) {
            System.out.println("hehe");
        }
    }
}
