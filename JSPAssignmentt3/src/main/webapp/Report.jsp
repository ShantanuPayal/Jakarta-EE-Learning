<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Report</title>
</head>
<body>
    <h2>Student Roll Numbers</h2>
    <c:forEach var="rollNumber" items="${rollNumbers}">
        Roll Number: ${rollNumber}<br>
    </c:forEach>
</body>
</html>
