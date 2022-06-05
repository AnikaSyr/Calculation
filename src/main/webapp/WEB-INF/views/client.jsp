<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Client</title>
    <style>
        #client{
            width: 500px;
            margin: auto;
            margin-top: 100px;
        }

    </style>
</head>
<body class = "container-fluid">


<form:form action="/client/add" method="post" class = "form card" id="client" modelAttribute="client">
<h2 class = "bg-gradient text-dark card-header text-xl-center">Add Client</h2>
<table class="table table-hover">
    <tr>
        <td>Name</td>
        <td> <form:input type="text" path="name" /></td>
    </tr>
</table>
    <div class="card-footer d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-outline-dark">Add</button>
        <button type="reset" class="btn btn-outline-dark">Cancel</button>
    </div>

    <form:errors path='*'/>

</form:form>







</body>
</html>
