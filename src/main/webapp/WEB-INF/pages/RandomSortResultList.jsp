<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Random Sort History List</title>
</head>
<body>
<div align="center">
		<h1>Random Sort History List</h1>
		
		<table border="1">

			<th>String</th>
			<th>Positions</th>
			<th>Result String</th>
			<th>Time</th>
<!-- 			<th>Action</th> -->

			<c:forEach var="randomSort" items="${randomSortList}">
				<tr>

					<td>${randomSort.givenString}</td>
					<td>${randomSort.positions}</td>
					<td>${randomSort.resultString}</td>
					<td>${randomSort.expendedTime}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button" onclick="window.location.href='newRandomSort'" value="Add new random sort">
		<button onclick="window.history.back()">Back</button>
		<button onclick="window.location.href='${pageContext.request.contextPath}'">Go to home</button>
	</div>
</body>
</html>