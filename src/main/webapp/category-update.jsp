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

<h3>Izmeni kategoriju</h3>

<form action="category" method="post">
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="id" value="${category.id}" />
	<table>		
		<tr><td>Ime</td><td><input type="text" name="name" value="${category.name}" required="required"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Save" /></td></tr>
	</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>