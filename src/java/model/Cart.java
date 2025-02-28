package model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<BookingService, Integer> services; // Lưu trữ dịch vụ và số lượng

    public Cart() {
        this.services = new HashMap<>();
    }

    // Thêm dịch vụ vào giỏ
    public void addService(BookingService service, int aInt) {
        services.put(service, services.getOrDefault(service, 0) + 1);
    }

    // Xóa dịch vụ khỏi giỏ
    public void removeService(BookingService service) {
        services.remove(service);
    }

    // Tính tổng giá trị giỏ hàng
    public double getTotal() {
        double total = 0;
        for (Map.Entry<BookingService, Integer> entry : services.entrySet()) {
            BookingService service = entry.getKey();
            int quantity = entry.getValue();
            total += service.getToTalPrice();
        }
        return total;
    }

    // Kiểm tra giỏ hàng có trống hay không
    public boolean isEmpty() {
        return services.isEmpty();
    }

    // Lấy danh sách dịch vụ trong giỏ
    public Map<BookingService, Integer> getServices() {
        return services;
    }

    // Cập nhật số lượng dịch vụ trong giỏ
    public void updateQuantity(BookingService service, int newQuantity) {
        if (newQuantity <= 0) {
            removeService(service);
        } else {
            services.put(service, newQuantity);
        }
    }
}
