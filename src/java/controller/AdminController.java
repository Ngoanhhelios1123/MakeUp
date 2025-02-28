package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BookingService;

@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=MakeUp;encrypt=false";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASS = "123";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    private List<BookingService> getBookingServices() {
        List<BookingService> services = new ArrayList<>();
        String sql = "SELECT service_id, service_name, booking_date, booking_time, quantity, notes, price FROM BookingService";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int serviceId = rs.getInt("service_id");
                String serviceName = rs.getString("service_name");
                String bookingDate = rs.getString("booking_date");
                String bookingTime = rs.getString("booking_time");
                int quantity = rs.getInt("quantity");
                String notes = rs.getString("notes");
                double price = rs.getDouble("price");

                BookingService service = new BookingService(serviceName, bookingDate, bookingTime, quantity, price, notes);
                services.add(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;
    }
}
