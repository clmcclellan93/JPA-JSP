<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Cars</title>
</head>
<body>

<form method="post" action="navigationServlet">
	<table>
	<c:forEach items="${requestScope.allCars}" var="currentCar">
	<tr>
		<td><input type="radio" name="id" value="${currentCar.id}"></td>
		<td>${currentCar.make}</td>
		<td>${currentCar.model}</td>
		<td>${currentCar.year}</td>
	</tr>
	</c:forEach>
	</table>
	
	<input type="submit" value="Add" name="doThisToCar">
	<input type="submit" value="Edit" name="doThisToCar">
	<input type="submit" value="Delete" name="doThisToCar">
</form>

</body>
</html>