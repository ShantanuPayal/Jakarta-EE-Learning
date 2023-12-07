<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bill</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 20px auto;
            width: 60%;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
            padding: 20px;
        }

        li {
            margin-bottom: 8px;
        }

        p {
            text-align: center;
            color: #777;
        }
    </style>
</head>
<body>
    <h2>Selected Products</h2>
    <c:if test="${not empty sessionScope.cartItems}">
        <ul>
            <c:forEach var="item" items="${sessionScope.cartItems}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty sessionScope.cartItems}">
        <p>No products selected.</p>
    </c:if>
</body>
</html>
