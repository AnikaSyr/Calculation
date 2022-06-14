<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Project</title>
    <style>
        #projects{
            width: 1000px;
            margin: auto;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class = "alert alert-success text-center">

    <c:out value="${message}"></c:out>

</div>

<div class="container-fluid text-center form card" id="projects">

        <table class="table table-hover" >
            <h2 class = "bg-gradient text-dark card-header text-xl-center" >See Project's Details</h2>
            <tr>
                <td>Project's Name</td>
                <td> <c:out value = "${project.name}"/></td>
            </tr>
            <tr>
                <td>Client</td>
                <td> <c:out value="${project.client.name}"/>

                </td>
            </tr>
            <tr>
                <td>Date of offer</td>
                <td><c:out value = "${project.date}"/></td>
            </tr>
            <tr>

                <td>Department:</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>


            </tr>
            <tr id="chk">



                    <c:forEach items="${project.departments}" var="department" varStatus="loop" >
                      <td> <b><c:out value="${department.name}" /></b></td>

                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>

            </tr>





<c:forEach var="product" items="${department.productsCopies}" varStatus="loop">

    <c:if test="${product.project.id == project.id}">
    <td>    <c:out value="${product.name}"/></td>
    <td>    <fmt:formatNumber type="number" pattern="0.00 PLN" value="${product.price}"/></td>
    <td>    <c:out value="${product.unit}"/></td>
    <td>Quantity: <c:out value="${product.amount}"  /> </td>
    <td>Sum = <fmt:formatNumber type="number" pattern="0.00 PLN" value="${product.price * product.amount}"/></td>
    <td></td>

    </c:if>

    </tr>



            </c:forEach>

            </c:forEach>

</table>
    <div class="card-footer d-grid gap-2 d-md-flex justify-content-md-end">
        <button  class="btn btn-outline-dark" onclick="location.href='/project/edit/${project.id}';">Edit</button>
        <button  class="btn btn-outline-dark" onclick="location.href='/project/delete/${project.id}';">Delete</button>
</div>



</body>
</html>
