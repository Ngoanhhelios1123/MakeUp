package dao;

import model.User;
import java.sql.PreparedStatement;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.beans.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@WebServlet("/register")
public class RegisterDAO extends HttpServlet {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String full_name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            // Kết nối SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "INSERT INTO Users (username, password, full_name, email, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, full_name);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            stmt.setString(6, address);

            int rowsInserted = stmt.executeUpdate();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Đăng ký</title>");
            out.println("</head>");
            out.println("<body>");

            if (rowsInserted > 0) {
                out.println("<h2>Đăng ký thành công!</h2>");
            } else {
                out.println("<h2>Đăng ký thất bại!</h2>");
            }
            //Quay lại về trang đăng nhập
            out.println("<button onclick=\"window.location.href='login and register.html'\">Quay về trang đăng nhập</button>");
            out.println("</body>");
            out.println("</html>");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }

}
