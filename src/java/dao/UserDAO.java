/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author DELL
 */
public class UserDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public User getUserByUsername(String username) {
        String query = "SELECT [user_id]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[full_name]\n"
                + "      ,[email]\n"
                + "      ,[phone]\n"
                + "      ,[address]\n"
                + "      ,[created_at]\n"
                + "      ,[is_admin]\n"
                + "  FROM [Users]\n"
                + "  WHERE username = ?";
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username); // param vi tri thu 1
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                // chua co created_at
                );
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeResources(conn, ps, rs);
        }
        return null; // ko tim thay
    }
}
