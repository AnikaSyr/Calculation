<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="fragments/header.jsp"%>
<html>
<head>
    <title>Product</title>
    <style>
        #prt{
            width: 500px;
            margin: auto;
            margin-top: 100px;
        }

    </style>
</head>
<body class = "container-fluid">


<form:form action="/product/add" method="post" class = "form card" id="prt" modelAttribute="product">
    <h2 class = "bg-gradient text-dark card-header text-xl-center">Add Product</h2>
    <table class="table table-hover">
        <tr>
            <td>Name</td>
            <td> <form:input  required="required" path="name" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td> <form:input required="required" type="number" placeholder="1,00" step="0.01" min="0" path="price" /></td>
        </tr>
        <tr>
            <td>Unit</td>
            <td> <form:select path="unit" >
            <form:option value="-" label="--Please Select--"/>
                <form:options items="${units}" />
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Department Name</td>
            <td>   <form:select path="department">
                <form:option value="-" label="--Please Select--"/>
                <form:options itemValue="id" itemLabel="name" items="${departments}"/>
                </form:select>
            </td>

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
