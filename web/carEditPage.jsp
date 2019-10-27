<%@ page import="entities.Car" %><%--
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
            out.println(car.getModel());
            out.println(car.getManufacturer());
        %>
    </p>
</body>
</html>
