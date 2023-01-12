package servlet;

import dao.EmployeeDao;
import tuple.Employee;
import tuple.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EmployeeTransWithBookServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderID = Integer.parseInt(req.getParameter("orderID"));
        EmployeeDao employeeDao = new EmployeeDao();
        if (employeeDao.rentBookedRoom(orderID)) {
            req.setAttribute("RentFeedback","Rent Successful");
        }else {
            req.setAttribute("RentFeedback","Not find Order ID");
        }
        req.getRequestDispatcher("employeeMain.jsp").forward(req,resp);
        employeeDao.close();
        return;

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
