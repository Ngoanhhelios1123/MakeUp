package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginDAO extends HttpServlet {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (user.equals("admin") && pass.equals("123")) {
            response.sendRedirect("admin.html"); // Đăng nhập admin
        } else if (isValidUser(user, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user);
            response.sendRedirect("HomePage.jsp");
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>");
                out.println("alert('Sai tên đăng nhập hoặc mật khẩu!');");
                out.println("window.location.href = 'login and register.html';");
                out.println("</script>");
            }
        }
    }

    private boolean isValidUser(String username, String password) {
        boolean isValid = false;
        try {
            // Kết nối SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Kiểm tra tài khoản trong DB
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                isValid = true; // Tìm thấy tài khoản hợp lệ
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
