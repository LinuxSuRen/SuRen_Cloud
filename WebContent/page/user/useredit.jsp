<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Host Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<form action="${contextPath }/user.action" method="post">
<input name="user.id" value="${user.id }" type="hidden" />
<table>
	<tr>
		<td>Name:</td><td><input name="user.name" value="${user.name }" /></td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td>
			${user.gender }
		</td>
	</tr>
	<tr>
		<td>Password:</td>
		<td>
			<input type="password" name="user.password" value="${user.password }"/>
		</td>
	</tr>
	<tr>
		<td>E-mail:</td><td><input name="user.email" value="${user.email }" /></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="Update" /></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>