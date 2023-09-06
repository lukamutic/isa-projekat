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

<h3>Izmeni oglas</h3>

<form action="ad" method="post">
	<input type="hidden" name="action" value="update" />
	<input type="hidden" name="userId" value="${user.id}" />
	<input type="hidden" name="id" value="${ad.id}" />
	<table>
	
		<tr><td>Kategorija</td>
			<td>
				<select name="category" style="width:150px">
				 <c:forEach items="${categories}" var="category" >
				  <option value="${category.id}">${category.name}</option>
				 </c:forEach>
				</select>
			</td>
		</tr>
		<tr><td>Datum</td><td><input type="date" name="date" value="${ad.date}" required="required"/></td></tr>	
		<tr><td>Naslov</td><td><input type="text" name="title" value="${ad.title}" required="required"/></td></tr>
		<tr><td>Opis</td><td><input type="text" name="description" value="${ad.description}" required="required"/></td></tr>
		<tr><td>Cena</td><td><input type="text" name="price" value="${ad.price}" required="required"/></td></tr>
		<tr><td colspan="2"><input type="submit" value="Save" /></td></tr>
	</table>
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>