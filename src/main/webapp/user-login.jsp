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

<h3>Prijava</h3>

<form action="user" method="post">
	<input type="hidden" name="action" value="login" />
	<table>		
		<tr><td>Email</td><td><input type="text" name="email" required="required"/></td></tr>
		<tr><td>Lozinka</td><td><input type="password" name="password" required="required"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Login" /></td></tr>
	</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>