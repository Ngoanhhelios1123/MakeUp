<%-- 
    Document   : logout
    Created on : Feb 26, 2025, 10:09:24 PM
    Author     : tuanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
    
    session.invalidate();
    
    response.sendRedirect("HomePage.jsp");
%>
    </body>
</html>
