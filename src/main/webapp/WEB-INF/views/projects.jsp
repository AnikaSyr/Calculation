<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Clients</title>
    <style>
        #projects{
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

<div class="container-fluid text-center" id="projects">
    <table id="table" class="table table-hover table-bordered table-striped" >
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date</th>
            <th>Departments</th>
            <th>Products</th>
        </tr>
        </thead>
        <c:forEach items="${projects}" var="project">
        <tbody>
        <tr>
            <td><c:out value = "${project.id}"/></td>
            <td><c:out value = "${project.name}"/></td>
            <td><c:out value = "${project.date}"/></td>
            <td><c:out value = "${project.departments}"/></td>
            <td><c:out value = "${project.productsCopies}"/></td>
            <td>
                <a class = "h6 m-2" href="/project/edit/${project.id}">Edit</a>
                <a class="h6" href="/project/delete/${project.id}">Delete</a>
            </td>
        </tr>
        </tbody>
        </c:forEach>
</div>
</body>
</html>
