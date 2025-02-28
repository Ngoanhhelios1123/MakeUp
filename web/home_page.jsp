<!DOCTYPE html>
<html lang="vi">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <title>Make up, Beauty</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <div>
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
                <div class="container">
                    <!-- Logo -->
                    <a class="navbar-brand" href="#">
                        <img id="logo" src="image/logo.jpg" alt="Logo" height="50">
                    </a>

                    <!-- Nút mở menu trên thiết bị nhỏ -->
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <!-- Nội dung Navbar -->
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item"><a class="nav-link" href="#services">Dịch Vụ</a></li>
                            <li class="nav-item"><a class="nav-link" href="#gallery">Bộ Sưu Tập</a></li>
                            <li class="nav-item"><a class="nav-link" href="#reviews">Đánh Giá</a></li>
                            <li class="nav-item"><a class="nav-link" href="#book">Book Make Up</a></li>
                        </ul>

                        <!-- Thanh tìm kiếm -->
                        <form class="d-flex me-3">
                            <input class="form-control me-2" type="search" placeholder="Tìm kiếm..." aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>

                        <!-- Giỏ hàng -->
                        <a href="#cart" class="btn btn-outline-primary">
                            <i class="fas fa-shopping-cart"></i> Giỏ hàng
                        </a>

                        <% 
                        String userName = (String) session.getAttribute("userName");
                        %>

                        <% if (userName == null) { %>
                        <div class="d-flex">
                            <a href="login and register.html" class="btn btn-outline-secondary me-2">Đăng Nhập/Đăng Kí</a>
                        </div>
                        <% } else { %>
                        <div class="d-flex">
                            <!-- Hiển thị username và khi hover sẽ có tùy chọn đăng xuất -->
                            <div class="dropdown">
                                <button class="btn btn-outline-secondary me-2" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                                    Hello, <%= userName %>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <li><a class="dropdown-item" href="logout.jsp">Đăng Xuất</a></li>
                                </ul>
                            </div>
                        </div>
                        <% } %>

                    </div>
                </div>
            </nav>

            <header class="banner text-center text-white">
                <div class="container">
                    <h1>Makeup Chuyên Nghiệp Cho Mọi Dịp</h1>
                    <p>Biến bạn thành phiên bản xinh đẹp nhất của chính mình!</p>
                    <a href="#book" class="btn btn-primary">Đặt lịch ngay</a>
                </div>
            </header>

            <!-- Dịch vụ -->
            <!-- Dịch vụ nổi bật với carousel -->
            <section id="services" class="container text-center py-5">
                <h2>Dịch Vụ Nổi Bật</h2>

                <div id="serviceCarousel" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">

                        <div class="carousel-item active">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="image/1.jpg" class="img-fluid" alt="Makeup dự tiệc">
                                    <h4>Makeup Dự Tiệc</h4>
                                    <p>Phong cách quyến rũ, sang trọng.</p>
                                    <p><strong>Giá: 500.000 VNĐ</strong></p>
                                </div>
                                <div class="col-md-4">
                                    <img src="image/3.jpg" class="img-fluid" alt="Makeup cô dâu">
                                    <h4>Makeup Cô Dâu</h4>
                                    <p>Trang điểm nhẹ nhàng, tự nhiên.</p>
                                    <p><strong>Giá: 1.200.000 VNĐ</strong></p>
                                </div>
                                <div class="col-md-4">
                                    <img src="image/4.jpg" class="img-fluid" alt="Makeup chụp ảnh">
                                    <h4>Makeup Chụp Ảnh</h4>
                                    <p>Trang điểm chuyên nghiệp cho buổi chụp ảnh.</p>
                                    <p><strong>Giá: 800.000 VNĐ</strong></p>
                                </div>
                            </div>
                        </div>

                        <div class="carousel-item">
                            <div class="row">
                                <div class="col-md-4">
                                    <img src="image/5.jpg" class="img-fluid" alt="Makeup dạ hội">
                                    <h4>Makeup Dạ Hội</h4>
                                    <p>Phong cách cá tính, sắc sảo.</p>
                                    <p><strong>Giá: 600.000 VNĐ</strong></p>
                                </div>
                                <div class="col-md-4">
                                    <img src="image/6.jpg" class="img-fluid" alt="Makeup công sở">
                                    <h4>Makeup Công Sở</h4>
                                    <p>Trang điểm nhẹ nhàng, chuyên nghiệp.</p>
                                    <p><strong>Giá: 400.000 VNĐ</strong></p>
                                </div>
                                <div class="col-md-4">
                                    <img src="image/ky4.jpg" class="img-fluid" alt="Makeup Halloween">
                                    <h4>Makeup Kỉ Yếu</h4>
                                    <p>Phong cách thư sinh, trẻ trung,năng động.</p>
                                    <p><strong>Giá: 300.000 VNĐ</strong></p>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Nút điều hướng -->
                    <button class="carousel-control-prev" type="button" data-bs-target="#serviceCarousel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#serviceCarousel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    </button>
                </div>
            </section>

            <section id="gallery" class="container text-center py-5">
                <h2>Bộ Sưu Tập</h2>
                <div class="row">
                    <div class="col-md-3"><img src="image\bs1.jpg" class="img-fluid"></div>
                    <div class="col-md-3"><img src="image\bst2.jpg" class="img-fluid"></div>
                    <div class="col-md-3"><img src="image\bst3.jpg" class="img-fluid"></div>
                    <div class="col-md-3"><img src="image\bst4.jpg" class="img-fluid"></div>
                </div>
            </section>

            <!-- Đánh giá khách hàng -->
            <section id="reviews" class="container text-center py-5">
                <h2>Đánh Giá Của Khách Hàng</h2>

                <!-- Danh sách đánh giá -->
                <div id="review-list">
                    <p>"Dịch vụ tuyệt vời, makeup rất đẹp và tự nhiên!" - <strong>Ngọc Mai</strong></p>
                    <p>"Chuyên nghiệp và tận tâm, chắc chắn sẽ quay lại!" - <strong>Lan Anh</strong></p>
                </div>

                <!-- Form nhập đánh giá -->
                <form id="review-form" class="mt-3">
                    <div class="mb-3">
                        <input type="text" id="reviewer-name" class="form-control" placeholder="Nhập tên của bạn" required>
                    </div>
                    <div class="mb-3">
                        <textarea id="review-text" class="form-control" rows="3" placeholder="Nhập đánh giá của bạn" required></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Gửi Đánh Giá</button>
                </form>
            </section>

            <script>
                document.getElementById("review-form").addEventListener("submit", function (event) {
                    event.preventDefault();

                    // Lấy dữ liệu từ input
                    var name = document.getElementById("reviewer-name").value;
                    var review = document.getElementById("review-text").value;

                    // Tạo một phần tử đánh giá mới
                    var newReview = document.createElement("p");
                    newReview.innerHTML = "${review}" - <strong>${name}</strong>;

                    // Thêm đánh giá mới vào danh sách
                    document.getElementById("review-list").appendChild(newReview);

                    // Xóa nội dung input sau khi gửi
                    document.getElementById("review-form").reset();
                });
                        </script>

                        <!-- Form Đặt Lịch Makeup -->
                        <form action="CartController" method="post">
                            <div id="book" class="container text-center py-5">
                                <h2>Đặt Lịch Makeup</h2>
                                <div id="booking-form" class="text-start mx-auto" style="max-width: 500px;">
                                    <!-- Chọn dịch vụ -->
                                    <div class="mb-3">
                                        <label for="service-type" class="form-label">Chọn dịch vụ:</label>
                                        <select id="service-type" name="serviceType" class="form-select" required>
                                            <option value="" disabled selected>Chọn dịch vụ</option>
                                            <option value="Makeup Dự Tiệc">Makeup Dự Tiệc</option>
                                            <option value="Makeup Cô Dâu">Makeup Cô Dâu</option>
                                            <option value="Makeup Chụp Ảnh">Makeup Chụp Ảnh</option>
                                            <option value="Makeup Dạ Hội">Makeup Dạ Hội</option>
                                            <option value="Makeup Công Sở">Makeup Công Sở</option>
                                            <option value="Makeup Kỉ Yếu">Makeup Kỉ Yếu</option>
                                        </select>
                                    </div>

                                    <!-- Chọn ngày -->
                                    <div class="mb-3">
                                        <label for="booking-date" class="form-label">Chọn ngày:</label>
                                        <input type="date" id="booking-date" name="bookingDate" class="form-control" required>
                                    </div>

                                    <!-- Chọn giờ -->
                                    <div class="mb-3">
                                        <label for="booking-time" class="form-label">Chọn giờ:</label>
                                        <input type="time" id="booking-time" name="bookingTime" class="form-control" required>
                                    </div>

                                    <!-- Nhập số lượng -->
                                    <div class="mb-3">
                                        <label for="quantity" class="form-label">Số lượng:</label>
                                        <input type="number" id="quantity" name="quantity" class="form-control" min="1" value="1" required>
                                    </div>

                                    <!-- Nhập lưu ý riêng -->
                                    <div class="mb-3">
                                        <label for="notes" class="form-label">Lưu ý riêng:</label>
                                        <textarea id="notes" name="notes" class="form-control" rows="3" placeholder="Nhập lưu ý nếu có"></textarea>
                                    </div>

                                    <button type="submit" class="btn btn-primary w-100">Gửi Yêu Cầu</button>
                                </div>
                            </div>
                        </form>




                        <script>
                            document.getElementById("booking-form").addEventListener("submit", function (event) {
                                event.preventDefault();

                                var serviceType = document.getElementById("service-type").value;
                                var bookingDate = document.getElementById("booking-date").value;
                                var bookingTime = document.getElementById("booking-time").value;
                                var quantity = document.getElementById("quantity").value;
                                var notes = document.getElementById("notes").value || "Không có lưu ý";

                                alert(Bạn đã đặt lịch:\nDịch vụ: ${serviceType}\nNgày: ${bookingDate}\nGiờ: ${bookingTime}\nSố lượng: ${quantity}\nLưu ý: ${notes});
                                        // Xóa nội dung sau khi gửi
                                        document.getElementById("booking-form").reset();
                            });
                            </script>


                            <!-- Footer -->
                            <footer class="bg-light text-center text-lg-start mt-5">
                                <div class="container p-4">
                                    <div class="row">
                                        <!-- Cột thông tin liên hệ -->
                                        <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
                                            <h5 class="text-uppercase">Liên Hệ</h5>
                                            <p>Email: contact@makeupbeauty.com</p>
                                            <p>Hotline: 0123 456 789</p>
                                            <p>Địa chỉ: .......</p>
                                        </div>

                                        <!-- Cột liên kết nhanh -->
                                        <div class="col-lg-4 col-md-6 mb-4 mb-md-0">
                                            <h5 class="text-uppercase">Liên Kết Nhanh</h5>
                                            <ul class="list-unstyled">
                                                <li><a href="#services" class="text-dark">Dịch Vụ</a></li>
                                                <li><a href="#gallery" class="text-dark">Bộ Sưu Tập</a></li>
                                                <li><a href="#reviews" class="text-dark">Đánh Giá</a></li>
                                                <li><a href="#book" class="text-dark">Đặt Lịch</a></li>
                                            </ul>
                                        </div>

                                        <!-- Cột mạng xã hội -->
                                        <div class="col-lg-4 col-md-12 mb-4 mb-md-0">
                                            <h5 class="text-uppercase">Kết Nối Với Chúng Tôi</h5>
                                            <a href="#" class="me-3 text-dark"><i class="fab fa-facebook fa-2x"></i></a>
                                            <a href="#" class="me-3 text-dark"><i class="fab fa-instagram fa-2x"></i></a>
                                            <a href="#" class="me-3 text-dark"><i class="fab fa-twitter fa-2x"></i></a>
                                            <a href="#" class="text-dark"><i class="fab fa-youtube fa-2x"></i></a>
                                        </div>
                                    </div>
                                </div>

                                <!-- Bản quyền -->
                                <div class="text-center p-3 bg-dark text-white">
                                    © 2025 Makeup Beauty. All rights reserved.
                                </div>
                            </footer>

                            </body>
                            </html> 