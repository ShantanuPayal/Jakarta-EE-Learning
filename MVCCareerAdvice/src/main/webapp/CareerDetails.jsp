<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- CareerDetails.jsp -->
<html>
<head><title>Career Advice</title></head>
<body>
    <h2>Your Career Advice:</h2>
    <p><%= request.getAttribute("careerAdvice") %></p>
</body>
</html>
