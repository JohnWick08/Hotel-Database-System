package tuple;

public class Customer {
    private int sinNumber;
    private String status;
    private String dateOfRegistration;
    private String bookingDetail;
    private String accessLevel;

    public Customer(int sinNumber, String status, String dateOfRegistration, String bookingDetail, String accessLevel) {
        this.sinNumber = sinNumber;
        this.status = status;
        this.dateOfRegistration = dateOfRegistration;
        this.bookingDetail = bookingDetail;
        this.accessLevel = accessLevel;
    }

    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getBookingDetail() {
        return bookingDetail;
    }

    public void setBookingDetail(String bookingDetail) {
        this.bookingDetail = bookingDetail;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "sinNumber=" + sinNumber +
                ", status='" + status + '\'' +
                ", dateOfRegistration='" + dateOfRegistration + '\'' +
                ", bookingDetail='" + bookingDetail + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}
