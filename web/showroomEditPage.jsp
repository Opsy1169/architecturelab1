<%@ page import="entities.Car" %>
<%@ page import="java.util.UUID" %>
<%@ page import="entities.Showroom" %><%--
  Created by IntelliJ IDEA.
  User: Opsymonroe
  Date: 27.10.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create edit car</title>
</head>
<body>
<p>
    <%
        Showroom showroom = (Showroom) request.getSession().getAttribute("showroom");
        String id = showroom.getId() == null? "" : showroom.getId().toString();
        String name = showroom.getName() == null? "" : showroom.getName();
        String address = showroom.getAddress() == null ? "" : showroom.getAddress();
    %>
</p>
<form method="post" action="/architecturelab1_war_exploded/showroomedit">
    <div hidden="true"> <input type="text" name="id" value="<%out.println(id);%>"></div>
    <div>Name: <input type="text" name="name" value="<%out.println(name);%>"></div>
    <div>Address: <input type="text" name="address" value="<%out.println(address);%>"> </div>
    <div><span> <input type="submit" value="Submit"> <button onclick="location.href = '/architecturelab1_war_exploded/carbrowse'" >Cancel</button></span></div>
</form>
</body>
</html>
