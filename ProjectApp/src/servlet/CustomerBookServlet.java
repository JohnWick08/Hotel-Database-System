package servlet;

import dao.CustomerDao;
import dao.EmployeeDao;
import tuple.Customer;
import tuple.Employee;
import tuple.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("booksd");
        String endDate = req.getParameter("booked");
        int sinNumber = Integer.parseInt(req.getParameter("sinnumber"));
        String note = req.getParameter("note");
         int roomNumber = Integer.parseInt(req.getParameter("roomnumber"));

        System.out.println(sinNumber);
        System.out.println(startDate+"   !!!!!"+endDate);
        System.out.println(note);
        CustomerDao customerDao = new CustomerDao();


        Room room = customerDao.findRoom(roomNumber);
        System.out.println(room.getHotelID() +"!!!");
        int orderid = customerDao.bookRoom(sinNumber,room.getHotelID(),roomNumber,startDate,endDate,note);
        req.setAttribute("feedback","Book success, Your order id is "+orderid);
        req.getRequestDispatcher("customMain.jsp").forward(req,resp);
        customerDao.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
