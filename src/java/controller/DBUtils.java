package controller;
import java.sql.*;

public class DBUtils {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;encrypt=false;characterEncoding=UTF-8";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
