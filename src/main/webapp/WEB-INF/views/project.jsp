<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body class = "container-fluid">


<form:form action="/project/add" method="post" class = "form card" id="prj" modelAttribute="project">
    <h2 class = "bg-gradient text-dark card-header text-xl-center">Add Project's Calculation</h2>
    <table class="table table-hover">
        <tr>
            <td>Project's Name</td>
            <td> <form:input path="name" /></td>
        </tr>
        <tr>
            <td>Client</td>
            <td> <form:select itemValue="id" itemLabel="name"
                              path="client" items="${clients}"/>

            </td>
        </tr>
        <tr>
            <td>Date of offer</td>
            <td><form:input name="date" type = "date" path="date"/></td>

        <tr>
            <td>Department</td>

            <td class="h6 m-3"><form:checkboxes itemValue="id" itemLabel="name" items = "${departments}" var = "department" path="department" delimiter="<br/>"
            /></td>

<%--        <tr>--%>
<%--        <tr>--%>
<%--            <c:forEach items="${departments}" var="department">--%>
<%--                 <name="${department.id}">--%>
<%--                    <legend><c:out value="${department.name}"/> </legend>--%>
<%--                    <c:forEach items="${department.products}" var="product">--%>
<%--                        <c:out  value="${product}"/>--%>
<%--                    </c:forEach>--%>

<%--                </>--%>


<%--            </c:forEach>--%>

<%--        </tr>--%>
    </table>
    <div class="card-footer d-grid gap-2 d-md-flex justify-content-md-end">
        <button type="submit" class="btn btn-outline-dark">Add</button>
        <button type="reset" class="btn btn-outline-dark">Cancel</button>
    </div>

    <form:errors path='*'/>

</form:form>







</body>
</html>
