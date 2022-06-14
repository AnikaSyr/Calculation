<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Register</title>
    <style>
        #register{
            width: 500px;
            margin: auto;
            margin-top: 100px;
        }

    </style>
</head>
<body class = "container-fluid">


<form:form action="/user/register" method="post" class = "form card" id="register" modelAttribute="user">
    <h2 class = "bg-gradient text-dark card-header text-xl-center">Register</h2>
    <table class="table table-hover">
        <tr>
            <td>Username</td>
            <td> <form:input  required="required" type="text" path="userName" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td> <form:input  required="required" type="password" path="password" /></td>
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
