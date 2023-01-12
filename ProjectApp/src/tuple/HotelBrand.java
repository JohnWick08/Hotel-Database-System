package tuple;

public class HotelBrand {
    private String brandName;
    private String physicalLocation;
    private String officeLocation;
    private String email;
    private String phoneNumber;

    public HotelBrand(String brandName, String physicalLocation, String officeLocation, String email, String phoneNumber) {
        this.brandName = brandName;
        this.physicalLocation = physicalLocation;
        this.officeLocation = officeLocation;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getPhysicalLocation() {
        return physicalLocation;
    }

    public void setPhysicalLocation(String physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "HotelBrand{" +
                "brandName='" + brandName + '\'' +
                ", physicalLocation='" + physicalLocation + '\'' +
                ", officeLocation='" + officeLocation + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
