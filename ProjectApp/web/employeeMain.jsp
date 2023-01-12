<%@ page import="tuple.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="tuple.Person" %><%--
  Created by IntelliJ IDEA.
  User: Binxuan Wu
  Date: 2021/4/1
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Main Page</title>
</head>
<body>
    <p>Hello,
        <%String username = ((Person) session.getAttribute("person")).getUserName();
           if (username != null) {%><%=username%><%}
        %>, you are login as Employee
    </p>
    <form action="accessRoom" method="post">
        <button type="submit">Search Available Room</button><br>
    </form>

    <form action="findRoom" method="post">
        <button type="submit">Find Booked Room</button>
    </form>

    <form action="transformRoomWithBook" method="post">
        <h3>Transform booked room into Rented:</h3>
        Order ID: <input type="text" name="orderID" placeholder="(Only Number)" id="orderID"> <br>
        <button type="submit">Transfer room to Rented</button>
    </form>
    <p>
        <%
            String feedback = (String) request.getAttribute("RentFeedback");
            if (feedback != null) {%>
                <%=feedback%>
        <%}
        %>
    </p>

    <form action="transformRoomWithoutBook" method="post">
        <h3>Rent room Without Prior Order:</h3>
        Customer's sinnumber: <input type="text" name="cusSinnum" id="cusSinnum"> <br>
        room Number: <input type="text" name="roomNumber" placeholder="(Only Number)" id="roomNumber"> <br>
        Start date: <input type="text" name="Transtartdate" placeholder="YYYY-MM-DD" id="startdate"><br>
        End date: <input type="text" name="Tranenddate" placeholder="YYYY-MM-DD" id="enddate"><br>
        Special Note:<input type="text" name="spNote">
        <button type="submit">Rent room</button>
    </form>
    <p>
        <%
            String rentFeedback = (String) request.getAttribute("WithoutBookFeedback");
            if (rentFeedback != null) {%>
                <%=rentFeedback%>
        <%}
        %>
    </p>

    <form action="insertPayment" method="post">
        <h3>If the customer finish the payment, Please Enter "Order ID" Above and choose payment type then click "Insert payment"</h3>
        <input type="hidden" value="" name="inOrderID" id="inOrderID">
        <input type="hidden" value="" name="inSin" id="inSin">
        Payment Method: <br>
        Cash: <input type="radio" name="paymentMethod" value="cash" checked>
        Visa: <input type="radio" name="paymentMethod" value="visa"><br>
        <button type="submit" onclick="getRoomNumber()">Insert payment</button>
    </form>
    <p>
        <%
            String paidFeedback = (String) request.getAttribute("PaymentFeedback");
            if (paidFeedback != null) {%>
                <%=paidFeedback%>
        <%}
        %>
    </p>
    <script>
        function getRoomNumber() {
            var orderID = document.getElementById("orderID");
            var inOrderID = document.getElementById("inOrderID");
            var cusSinnum = document.getElementById("cusSinnum");
            var inSin = document.getElementById("inSin");
            inOrderID.value = orderID.value;
            inSin.value = cusSinnum.value;
        }
    </script>
</body>
</html>
