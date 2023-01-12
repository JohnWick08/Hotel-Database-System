<%@ page import="tuple.Room" %>
<%@ page import="java.util.List" %>
<%@ page import="tuple.Person" %><%--
  Created by IntelliJ IDEA.
  User: Binxuan Wu
  Date: 2021/4/1
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Main Page</title>
</head>
<body>
    <p>Hello,
        <%String username = ((Person) session.getAttribute("person")).getUserName();
        if (username != null) {%><%=username%><%}
        %>, you are login as Customer
    </p>

    <form action="searchRoom" method="post">
        Search Room <br>
        Start date: <input type="text" name="startdate" placeholder="YYYY-MM-DD" id="startdate" onchange="getStartDate()"><br>
        End date: <input type="text" name="enddate" placeholder="YYYY-MM-DD" id="enddate" onchange="getEndDate()"><br>
        <button type="submit" onclick="return searchinput()">Search</button><br>
    </form>

    <form action="bookRoom" method="post">
        Book Room <br>
        Enter room number to order <input type="text" name="roomnumber" id="roomnumber"><br>
        <input type="hidden" value="" name="booksd" id="booksd">
        <input type="hidden" value="" name="booked" id="booked">
        <input type="hidden" value="<%=((Person) session.getAttribute("person")).getSinNumber()%>" name="sinnumber"><br>
        Special Note: <input type="text" name="note" id="note"><br>
        <button type="submit" onclick="return bookinput();">Book</button>
    </form>
    <p>
        <%
            String searchfeedback = (String) session.getAttribute("Serachfeedback");
            if (searchfeedback != null) {%>
        <%=searchfeedback%>
        <%}
        %>
    </p>
    <p>
        <%
            String feedback = (String) request.getAttribute("feedback");
            if (feedback != null) {%>
                <%=feedback%>
        <%}
        %>
    </p>
    <ul>
        <%
            List<Room> rooms = (List<Room>) session.getAttribute("rooms");
            if(rooms != null){
                for (Room room: rooms) {%>
                     <li><%=room%></li>
                <%}
            }
        %>
    </ul>

    <script>
        function getStartDate() {
            var startdate = document.getElementById("startdate");
            var bookstartdate = document.getElementById("booksd");
            bookstartdate.value = startdate.value;
        }
    </script>

    <script>
        function getEndDate() {
            var enddate = document.getElementById("enddate");
            var bookenddate = document.getElementById("booked");
            bookenddate.value = enddate.value;
        }
    </script>

    <script>
        function searchinput() {
            var startdate = document.getElementById("startdate")
            var enddate = document.getElementById("enddate")
            if (startdate.value == "") {
                alert("Please enter start date")
                return false
            }
            if (enddate.value == "") {
                alert("please enter end date")
                return false
            }
            return true
        }
    </script>

    <script>
        function bookinput() {
            var roomnumber = document.getElementById("roomnumber")
            var note = document.getElementById("note")
            if (roomnumber.value == "") {
                alert("please enter room number")
                return false
            }
            if (note.value == "") {
                alert("please enter note")
                return false
            }
            if (searchinput() != true) {
                getStartDate()
                getEndDate()
                return true
            }
            return true
        }
    </script>
</body>
</html>
