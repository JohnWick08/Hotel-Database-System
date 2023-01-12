package dao;

import tuple.Customer;
import tuple.Employee;
import tuple.OrderHistory;
import tuple.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao extends Dao{


    public Employee findEmployee(int sin) {
        Employee employee = null;
        try {
            sql = "Select * From public.employee where sinnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, sin);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String responsibilities = result.getString(2);
                String address = result.getString(3);
                int salary = result.getInt(4);
                String myManager = result.getString(5);
                String timeTable = result.getString(6);
                String brandName = result.getString(7);
                String accessLevel = result.getString(8);
                employee = new Employee(sin,responsibilities,address,salary,myManager,timeTable,brandName,accessLevel);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public List<Room> findAvailableRoom (){
        List<Room> rooms = new ArrayList<>();
        try {
            sql = "Select * From public.room WHERE availability = 'yes'";
            preparedStatement = db.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()){
                String brandname = result.getString(1);
                int hotelID = result.getInt(2);
                int roomNumber = result.getInt(3);
                int roomCapacity = result.getInt(4);
                String specialView = result.getString(5);
                String extendable  = result.getString(6);
                String availability = result.getString(7);
                int price = result.getInt(8);
                String amenities = result.getString(9);
                String roomType = result.getString(10);
                String startDate = result.getString(11);
                String endDate = result.getString(12);
                Room room = new Room(brandname,hotelID,roomNumber,roomCapacity,specialView,extendable,availability,price,amenities,roomType,startDate,endDate);
                rooms.add(room);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public List<Room> findBookedRoom(){
        List<Room> rooms = new ArrayList<>();
        try {
            sql = "Select * From public.room where availability = 'booked'";
            preparedStatement = db.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()){
                String brandname = result.getString(1);
                int hotelID = result.getInt(2);
                int roomNumber = result.getInt(3);
                int roomCapacity = result.getInt(4);
                String specialView = result.getString(5);
                String extendable  = result.getString(6);
                String availability = result.getString(7);
                int price = result.getInt(8);
                String amenities = result.getString(9);
                String roomType = result.getString(10);
                String startDate = result.getString(11);
                String endDate = result.getString(12);
                Room room = new Room(brandname,hotelID,roomNumber,roomCapacity,specialView,extendable,availability,price,amenities,roomType,startDate,endDate);
                rooms.add(room);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public OrderHistory findOrder (int orderID) {
        OrderHistory orderHistory = null;
        try {
            sql = "SELECT * From Orderhistory WHERE orderid = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, orderID);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                int sinNumber = result.getInt(2);
                int roomNumber = result.getInt(3);
                int hotelID = result.getInt(4);
                String status = result.getString(5);
                String specialNote = result.getString(6);
                String startDate = result.getString(7);
                String endDate = result.getString(8);
                String isPaid = result.getString(9);
                String paymentMethod = result.getString(10);
                orderHistory = new OrderHistory(orderID,sinNumber,roomNumber,hotelID,status,specialNote,startDate,endDate,isPaid,paymentMethod);
                System.out.println(roomNumber);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistory;
    }

    public Boolean rentBookedRoom (int orderID) {
        try {
            EmployeeDao employeeDao = new EmployeeDao();
            OrderHistory orderHistory = findOrder(orderID);
            if (orderHistory != null) {
                sql = "UPDATE public.Room SET availability = 'rented' WHERE roomnumber = ?;" +
                        "UPDATE public.Orderhistory SET status = 'active' WHERE orderid = ?";
                preparedStatement = db.prepareStatement(sql);
                preparedStatement.setInt(1, orderHistory.getRoomNumber());
                preparedStatement.setInt(2,orderID);
                preparedStatement.execute();
                employeeDao.close();
                return true;
            }else {
                employeeDao.close();
                return false;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int rentRoom (int sinnumber,int roomNumber,String startdate, String enddate,String note) {
        int orderID = -1;
        try {
            sql = "UPDATE public.Room SET availability = 'rented' WHERE roomnumber = ?;" +
                    "INSERT into orderhistory(orderid,sinnumber,roomnumber,hotelid,status,specialnote,startdate,enddate,ispaid,paymentmethod) VALUES (?,?,?,?,'active',?,'"+startdate+"','"+enddate+"','false','null');";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, roomNumber);
            orderID = (int)(Math.random()*999999+10000);
            preparedStatement.setInt(2,orderID);
            preparedStatement.setInt(3, sinnumber);
            preparedStatement.setInt(4, roomNumber);
            EmployeeDao ed = new EmployeeDao();
            int hotelid = ed.findHotel(roomNumber);
            preparedStatement.setInt(5, hotelid);
            preparedStatement.setString(6,note);
            preparedStatement.execute();
            ed.close();
            return orderID;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderID;
    }

    public int findHotel(int roomnumber){
        int hotelid = -1;
        try {
            sql = "SELECT * From public.room where roomnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1,roomnumber);
            result = preparedStatement.executeQuery();
            if(result.next()){
                hotelid = result.getInt(2);
                return hotelid;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelid;
    }
    public Boolean payRoom(int orderID, String method){
         try {
            sql = "UPDATE public.orderHistory SET ispaid = 'true',paymentmethod = ? WHERE orderid = ?";
            preparedStatement = db.prepareStatement(sql);
             preparedStatement.setString(1,method);
            preparedStatement.setInt(2,orderID);
            preparedStatement.executeUpdate();
            return true;
         }catch (SQLException e) {
            e.printStackTrace();
         }
         return false;
}

}
