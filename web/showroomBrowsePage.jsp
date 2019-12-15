<%@ page import="entities.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Showroom" %><%--
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
    <title>Browse showrooms</title>
</head>
<body>
<button class="btn btn-lg btn-default" id="editButton" onclick="redirectToEdit()">Edit</button>
<button class="btn btn-lg btn-default" id="createButton" onclick="redirectToCreate()">Create</button>
<button class="btn btn-lg btn-default" id="deleteButton" onclick="deleteShowroom()">Delete</button>

<table class="table">
    <thead>
    <td>Name</td>
    <td>Address</td>
    <td>Capacity</td>
    </thead>
    <tbody>

    <%
        List<Showroom> showrooms = (List<Showroom>) request.getSession().getAttribute("showrooms");
        for(Showroom showroom: showrooms){
            out.println("<tr id='" + showroom.getId().toString() + "'>");
            out.println("<td>" + showroom.getName() + "</td>" );
            out.println("<td>" + showroom.getAddress() + "</td>" );
            out.println("<td>" + showroom.getCapacityInCars() + "</td>" );
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
        let path = '/architecturelab1_war_exploded/showroomedit?id=';
        let a = document.getElementsByClassName("selected").item(0)
        if(!a) return;
        path += a.id;
        location.href=path;
    }

    function redirectToCreate(){
        let path = '/architecturelab1_war_exploded/showroomedit';
        location.href=path;
    }

    function deleteShowroom(){
        let a = document.getElementsByClassName("selected").item(0)
        if(!a) return;
        $.ajax({
            url: '/architecturelab1_war_exploded/showroombrowse',
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
