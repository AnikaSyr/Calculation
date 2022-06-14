<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Products</title>
    <style>
        #products{
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

<div class="container-fluid text-center" id="products">
    <table id="table" class="table table-hover table-bordered table-striped" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Unit</th>
            <th>Department Name</th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
        <tbody>
        <tr>
            <td><c:out value = "${product.id}"/></td>
            <td><c:out value = "${product.name}"/></td>
            <td><fmt:formatNumber type="number" pattern="0.00 PLN"  value = "${product.price}"/></td>
            <td><c:out value = "${product.unit}"/></td>
            <td><c:out value = "${product.department.name}"/></td>
            <td>
                <a class = "h6 m-2" href="/product/edit/${product.id}">Edit</a>
                <a class="h6" href="/product/delete/${product.id}">Delete</a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
</div>
</body>
</html>
