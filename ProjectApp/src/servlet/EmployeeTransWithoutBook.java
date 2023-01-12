package servlet;

import dao.EmployeeDao;
import tuple.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeTransWithoutBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int roomNumber = Integer.parseInt(req.getParameter("roomNumber"));
        int sinNumber = Integer.parseInt(req.getParameter("cusSinnum"));
        String stratdate = req.getParameter("Transtartdate");
        String enddate = req.getParameter("Tranenddate");
        String note = req.getParameter("spNote");
        EmployeeDao employeeDao = new EmployeeDao();
        int orderid = employeeDao.rentRoom(sinNumber,roomNumber,stratdate,enddate,note);
        employeeDao.close();
        req.setAttribute("WithoutBookFeedback","Rent successful, Order id is "+orderid);
        req.getRequestDispatcher("employeeMain.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
