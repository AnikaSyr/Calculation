<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Clients</title>
    <style>
        #clients{
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

<div class="container-fluid text-center" id="clients">
<table id="table" class="table table-hover table-bordered table-striped" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <c:forEach items="${clients}" var="client">
    <tbody>
    <tr>
        <td><c:out value = "${client.id}"/></td>
        <td><c:out value = "${client.name}"/></td>
        <td>
            <a class = "h6 m-2" href="/client/edit/${client.id}">Edit</a>
            <a class="h6" href="/client/delete/${client.id}">Delete</a>
        </td>
    </tr>
    </tbody>
</c:forEach>
</div>
</body>
</html>
