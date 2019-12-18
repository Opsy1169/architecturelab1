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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style><%@include file="resources/common.css"%></style>
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
<form class="form" method="post" action="/architecturelab1_war_exploded/showroomedit">
    <div class="form-group">
    <div hidden="true"> <input class="form-control" type="text" name="id" value="<%out.println(id);%>"></div>
    <div class="input-holder">Name: <input class="form-control" type="text" name="name" value="<%out.println(name);%>" required></div>
    <div class="input-holder">Address: <input class="form-control" type="text" name="address" value="<%out.println(address);%>" required> </div>
    <div class="input-holder">Capacity in cars: <input class="form-control" type="number" name="capacity" value="<%=capacity%>"> </div>
    </div>
    <div class="input-holder"><input class="btn btn-lg btn-default" type="submit" value="Submit"></div>
</form>
<button class="btn btn-lg btn-default" onclick="location.href = '/architecturelab1_war_exploded/showroombrowse'" >Cancel</button>
</body>
</html>
