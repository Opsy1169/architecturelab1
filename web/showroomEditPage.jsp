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
    <title>Create or edit showroom</title>
</head>
<body>
<p>
    <%
        Showroom showroom = (Showroom) request.getSession().getAttribute("showroom");
        String id = showroom.getId() == null? "" : showroom.getId().toString();
        String name = showroom.getName() == null? "" : showroom.getName();
        String address = showroom.getAddress() == null ? "" : showroom.getAddress();
        String capacity = showroom.getCapacityInCars() == null ? "3" : showroom.getCapacityInCars().toString();
    %>
</p>
<form method="post" action="/architecturelab1_war_exploded/showroomedit">
    <div hidden="true"> <input type="text" name="id" value="<%out.println(id);%>"></div>
    <div>Name: <input type="text" name="name" value="<%out.println(name);%>" required></div>
    <div>Address: <input type="text" name="address" value="<%out.println(address);%>" required> </div>
    <div>Capacity in cars: <input type="number" name="capacity" value="<%=capacity%>" > </div>
    <div><span> <input type="submit" value="Submit"> </span></div>
</form>
<button onclick="location.href = '/architecturelab1_war_exploded/showroombrowse'" >Cancel</button>
</body>
</html>
