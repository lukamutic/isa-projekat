<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h3>Da li zelite da obrisete kategoriju?</h3>

<form action="category" method="get">
	<input type="hidden" name="action" value="delete" />
	<input type="hidden" name="id" value="${category.id}" />
	<p>${category.name}</p>
	<p><a href="category?action=list">Nazad</a> <input type="submit" value="Delete" /></p>	
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>