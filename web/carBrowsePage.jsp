<%@ page import="entities.Car" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Opsymonroe
  Date: 27.10.2019
  Time: 13:52
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
    <title>Browse car</title>
</head>
<body>
<div class="button-panel">
    <button class="btn btn-lg btn-default" id="editButton" onclick="redirectToEdit()">Edit</button>
    <button class="btn btn-lg btn-default" id="createButton" onclick="redirectToCreate()">Create</button>
    <button class="btn btn-lg btn-default" id="deleteButton" onclick="deleteShowroom()">Delete</button>
</div>
<table class="table">
    <thead>
    <td>manufacturer</td>
    <td>model</td>
    <td>Door count</td>
    <td>Is electrocar</td>
    <td>Model code</td>
    </thead>
    <tbody>

        <%
            List<Car> cars = (List<Car>) request.getSession().getAttribute("car");
            for(Car car: cars){
                out.println("<tr id='" + car.getId().toString() + "'>");
                out.println("<td>" + (car.getManufacturer()==null ? "" : car.getManufacturer()) + "</td>" );
                out.println("<td>" + (car.getModel() == null ? "" : car.getModel()) + "</td>" );
                out.println("<td>" + (car.getDoorCount() == null ? "": car.getDoorCount()) + "</td>" );
                out.println("<td><input type=\"checkbox\" disabled=\"true\"" + (car.getElectrocar() == null? "":car.getElectrocar()?"checked":"") +  "/></td>" );
                out.println("<td>" + (car.getModelCode() == null ? "" : car.getModelCode()) + "</td>" );
                out.println("</tr>");
            }
        %>
    </tbody>
</table>

    <button class="btn btn-lg btn-default" onclick="location.href = '/architecturelab1_war_exploded'">Back to main</button>
</body>

<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script>
    let customElements = document.querySelectorAll('tbody tr');
    for(let elem of customElements){
        elem.onclick = function () {
            setSelected(elem)
        }
    }
    function setSelected(elem){
        let prevSelected = document.getElementsByClassName("selected");
        if(prevSelected.length > 0) {
            prevSelected.item(0).classList.remove("selected");
        }
        elem.classList.add("selected");
    }

    function redirectToEdit() {
        let path = '/architecturelab1_war_exploded/caredit?id=';
        let a = document.getElementsByClassName("selected").item(0)
        if(!a) return;
        path += a.id;
        location.href=path;
    }

    function redirectToCreate(){
        let path = '/architecturelab1_war_exploded/caredit';
        location.href=path;
    }

    function deleteShowroom(){
        let a = document.getElementsByClassName("selected").item(0)
        if(!a) return;
        $.ajax({
            url: '/architecturelab1_war_exploded/carbrowse',
            type: 'POST',
            data: a.id,
            success: function (result) {
                $(a).hide();
                $(a).removeClass("selected")
            }

        })
    }
</script>
</html>
