<%--
  Created by IntelliJ IDEA.
  User: Binxuan Wu
  Date: 2021/3/30
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login Page</title>
  </head>
  <body>
    <form action="loginPage" method="post">
      Sin Number: <input type="text" name="sinnumber"><br>
      Password : <input type="password" name="password" placeholder="(Only numbers)"><br>
      <button type="submit">Log in</button><br>
      User Type: <br>
      Customer <input type="radio" name="userGroup" value="customer" checked><br>
      Employee <input type="radio" name="userGroup" value="employee">
    </form>
    <p>
      <%
        String error = (String) request.getAttribute("error");
        if (error != null) {%>
          <%=error%>
        <%}
      %>
    </p>
  </body>
</html>
