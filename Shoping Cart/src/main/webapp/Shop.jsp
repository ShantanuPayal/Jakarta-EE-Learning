<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        form {
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            margin-bottom: 8px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <form action="SecondServ" method="post">
        <h2>Select Products</h2>
        <c:if test="${not empty productNames}">
            <ul>
                <c:forEach var="productName" items="${productNames}">
                    <li>
                        <input type="checkbox" name="selectedProducts" value="${productName}">
                        ${productName}<br>
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Add to Cart">
        </c:if>
        <c:if test="${empty productNames}">
            <p>No products available.</p>
        </c:if>
    </form>
</body>
</html>

