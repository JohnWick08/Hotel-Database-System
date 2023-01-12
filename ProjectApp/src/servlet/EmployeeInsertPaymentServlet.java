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

public class EmployeeInsertPaymentServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("inOrderID") != "") {
            int orderID = Integer.parseInt(req.getParameter("inOrderID"));
            String payment = req.getParameter("paymentMethod");
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.payRoom(orderID,payment);
            employeeDao.close();
            req.setAttribute("PaymentFeedback","Paid Successful");
            req.getRequestDispatcher("employeeMain.jsp").forward(req,resp);
            return;
        }else {
            req.setAttribute("PaymentFeedback","Please enter order ID");
            req.getRequestDispatcher("employeeMain.jsp").forward(req,resp);
            return;
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
