<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Games</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allGames}" var="currentgame">
<tr>
 <td><input type="radio" name="id" value="${currentgame.id}"></td>
 <td>${currentgame.publisher}</td>
 <td>${currentgame.gameName}</td>
 </tr>
</c:forEach>
</table>
<br />
<input type = "submit" value = "Edit" name="doThisToItem">
<input type = "submit" value = "Delete" name="doThisToItem">
<input type="submit" value = "Add" name = "doThisToItem">
</form>
</body>
</html>