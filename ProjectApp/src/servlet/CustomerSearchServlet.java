package servlet;

import dao.CustomerDao;
import tuple.Customer;
import tuple.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CustomerSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");
        HttpSession session = req.getSession();
        CustomerDao customerDao = new CustomerDao();
        List<Room> rooms = customerDao.searchAvailableRoom(startDate,endDate);
        session.setAttribute("rooms", rooms);
        resp.sendRedirect("customMain.jsp");
        customerDao.close();
        return;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
