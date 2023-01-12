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

public class EmployeeFindRoomServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDao employeeDao = new EmployeeDao();
        List<Room> rooms = employeeDao.findBookedRoom();
        HttpSession session = req.getSession();
        session.setAttribute("bookedRooms",rooms);
        resp.sendRedirect("employeeBookedRooms.jsp");
        employeeDao.close();
        return;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
