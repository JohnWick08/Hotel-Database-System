package tuple;

public class HotelChain {
    private String brandName;
    private int hotelID;
    private int numberOfRooms;
    private String address;
    private String contactEmail;
    private int phoneNumber;
    private int star;
    private int managerID;
    private int support_rate;

    public HotelChain(String brandName, int hotelID, int numberOfRooms, String address, String contactEmail, int phoneNumber, int star, int managerID, int support_rate) {
        this.brandName = brandName;
        this.hotelID = hotelID;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
        this.star = star;
        this.managerID = managerID;
        this.support_rate = support_rate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getSupport_rate() {
        return support_rate;
    }

    public void setSupport_rate(int support_rate) {
        this.support_rate = support_rate;
    }

    @Override
    public String toString() {
        return "HotelChain{" +
                "brandName='" + brandName + '\'' +
                ", hotelID=" + hotelID +
                ", numberOfRooms=" + numberOfRooms +
                ", address='" + address + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", star=" + star +
                ", managerID=" + managerID +
                ", support_rate=" + support_rate +
                '}';
    }
}
