<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css"/>
<title>Products and Categories</title>
</head>
<body>
    <h1 class="ms-5">New Product</h1>
    <form:form class="info d-flex flex-column ms-5" action='/new/products' method='POST' modelAttribute='products'>
        <form:label path='name'>Name:</form:label>
        <form:errors path='name'/>
        <form:input path='name'/>
        <form:label path='description'>Description:</form:label>
        <form:errors path='description'/>
        <form:textarea path='description'/>
        <form:label path='price'>Price:</form:label>
        <form:errors path='price'/>
        <form:input path='price'/>
        <input class="subBtn" type="submit" value="Create">
    </form:form>
</body>
</html>