<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Module Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<a href="${contextPath }/module!edit.action">Add Module</a>
</div>

<div>
<table>
	<tr>
		<td>Name</td><td>Link</td>
	</tr>
	<c:forEach items="${modules }" var="module" varStatus="i">
	<tr>
		<td>${module.name }</td>
		<td>${module.link }</td>
	</tr>
	</c:forEach>
</table>
</div>

<div>
<a href="${contextPath }/module!edit.action">Add Module</a>
</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>