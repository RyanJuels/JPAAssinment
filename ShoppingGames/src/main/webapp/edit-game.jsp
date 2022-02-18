<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Games</title>
</head>
<body>
<form action = "editGameServlet" method="post">
Publisher: <input type ="text" name = "publisher" value= "${gameToEdit.publisher}">
Game: <input type = "text" name = "gameName" value= "${gameToEdit.gameName}">
<input type = "hidden" name = "id" value="${gameToEdit.id}">
<input type = "submit" value="Save Edited Game">
</form>
</body>
</html>