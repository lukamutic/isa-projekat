<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
<jsp:include page="header.jsp"></jsp:include>

	<h3>Oglasi</h3>
	
	<c:set var="user" value="${sessionScope.user}" />	
	<div class="ads-holder">
		<c:forEach items="${ads}" var="ad">
			<div class="ad">
				<h3>${ad.ad.title}</h3>
				<p><fmt:formatDate value="${ad.ad.date}" pattern="dd.MM.yyyy" /></p>
				<p>${ad.ad.description}</p>
				<b><fmt:formatNumber value="${ad.ad.price}" type="currency" /></b>
				<p>${ad.user.name}</p>
				<b>${ad.user.phone}</b><br>
				<c:if test="${user != null and user.role == 'admin'}">
				<hr>
				    <a href="/students-ads/ad?action=get-for-update&id=${ad.ad.id}">Update</a>
					<a href="/students-ads/ad?action=get-for-delete&id=${ad.ad.id}">Delete</a>
				</c:if>				
			</div>
		</c:forEach>
	</div> <!-- .ads-holder END -->

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>