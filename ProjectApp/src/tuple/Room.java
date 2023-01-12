package tuple;

public class Room {
    private String brandName;
    private int hotelID;
    private int roomNumber;
    private int roomCapacity;
    private String specialView;
    private String extendable;
    private String availability;
    private int price;
    private String amenities;
    private String roomType;
    private String startDate;
    private String endDate;

    public Room(String brandName, int hotelID, int roomNumber, int roomCapacity, String specialView, String extendable, String availability, int price, String amenities, String roomType, String startDate, String endDate) {
        this.brandName = brandName;
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.specialView = specialView;
        this.extendable = extendable;
        this.availability = availability;
        this.price = price;
        this.amenities = amenities;
        this.roomType = roomType;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getSpecialView() {
        return specialView;
    }

    public void setSpecialView(String specialView) {
        this.specialView = specialView;
    }

    public String getExtendable() {
        return extendable;
    }

    public void setExtendable(String extendable) {
        this.extendable = extendable;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Room{" +
                "brandName='" + brandName + '\'' +
                ",   hotelID=" + hotelID +
                ",   roomNumber=" + roomNumber +
                ",   roomCapacity=" + roomCapacity +
                ",   specialView='" + specialView + '\'' +
                ",   extendable='" + extendable + '\'' +
                ",   availability='" + availability + '\'' +
                ",   price=" + price +
                ",   amenities='" + amenities + '\'' +
                ",   roomType='" + roomType + '\'' +
                ",   startDate='" + startDate + '\'' +
                ",   endDate='" + endDate + '\'' +
                '}';
    }
}

