<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Host Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<table>
	<tr>
		<td>RemoteAddr</td><td>UserAgent</td><td>Referrer</td><td>Date</td>
	</tr>
	<c:forEach items="${visitors }" var="visitor" varStatus="index">
	<tr>
		<td>${visitor.remoteAddr }</td><td>${visitor.userAgent }</td>
		<td>${visitor.referrer }</td><td>${visitor.date }</td>
	</tr>
	</c:forEach>
</table>
</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>