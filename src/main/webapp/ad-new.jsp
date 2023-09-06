<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h3>Oglas</h3>

	<form action="ad" method="post">
		<input type="hidden" name="action" value="save" /> 
		<input type="hidden" name="userId" value="${user.id}" />
		<table>
			<tr>
				<td>Kategorija</td>
				<td><select name="category" style="width:150px">
						<c:forEach items="${categories}" var="category" >
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Datum</td>
				<td><input type="date" name="date" style="width:145px"/></td>
			</tr>
			<tr>
				<td>Naslov</td>
				<td><input type="text" name="title" required="required" size="50"/></td>
			</tr>
			<tr>
				<td>Opis</td>
				<td><textarea name="description" rows="6" cols="50" required="required"></textarea></td>
			</tr>
			<tr>
				<td>Cena</td>
				<td><input type="text" name="price" required="required" style="width:150px"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>