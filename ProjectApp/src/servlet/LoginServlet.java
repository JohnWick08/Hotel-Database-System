package servlet;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.PersonDao;
import tuple.Customer;
import tuple.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sinNumber = 0;
        int password = 0;
        try {
            sinNumber = Integer.parseInt(req.getParameter("sinnumber"));
            password = Integer.parseInt(req.getParameter("password"));
        }catch (Exception e) {
            req.setAttribute("error", "Incorrect format for sin number or password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        PersonDao personDao = new PersonDao();
        Person person = personDao.findPerson(sinNumber);
        if (person == null) {
            req.setAttribute("error", "Not find person");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            personDao.close();
            return;
        }
        if (password != person.getPassword()){
            req.setAttribute("error", "Incorrect password");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            personDao.close();
            return;
        }
        String role = req.getParameter("userGroup");
        HttpSession session = req.getSession();
        if (role.equals("customer")) {
            CustomerDao customerDao = new CustomerDao();
            if (customerDao.findCustomer(sinNumber) != null) {
                session.setAttribute("person",person);
                resp.sendRedirect("customMain.jsp");
                customerDao.close();
            }else{
                req.setAttribute("error", "Sorry, you are not customer right now");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                personDao.close();
                customerDao.close();
                return;
            }
        }else {
            EmployeeDao employeeDao = new EmployeeDao();
            if (employeeDao.findEmployee(sinNumber) != null) {
                session.setAttribute("person",person);
                resp.sendRedirect("employeeMain.jsp");
                req.getSession().setAttribute("sin",sinNumber);
                personDao.close();
                employeeDao.close();
            }else{
                req.setAttribute("error", "Sorry, you are not employee right now");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                personDao.close();
                employeeDao.close();
                return;
            }
        }
        personDao.close();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
