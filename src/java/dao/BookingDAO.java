/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.DBUtils;
import model.BookingService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DELL
 */
public class BookingDAO {

    //kết nối với SQL Server
    Connection conn = null;
    //ném câu lệnh query sang SQL server
    PreparedStatement ps = null;
    //nhận kết quả trả về
    ResultSet rs = null;

    public List<BookingService> getAll() {
        List<BookingService> list = new ArrayList<>();
        String query = "SELECT [service_id]\n"
                + "      ,[service_name]\n"
                + "      ,[booking_date]\n"
                + "      ,[booking_time]\n"
                + "      ,[quantity]\n"
                + "      ,[notes]\n"
                + "      ,[price]\n"
                + "  FROM [BookingService]";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookingService service = new BookingService(
                        rs.getInt("service_id"),
                        rs.getString("service_name"),
                        new Date(rs.getDate("booking_date").getTime()),
                        new Date(rs.getTime("booking_time").getTime()),
                        rs.getInt("quantity"),
                        rs.getString("notes"),
                        rs.getDouble("price"));
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BookingService getBookingById(int id) {
        BookingService service = null;
        String query = "SELECT [service_id]\n"
                + "      ,[service_name]\n"
                + "      ,[booking_date]\n"
                + "      ,[booking_time]\n"
                + "      ,[quantity]\n"
                + "      ,[notes]\n"
                + "      ,[price]\n"
                + "  FROM [BookingService]\n"
                + "  WHERE service_id = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id); // param vi tri thu 1
            rs = ps.executeQuery();
            if (rs.next()) {
                service = new BookingService(
                        rs.getInt("service_id"),
                        rs.getString("service_name"),
                        new Date(rs.getDate("booking_date").getTime()),
                        new Date(rs.getTime("booking_time").getTime()),
                        rs.getInt("quantity"),
                        rs.getString("notes"),
                        rs.getDouble("price"));
                return service;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // ko tim thay
    }

    public static void main(String[] args) {
        BookingDAO dao = new BookingDAO();
        List<BookingService> list = dao.getAll();
        for (BookingService o : list) {
            System.out.println(o);
        }

        System.out.println(dao.getBookingById(2));
    }
}
