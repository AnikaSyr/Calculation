<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Departments</title>
    <style>
        #dpts{
            width: 500px;
            margin: auto;
            margin-top: 100px;
        }
    </style>
</head>
<body>
<div class = "alert alert-success text-center">

    <c:out value="${message}"></c:out>

</div>

<div class="container-fluid text-center" id="dpts">
    <table id="table" class="table table-hover table-bordered table-striped" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        </thead>
        <c:forEach items="${departments}" var="department">
        <tbody>
        <tr>
            <td><c:out value = "${department.id}"/></td>
            <td><c:out value = "${department.name}"/></td>
            <td>
                <a class = "h6 m-2" href="/department/edit/${department.id}">Edit</a>
                <a class="h6" href="/department/delete/${department.id}">Delete</a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
</div>
</body>
</html>
