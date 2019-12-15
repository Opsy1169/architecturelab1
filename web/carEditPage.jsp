<%@ page import="entities.Car" %>
<%@ page import="java.util.UUID" %><%--
  Created by IntelliJ IDEA.
  User: Opsymonroe
  Date: 27.10.2019
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style><%@include file="resources/common.css"%></style>
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
        String doorCount = car.getDoorCount() == null? "3" : car.getDoorCount().toString();
        String modelCode = car.getModelCode() == null ? "" : car.getModelCode();
        Boolean isElectrocar = car.getElectrocar() == null? false : car.getElectrocar();
        String decription = car.getDecription() == null ? "" : car.getDecription();
    %>
</p>
    <form class="form" method="post" action="/architecturelab1_war_exploded/caredit">
        <div class="form-group">
            <div hidden="true"> <input type="text" name="id" value="<%out.println(id);%>"></div>
        <div class="input-holder">Model: <input type="text" class="form-control" name="model" value="<%out.println(model);%>" required></div>
        <div class="input-holder">Manufacturer: <input type="text" class="form-control" name="manufacturer" value="<%out.println(manufacturer);%>" required> </div>
        <div class="input-holder">Door count: <input type="number" min="3" max="7" class="form-control" name="doorCount" value=<%=doorCount%>></div>
        <div class="input-holder">Model code: <input type="text" class="form-control" name="modelCode" value="<%out.println(modelCode);%>"> </div>
        <div class="input-holder">Is electrocar: <input type="checkbox" class="form-check-input" checked=<%out.println(isElectrocar);%> name="isElectrocar""> </div>
        <div class="input-holder">Description: <textarea rows="10" class="form-control" cols="15" name="description"><%out.println(decription);%></textarea></div>
        <div><span> <input class="btn btn-lg btn-default" type="submit" value="Submit"/> </span></div>
        </div>
    </form>
    <button class="btn btn-lg btn-default" onclick="location.href = '/architecturelab1_war_exploded/carbrowse'" >Cancel</button>
</body>
</html>
