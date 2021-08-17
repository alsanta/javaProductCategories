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
<title>Products & Categories</title>
</head>
<body>
    <div class="header d-flex justify-content-between">
        <h1 class="ms-3 mt-3">${singleProduct.name}</h1>
        <div class="links mt-3 me-3"><a href="/">Home</a></div>
    </div>
    <div class="main">
        <div class="left">
            <h3>Categories:</h3>
            <ul>
                <c:forEach var='category' items='${ singleProduct.categories }'>
                    <li>${category.name}</li>
                </c:forEach>
            </ul>
        </div>
        <div class="right">
            <form action='/addCategory/${singleProduct.id}' method='POST'>
            <select name='category_id'>
                <c:forEach var='category' items='${ allCategories }'>
                    <option value='${category.id}'>${category.name}</option>
                </c:forEach>
            </select>
            <input class="subBtn" type="submit" value="Add">
            </form>
        </div>
    </div>
</body>
</html>