<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h3>Kategorije</h3>

<a href="user-new.jsp">Registracija</a><br><br>

<table class="list">
	  <c:forEach items="${list}" var="user">
	    <tr>
	      <td>${user.name}</td>
	      <td>${user.email}</td>
	      <td><a href="/students-ads/user?action=get-for-update&id=${user.id}">Update</a></td>
	      <td><a href="/students-ads/user?action=get-for-delete&id=${user.id}">Delete</a></td>
	    </tr>
	  </c:forEach>
	</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>