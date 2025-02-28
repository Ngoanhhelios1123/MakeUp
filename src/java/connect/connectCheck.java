/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author tuanh
 */
public class connectCheck {

    public static Connection connection;
    public static Scanner scanner = new Scanner(System.in);

    public class Connect {

        private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;trustServerCertificate=true";
        private static final String USERNAME = "sa";
        private static final String PASSWORD = "123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        public static Connection getConnection() {

            Connection conn = null;
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Kết nối thành công");
            } catch (SQLException e) {
                System.out.println("Kết nối thất bại: " + e.getMessage());
            }
            return conn;
        }

    }

    public static void main(String[] args) {
        connection = Connect.getConnection();
        if (connection == null) {
            System.out.println("Kết nối đến cơ sở dữ liệu thất bại!");
            return;
        }
    }
}
