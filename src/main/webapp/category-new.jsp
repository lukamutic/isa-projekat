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

<h3>Dodaj novu kategoriju</h3>

<form action="category" method="post">
	<input type="hidden" name="action" value="save" />
	<table>		
		<tr><td>Ime</td><td><input type="text" name="name" required="required"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Save" /></td></tr>
	</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>