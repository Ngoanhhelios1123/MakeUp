package model;

import java.util.Date;

public class BookingService {

    private int serviceID;
    private String serviceName;   // Tên dịch vụ
    private Date bookingDate;   // Ngày đặt
    private Date bookingTime;   // Thời gian đặt
    private int quantity;         // Số lượng dịch vụ
    private String notes;         // Ghi chú thêm
    private double price;         // giá cả 

    public BookingService() {
    }

    // dung de add service moi, nen ko can co ID
    public BookingService(String serviceName, Date bookingDate,
            Date bookingTime, int quantity, String notes, double price) {
        this.serviceName = serviceName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.quantity = quantity;
        this.notes = notes;
        this.price = price;
    }

    // get
    public BookingService(int serviceID, String serviceName, Date bookingDate,
            Date bookingTime, int quantity, String notes, double price) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.quantity = quantity;
        this.notes = notes;
        this.price = price;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
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

    public double getToTalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return "BookingService{"
                + "serviceName=" + serviceName
                + ", bookingDate=" + bookingDate
                + ", bookingTime=" + bookingTime
                + ", quantity=" + quantity
                + ", price=" + price
                + ", notes=" + notes
                + '}';
    }

}
