
<%-- 
    Document   : login
    Created on : Feb 28, 2025, 12:14:41 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOGIN & REGISTER </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .hidden {
                display: none;
            }
        </style>
        <link rel="stylesheet" href="styleLogin.css">
    </head>
    <body>
        <div class="login-wrapper">
            <form action="login" method="POST">
                <div class="container">
                    <h2 class="login-title">LOGIN</h2>
                    <div class="field">
                        <input 
                            type="text" 
                            id="login-username" 
                            name="user" 
                            placeholder="Nhập tài khoản đăng nhập"
                            required
                            >
                        <label for="login-username">Username</label>
                    </div>
                    <div class="field">
                        <input 
                            type="password" 
                            id="login-password" 
                            name="pass" 
                            placeholder="Nhập vào mật khẩu" 
                            required
                            >
                        <label for="login-password">Password</label>
                        <button type="button" id="toggleLoginPassword" class="toggle-password">👁️</button>
                    </div>
                    <div class="field">
                        <p 
                            style="color: red" 
                            <c:if test="${requestScope.errMsg eq null}">
                                hidden
                            </c:if>
                            >${requestScope.errMsg}</p>
                    </div>
                    <input type="submit" value="LOGIN">
                    <p>Không có tài khoản ? <a href="#" id="showRegister">Đăng kí tại đây</a></p>
                </div>
            </form>
        </div>

        <div class="register-wrapper hidden">
            <form action="register" method="post">
                <div class="container">
                    <h2 class="register-title">REGISTER</h2>
                    <div class="field">
                        <input type="text" id="register-username" name="username" placeholder="Nhập tài khoản đăng kí">
                        <label for="register-username">Username</label>
                    </div>
                    <div class="field">
                        <input type="password" id="register-password" name="password" placeholder="Nhập vào mật khẩu đăng kí">
                        <label for="register-password">Password</label>
                        <button type="button" id="toggleRegisterPassword" class="toggle-password">👁️</button>
                    </div>
                    <div class="field">
                        <input type="text" id="fullname" name="fullname" placeholder="Nhập họ và tên">
                        <label for="fullname">Full Name</label>
                    </div>
                    <div class="field">
                        <input type="email" id="email" name="email" placeholder="Nhập địa chỉ email">
                        <label for="email">Email</label>
                    </div>
                    <div class="field">
                        <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại">
                        <label for="phone">Phone</label>
                    </div>
                    <div class="field">
                        <input type="text" id="address" name="address" placeholder="Nhập vào địa chỉ">
                        <label for="address">Address</label>
                    </div>
                    <input type="submit" value="REGISTER">
                    <p>Đã có tài khoản ?<a href="#" id="showLogin">Đăng nhập tại đây</a></p>
                </div>
            </form>
        </div>

        <script>
            document.getElementById("showRegister").addEventListener("click", function () {
                document.querySelector(".login-wrapper").classList.add("hidden");
                document.querySelector(".register-wrapper").classList.remove("hidden");
            });
            document.getElementById("showLogin").addEventListener("click", function () {
                document.querySelector(".register-wrapper").classList.add("hidden");
                document.querySelector(".login-wrapper").classList.remove("hidden");
            });

            document.getElementById("toggleLoginPassword").addEventListener("click", function () {
                let passField = document.getElementById("login-password");
                passField.type = passField.type === "password" ? "text" : "password";
            });

            document.getElementById("toggleRegisterPassword").addEventListener("click", function () {
                let passField = document.getElementById("register-password");
                passField.type = passField.type === "password" ? "text" : "password";
            });
        </script>
    </body>
</html>
