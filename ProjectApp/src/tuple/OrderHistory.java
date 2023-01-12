package tuple;

public class OrderHistory {
    private int orderID;
    private int sinNumber;
    private int roomNumber;
    private int hotelID;
    private String status;
    private String specialNote;
    private String startdate;
    private String enddate;
    private String isPaid;
    private String paymentMethod;

    public OrderHistory(int orderID, int sinNumber, int roomNumber, int hotelID, String status, String specialNote, String startdate, String enddate, String isPaid, String paymentMethod) {
        this.orderID = orderID;
        this.sinNumber = sinNumber;
        this.roomNumber = roomNumber;
        this.hotelID = hotelID;
        this.status = status;
        this.specialNote = specialNote;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isPaid = isPaid;
        this.paymentMethod = paymentMethod;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
        this.sinNumber = sinNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "orderID=" + orderID +
                ", sinNumber=" + sinNumber +
                ", roomNumber=" + roomNumber +
                ", hotelID=" + hotelID +
                ", status='" + status + '\'' +
                ", specialNote='" + specialNote + '\'' +
                ", startdate='" + startdate + '\'' +
                ", enddate='" + enddate + '\'' +
                ", isPaid='" + isPaid + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
