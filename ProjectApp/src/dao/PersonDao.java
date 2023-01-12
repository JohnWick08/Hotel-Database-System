package dao;

import tuple.Person;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao extends Dao {
    public List<Person> findAllPerson() {
        List<Person> allPerson = new ArrayList<>();
        try {
            sql = "Select * From public.person";
            preparedStatement = db.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                int sinNumber = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String dateOfBirth = result.getString(4);
                String phoneNumber = result.getString(5);
                String userName = result.getString(7);
                int password  = result.getInt(6);
                Person person = new Person(sinNumber,firstName,lastName,dateOfBirth,phoneNumber,password,userName);
                allPerson.add(person);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return allPerson;
    }

    public Person findPerson(int sin) {
        Person p = null;
        try {
            sql = "Select * From public.person where sinnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, sin);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String dateOfBirth = result.getString(4);
                String phoneNumber = result.getString(5);
                String userName = result.getString(7);
                int password  = result.getInt(6);
                p = new Person(sin,firstName,lastName,dateOfBirth,phoneNumber,password,userName);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void addPerson(int sin,String firstName,String lastName,String dateOfBirth,String phoneNumber,int password,String userName) {
        try {
            sql = "Insert into person values(?,?,?,?,?,?,?)";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, sin);
            preparedStatement.setString(2,firstName);
            preparedStatement.setString(3,lastName);
            preparedStatement.setString(4,dateOfBirth);
            preparedStatement.setString(5,phoneNumber);
            preparedStatement.setInt(6,password);
            preparedStatement.setString(7,userName);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePerson(int sin) {
        try{
            sql = "Delete from person where sinnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setInt(1, sin);
            preparedStatement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePerson (int sinNumber, String firstName,String lastName,String dateOfBirth,String phoneNumber,int password,String userName){
        try{
            sql = "Update person set firstname = ? ,lastname = ? ,dateofbirth = ? ,phonenumber = ? ,passwordd = ? ,username = ? where sinnumber = ?";
            preparedStatement = db.prepareStatement(sql);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,lastName);
            preparedStatement.setString(3,dateOfBirth);
            preparedStatement.setString(4,phoneNumber);
            preparedStatement.setInt(5,password);
            preparedStatement.setString(6,userName);
            preparedStatement.setInt(7, sinNumber);
            preparedStatement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
