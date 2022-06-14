<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/custom-functions.tld" prefix="fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Project</title>
    <style>
        #projectEd{
            width: 1000px;
            margin: auto;
            margin-top: 100px;
        }

    </style>
</head>
<body class = "container-fluid">


<form:form action="/project/add" method="post" class = "form card" id="projectEd" modelAttribute="project">
    <h2 class = "bg-gradient text-dark card-header text-xl-center">Edit Project</h2>
    <table class="table table-hover">
        <tr>
            <td> <form:input type="hidden" path="id" /></td>
        </tr>
        <tr>
            <td>Project's Name</td>
            <td> <form:input path="name" /></td>
        </tr>
        <tr>
            <td>Client</td>
            <td> <form:select path="client">

                <form:options itemValue="id" itemLabel="name" items="${clients}"/>
            </form:select></td>

            </td>
        </tr>
        <tr>
            <td>Date of offer</td>
            <td><form:input name="date" type = "date" path="date"/></td>
        </tr>
        <tr>

            <td>Department</td>
            <td></td>
            <td></td>
            <td></td>


        </tr>
        <tr id="chk">
            <div class="checkbox-list">


                <c:forEach var="department" items="${project.departments}" varStatus="loop">

                <td><b><form:checkbox path="departments" value="${department.id}" label="${department.name}" />
                </td>

                <td></td>
                <td></td>
                <td></td>
                <td></td>


        </tr>
<%--        <c:forEach var="product" items="${department.productsCopies}" varStatus="loop">--%>



<%--            <c:if test="${project.id == product.project.id}">--%>

<%--            <td>  <form:checkbox path="productsCopies" value="${product.id}"  />--%>
<%--                <input value="${product.id}" type="hidden", name="id"/>--%>
<%--                <c:out value="${product.name}"/></td>--%>
<%--            <td>   <fmt:formatNumber type="number" pattern="0.00 PLN"  value="${product.price}"/>--%>
<%--                <c:out value=" / ${product.unit}"/></td>--%>
<%--            <td>Quantity: </td>--%>
<%--                <td><input type="number" name="params"  /> </td>--%>

<%--            <td></td>--%>



<%--            </tr>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>
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
        <button type="submit" class="btn btn-outline-dark">Edit</button>
        <button type="reset" class="btn btn-outline-dark">Cancel</button>
    </div>

    <form:errors path='*'/>

</form:form>







</body>
</html>
