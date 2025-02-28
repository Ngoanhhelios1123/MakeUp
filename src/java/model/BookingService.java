package model;

public class BookingService {
    private String serviceName;   // Tên dịch vụ
    private String bookingDate;   // Ngày đặt
    private String bookingTime;   // Thời gian đặt
    private int quantity;             // Số lượng dịch vụ
              //giá cả 
    private String notes;         // Ghi chú thêm
    private double price;
    public BookingService() {
    }

    public BookingService(String serviceName, String bookingDate, String bookingTime, int quantity, double price, String notes) {
        this.serviceName = serviceName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.quantity = quantity;
        this.price = price;
        this.notes = notes;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public double getToTalPrice(){
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "BookingService{" + "serviceName=" + serviceName + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime + ", quantity=" + quantity + ", price=" + price + ", notes=" + notes + '}';
    }

   
   
}
