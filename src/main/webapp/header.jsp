<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<c:if test="${sessionScope.user.role == 'admin'}">
		<jsp:include page="header-admin.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.user.role == 'user'}">
		<jsp:include page="header-user.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.user == null}">    
		<jsp:include page="header-gost.jsp"></jsp:include>
	</c:if>
		
	<h4 style="margin-top: 10px">${sessionScope.user.name}</h4>
</body>
</html>