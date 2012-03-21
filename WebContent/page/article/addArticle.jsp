<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add article</title>
</head>
<body>

<form action="${contextPath }/article!add.action" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>Title:</td>
		<td><input name="title" /></td>
	</tr>
	<tr>
		<td>Content:</td>
		<td><textarea cols="10" rows="10" name="content"></textarea></td>
	</tr>
	<tr>
		<td>Attachment:</td>
		<td><input name="attachment" type="file" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit" /></td>
		<td><input type="reset" value="Reset" /></td>
	</tr>
</table>
</form>

</body>
</html>