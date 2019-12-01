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
    <title>Create or edit car</title>
</head>
<body>
<p>
    <%
        Car car = (Car) request.getSession().getAttribute("car");
        String id = car.getId() == null? "" : car.getId().toString();
        String manufacturer = car.getManufacturer() == null? "" : car.getManufacturer();
        String model = car.getModel() == null ? "" : car.getModel();
        Integer doorCount = car.getDoorCount() == null? 3 : car.getDoorCount();
        String modelCode = car.getModelCode() == null ? "" : car.getModelCode();
        Boolean isElectrocar = car.getElectrocar() == null? false : car.getElectrocar();
        String decription = car.getDecription() == null ? "" : car.getDecription();
    %>
</p>
    <form method="post" action="/architecturelab1_war_exploded/caredit">
        <div hidden="true"> <input type="text" name="id" value="<%out.println(id);%>"></div>
        <div>Model: <input type="text" name="model" value="<%out.println(model);%>" required></div>
        <div>Manufacturer: <input type="text" name="manufacturer" value="<%out.println(manufacturer);%>" required> </div>
        <div>Door count: <input type="number" name="doorCount" value="<%out.println(doorCount);%>"> </div>
        <div>Model code: <input type="text" name="modelCode" value="<%out.println(modelCode);%>"> </div>
        <div>Is electrocar: <input type="checkbox" checked=<%out.println(isElectrocar);%> name="isElectrocar""> </div>
        <div>Description: <textarea rows="10" cols="15"><%out.println(decription);%></textarea></div>
        <div><span> <input type="submit" value="Submit"/> </span></div>
    </form>
    <button onclick="location.href = '/architecturelab1_war_exploded/carbrowse'" >Cancel</button>
</body>
</html>
