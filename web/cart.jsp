<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Giỏ hàng */
        #cart-dropdown {
            position: absolute;
            top: 50px;
            right: 10px;
            background-color: white;
            border: 1px solid #ddd;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            z-index: 1;
            padding: 10px;
            max-width: 300px;
        }
        .cart-item {
            margin-bottom: 10px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <h2>Giỏ Hàng Của Bạn</h2>

        <!-- Nếu giỏ hàng có sản phẩm -->
        <c:if test="${not empty sessionScope.cart}">
            <div class="cart-items">
                <c:forEach var="service" items="${sessionScope.cart.services}">
                    <div class="cart-item">
                        <h5>${service.key.serviceName}</h5>
                        <p>Ngày đặt: ${service.key.bookingDate}</p>
                        <p>Giờ đặt: ${service.key.bookingTime}</p>
                        <p>Số lượng: ${service.value}</p>
                        <hr>
                    </div>
                </c:forEach>
            </div>
        </c:if>

        <!-- Nếu giỏ hàng trống -->
        <c:if test="${empty sessionScope.cart}">
            <p>Giỏ hàng của bạn hiện tại trống.</p>
        </c:if>

        <div class="text-center mt-4">
            <a href="HomePage.jsp" class="btn btn-outline-secondary">Tiếp tục mua sắm</a>
            <a href="checkout.jsp" class="btn btn-primary">Thanh toán</a>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>

</html>
