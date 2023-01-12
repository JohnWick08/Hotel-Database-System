<%@ page import="tuple.Room" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Binxuan Wu
  Date: 2021/4/3
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booked Rooms</title>
</head>
<body>
<ul>
    <%
        List<Room> rooms = (List<Room>) session.getAttribute("bookedRooms");
        if(rooms != null){
            for (Room room: rooms) {%>
    <li><%=room%></li>
    <%}
    }
    %>
</ul>
</body>
</html>
