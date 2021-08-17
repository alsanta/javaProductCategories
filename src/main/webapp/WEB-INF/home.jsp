<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                    crossorigin="anonymous">
                <link rel="stylesheet" href="/css/style.css" />
                <title>Products & Categories</title>
            </head>
            <body>
                <div class="main">
                    <div class="left">
                        <h1>Products</h1>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var='product' items='${ allProducts }'>
                                    <tr>
                                        <td><a href="product/${product.id}">${product.name}</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a class="subBtn2" href="/product">New product</a>
                    </div>
                    <div class="right">
                        <h1>Categories</h1>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var='category' items='${ allCategories }'>
                                    <tr>
                                        <td><a href="/category/${category.id}">${category.name}</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <a class="subBtn2" href="/category">New category</a>
                    </div>
                </div>
            </body>

            </html>