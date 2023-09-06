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

<a href="category-new.jsp">Nova kategorija</a><br><br>

<table class="list">
	  <c:forEach items="${list}" var="category">
	    <tr>
	      <td>${category.name}</td>
	      <td><a href="/students-ads/category?action=get-for-update&id=${category.id}">Update</a></td>
	      <td><a href="/students-ads/category?action=get-for-delete&id=${category.id}">Delete</a></td>
	    </tr>
	  </c:forEach>
</table>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>