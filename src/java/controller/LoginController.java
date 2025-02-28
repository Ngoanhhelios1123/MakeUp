/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author DELL
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.setAttribute("errMsg", "Hello sai roi");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("user").trim();
        String password = request.getParameter("pass").trim();

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        System.out.println(user);
        if (user != null) {
            if (password.equals(user.getPassword())) { // login success
                if (username.equals("admin")) {
                    response.sendRedirect("admin.html"); // Đăng nhập admin
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("userName", username);
                    request.getRequestDispatcher("home_page.jsp").forward(request, response);

                }
            } else { // login fail
                request.setAttribute("errMsg", "Sai mật khẩu!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
//                try (PrintWriter out = response.getWriter()) {
//                    out.println("<script type='text/javascript'>");
//                    out.println("alert('Sai tên đăng nhập hoặc mật khẩu!');");
//                    out.println("window.location.href = 'login';");
//                    out.println("</script>");
//                }
            }
        } else { // tai khoan khong ton tai
            request.setAttribute("errMsg", "Tài khoản không tồn tại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
//            try (PrintWriter out = response.getWriter()) {
//                out.println("<script type='text/javascript'>");
//                out.println("alert('tài khoản không tồn tại');");
//                out.println("window.location.href = 'login';");
//                out.println("</script>");
//            }
        }
    }
}
