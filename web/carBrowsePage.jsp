<%@ page import="entities.Car" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Opsymonroe
  Date: 27.10.2019
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .selected{
        background-color: blue;
    }
</style>


<html>
<head>
    <title>Browse car</title>
</head>
<body>
    <button id="subBut" onclick="redirect()">open</button>

<table>
    <thead>
    <td>manufacturer</td>
    <td>model</td>
    </thead>
    <tbody>

        <%
            List<Car> cars = (List<Car>) request.getSession().getAttribute("car");
            for(Car car: cars){
                out.println("<tr id='" + car.getId().toString() + "'>");
                out.println("<td>" + car.getManufacturer() + "</td>" );
                out.println("<td>" + car.getModel() + "</td>" );
                out.println("</tr>");
            }
        %>
    </tbody>
</table>
</body>

<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script>
    debugger;
    // let subBut = document.getElementById("subBut");
    // subBut.onclick = function (){
    //     let a = document.getElementsByClassName("selected").item(0);
    //     console.log(a);
    //     console.log(a.id);

        // $.ajax({
        //     url: '/architecturelab1_war_exploded/caredit',
        //     type: "GET",
        //     contentType: "application/json",
        //     data: JSON.stringify({id: a.id})
        // })

        // $.ajax({
        //     url: '/architecturelab1_war_exploded/caredit',
        //     type: "GET",
        //     data: {id: a.id}
        // })
    // };
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

    function redirect() {
        let path = '/architecturelab1_war_exploded/caredit?id=';
        let a = document.getElementsByClassName("selected").item(0);
        path += a.id;
        location.href=path;
    }
</script>
</html>
