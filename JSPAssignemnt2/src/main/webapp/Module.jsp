<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OPTION LIST</title>
</head>
<body>
<form action="OptionServ" method="post">
 <label for="module">Select a module:</label>
 <select name="module" id="module">
            <option value="java">Java</option>
            <option value="C++">C++</option>
            <option value="oracle">Oracle</option>
 </select>
       <input type="submit" value="Submit">
</form>
</body>
</html>