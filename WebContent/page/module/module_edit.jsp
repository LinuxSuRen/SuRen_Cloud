<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Module Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<form action="${contextPath }/module!edit.action">
<table>
	<tr>
		<td>Name</td><td><input name="module.name" value="${module.name }" /></td>
	</tr>
	<tr>
		<td>Link</td><td><input name="module.link" value="${module.link }" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit" /></td>
		<td><input type="reset" value="reset" /></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>