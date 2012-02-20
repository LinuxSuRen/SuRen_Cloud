<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File upload page.</title>
</head>
<body>
<form action="upload.action" method="post" enctype="multipart/form-data">
<table>
<tr>
	<td>上传文件：</td>
	<td><input name="file" type="file" /></td>
</tr>
<tr>
	<td><input type="submit" value="提交"/></td>
	<td><input type="reset" value="重置" /></td>
</tr>
</table>
</form>
</body>
</html>