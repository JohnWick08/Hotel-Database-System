package dao;

import tuple.Customer;
import tuple.Room;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends Dao{

    public Room findRoom (int roomNumber) {
        Room room = null;
        try {
            sql = "Select * From public.room where roomnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, roomNumber);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                String brandname = result.getString(1);
                int hotelID = result.getInt(2);
                int roomCapacity = result.getInt(4);
                String specialView = result.getString(5);
                String extendable = result.getString(6);
                String availability = result.getString(7);
                int price = result.getInt(8);
                String amenities = result.getString(9);
                String roomType = result.getString(10);
                String startDate = result.getString(11);
                String endDate = result.getString(12);
                room = new Room(brandname, hotelID, roomNumber, roomCapacity, specialView, extendable, availability, price, amenities, roomType, startDate, endDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public Customer findCustomer(int sin) {
        Customer c = null;
        try {
            sql = "Select * From public.customer where sinnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, sin);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                String status = result.getString(2);
                String dateOfRegistration = result.getString(3);
                String bookingDetail = result.getString(4);
                String accessLevel = result.getString(5);
                c = new Customer(sin,status,dateOfRegistration,bookingDetail,accessLevel);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    public List<Room> searchAvailableRoom (String startdate, String enddate) {
        List<Room> rooms = new ArrayList<>();
        try {
            sql = "Select * From public.room where (availability = 'yes' AND ( '"+enddate+"' < startdate OR '"+startdate+"' >enddate))";
            preparedStatement = db.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()) {
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

    public int bookRoom (int sinnumber,int hotelid,int roomnumber, String startdate, String enddate,String note) {
        int orderID = -1;
        try {
            CustomerDao customerDao = new CustomerDao();
            sql = "UPDATE public.Room SET availability = 'booked', startdate = '"+startdate+"', enddate = '"+enddate+"' WHERE roomnumber = ?;" +
                    "INSERT into orderhistory(orderid,sinnumber,roomnumber,hotelid,status,specialnote,startdate,enddate,ispaid,paymentmethod) VALUES (?,?,?,?,'active',?,'"+startdate+"','"+enddate+"','false','null');";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, roomnumber);
            orderID = (int)(Math.random()*999999+10000);
            preparedStatement.setInt(2,orderID);
            preparedStatement.setInt(3, sinnumber);
            preparedStatement.setInt(4, roomnumber);
            preparedStatement.setInt(5, hotelid);
            preparedStatement.setString(6,note);
            preparedStatement.execute();
            customerDao.close();
            return orderID;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return orderID;
    }
}
