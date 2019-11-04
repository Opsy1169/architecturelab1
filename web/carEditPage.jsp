<%@ page import="entities.Car" %>
<%@ page import="java.util.UUID" %><%--
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
        Car car = (Car) request.getSession().getAttribute("car");
        String id = car.getId() == null? "" : car.getId().toString();
        String manufacturer = car.getManufacturer() == null? "" : car.getManufacturer();
        String model = car.getModel() == null ? "" : car.getModel();
    %>
</p>
    <form method="post" action="/architecturelab1_war_exploded/caredit">
        <div hidden="true"> <input type="text" name="id" value="<%out.println(id);%>"></div>
        <div>Model: <input type="text" name="model" value="<%out.println(model);%>"></div>
        <div>Manufacturer: <input type="text" name="manufacturer" value="<%out.println(manufacturer);%>"> </div>
        <div><span> <input type="submit" value="Submit"> <button onclick="location.href = '/architecturelab1_war_exploded/carbrowse'" >Cancel</button></span></div>
    </form>
</body>
</html>
