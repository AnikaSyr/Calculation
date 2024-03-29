<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Project's Calculation</title>
    <style>
        #prj{
            width: 1000px;
            margin: auto;
            margin-top: 100px;
        }

    </style>
    <script type='text/javascript'>
        function eventClick(box) {
            let products=document.getElementsByName("c1");
            var vis = "none";
            for(var i=0;i<products.length;i++) {
                if(products[i].checked){
                    vis = "block";
                    break;
                }
            }
            document.getElementById(box).style.display = vis;



        }
    </script>

</head>
<body class = "container-fluid">


<form:form action="/project/add" method="post" class = "form card" id="prj" modelAttribute="project">
    <h2 class = "bg-gradient text-dark card-header text-xl-center">Add Project's Calculation</h2>
    <table class="table table-hover">
        <tr>
            <td>Project's Name</td>
            <td> <form:input required="required" path="name" /></td>
        </tr>
        <tr>
            <td>Client</td>
            <td> <form:select itemValue="id" itemLabel="name"
                              path="client" items="${clients}"/>

            </td>
        </tr>
        <tr>
            <td>Date of offer</td>
            <td><form:input required="required"  name="date" type = "date" path="date"/></td>
        </tr>
        <tr>

            <td>Department</td>
            <td></td>
            <td></td>
            <td></td>


        </tr>
        <tr id="chk">
            <div class="checkbox-list">


               <c:forEach var="department" items="${departments}" varStatus="loop">

                   <td><b><form:checkbox path="departments" value="${department.id}" label="${department.name}" />
                        </td>

                   <td></td>
                   <td></td>
                   <td></td>
                   <td></td>

    </tr>
        </div>
                   <c:forEach var="product" items="${department.products}" varStatus="loop">


                        <td>  <form:checkbox path="products" value="${product.id}"  />
                               <c:out value="${product.name}"/></td>
                       <td>   <fmt:formatNumber type="number" pattern="0.00 PLN"  value="${product.price}"/>
                           <c:out value=" / ${product.unit}"/></td>
                       <td>Quantity: </td>
                     <td><input type="number" name="params"  /> </td>

                       <td></td>



                       </tr>
                   </c:forEach>



                </c:forEach>


    </table>

    <div class="card-footer d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-outline-dark">Add</button>
        <button type="reset" class="btn btn-outline-dark">Cancel</button>
    </div>

    <form:errors path='*'/>

</form:form>







</body>

</html>



