package tuple;

public class Registers {
    private int sinNumber;
    private String brandName;

    public Registers(int sinNumber, String brandName) {
        this.sinNumber = sinNumber;
        this.brandName = brandName;
    }

    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Registers{" +
                "sinNumber=" + sinNumber +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
