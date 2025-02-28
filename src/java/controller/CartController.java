package controller;
import controller.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CartController")
public class CartController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String serviceType = request.getParameter("serviceType");
        String bookingDate = request.getParameter("bookingDate");
        String bookingTime = request.getParameter("bookingTime");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String notes = request.getParameter("notes");

        // Lấy username từ session
        HttpSession session = request.getSession(false);
        String userName = (session != null) ? (String) session.getAttribute("userName") : null;

        if (userName == null) { // Kiểm tra session có username không
            response.sendRedirect("login and register.html");
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            conn.setAutoCommit(false);

            // Chèn vào bảng BookingService
            String insertBookingSQL = "INSERT INTO BookingService (service_name, booking_date, booking_time, quantity, notes, price) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertBookingSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, serviceType);
            ps.setString(2, bookingDate);
            ps.setString(3, bookingTime);
            ps.setInt(4, quantity);
            ps.setString(5, notes);
            ps.setDouble(6, getPrice(serviceType)); // Hàm tính giá dịch vụ

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int bookingServiceId = 0;
            if (rs.next()) {
                bookingServiceId = rs.getInt(1);
            }

            // Lấy user_id từ username
            int userId = getUserIdByUsername(conn, userName);
            if (userId == -1) { // Kiểm tra xem user có tồn tại không
                response.sendRedirect("login and register.html");
                return;
            }

            // Chèn vào bảng Cart
            String insertCartSQL = "INSERT INTO Cart (user_id, booking_service_id, quantity, created_at, status) "
                    + "VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(insertCartSQL);
            ps.setInt(1, userId);
            ps.setInt(2, bookingServiceId);
            ps.setInt(3, quantity);
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5, "Pending");

            ps.executeUpdate();
            conn.commit();

            response.sendRedirect("BookingSuccess.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            //response.sendRedirect("BookingError.jsp");
        } finally {
            DBUtils.closeResources(conn, ps, rs);
        }
    }

    // Hàm lấy user_id từ username
    private int getUserIdByUsername(Connection conn, String username) throws SQLException {
        String query = "SELECT user_id FROM Users WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("user_id");
                }
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy user
    }

    // Hàm lấy giá dịch vụ dựa trên loại dịch vụ
    private double getPrice(String serviceType) {
        switch (serviceType) {
            case "Makeup Dự Tiệc":
                return 500000;
            case "Makeup Cô Dâu":
                return 1200000;
            case "Makeup Chụp Ảnh":
                return 800000;
            case "Makeup Dạ Hội":
                return 600000;
            case "Makeup Công Sở":
                return 400000;
            case "Makeup Kỉ Yếu":
                return 300000;
            default:
                return 0;
        }
    }
}
