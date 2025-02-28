/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connect.connectCheck;
import model.BookingService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    public List<BookingService> getAllProduct() {
        List<BookingService> list = new ArrayList<>();
        String query = "Select * from BookingService";
        try {
            conn = connectCheck.Connect.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                list.add(new BookingService(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(7),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void main(String[] args) {
        BookingDAO dao = new BookingDAO();
        List<BookingService> list = dao.getAllProduct();
        for (BookingService o : list) {
            System.out.println(o);
        }
    }
}
