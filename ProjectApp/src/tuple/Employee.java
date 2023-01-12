package tuple;

public class Employee {
    private int sinNumber;
    private String responsibilities;
    private String address;
    private int salary;
    private String myManager;
    private String timeTable;
    private String brandName;
    private String accessLevel;

    public Employee(int sinNumber, String responsibilities, String address, int salary, String myManager, String timeTable, String brandName, String accessLevel) {
        this.sinNumber = sinNumber;
        this.responsibilities = responsibilities;
        this.address = address;
        this.salary = salary;
        this.myManager = myManager;
        this.timeTable = timeTable;
        this.brandName = brandName;
        this.accessLevel = accessLevel;
    }

    public int getSinNumber() {
        return sinNumber;
    }

    public void setSinNumber(int sinNumber) {
        this.sinNumber = sinNumber;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getMyManager() {
        return myManager;
    }

    public void setMyManager(String myManager) {
        this.myManager = myManager;
    }

    public String getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(String timeTable) {
        this.timeTable = timeTable;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "sinNumber=" + sinNumber +
                ", responsibilities='" + responsibilities + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", myManager='" + myManager + '\'' +
                ", timeTable='" + timeTable + '\'' +
                ", brandName='" + brandName + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                '}';
    }
}
