<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Host Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<a href="${contextPath }/weather!init.action">Init City Data.</a>
<div>
<table>
	<tr>
		<td>Name</td><td>Latitude</td><td>Longitude</td>
	</tr>
	<c:forEach items="${cities }" var="city" varStatus="i">
	<tr>
		<td>${city.name }</td><td>${city.latitude_e6 }</td><td>${city.longitude_e6 }</td>
	</tr>
	</c:forEach>
</table>
</div>
<jsp:include page="../common/foot.html" flush="true" />
</body>
</html>