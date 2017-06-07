<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style type="text/css">
  <%@include file="css/main.css" %>
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="left">
        <h1>New Random Sort</h1>
        <form:form action="saveRandomSort" method="post" modelAttribute="randomSort">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>String of Numbers (use ; for separating numbers e.g. 1;3;2):</td>
                <td><form:input path="givenString" /></td>
                <td><span class="errormsg"><c:if test="${not empty error1}">Error: ${error1}</c:if></span></td>
            </tr>
            <tr>
                <td>String of Positions except 0 (use ; for separating numbers e.g. 1;2;3):</td>
                <td><form:input path="positions" /></td>
                <td><span class="errormsg"><c:if test="${not empty error2}">Error: ${error2}</c:if></span></td>
            </tr>
            <tr>
           		 <td><span class="errormsg"><c:if test="${not empty error3}">Error: ${error3} </c:if></span></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
 	<div>
 	<br>
 		<input type="button" onclick="window.location.href='randomSortResultList'" value="Get Result History">
		<button onclick="window.location.href='${pageContext.request.contextPath}'">Go to home</button>
 	</div>
</body>
</html>