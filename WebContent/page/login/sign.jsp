<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign</title>
</head>
<body>

<form action="${contextPath }/login!sign.action" method="post">
<table>
	<tr>
		<td>Account:</td>
		<td><input name="account" value="${account }" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input name="password" type="password" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Sign" /></td>
		<td><input type="reset" value="reset" /></td>
	</tr>
</table>
</form>

</body>
</html>