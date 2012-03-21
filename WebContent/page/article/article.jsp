<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article List.</title>
</head>
<body>

<div>
<a href="${contextPath }/page/article/addArticle.jsp">add articles</a>
</div>

<table>
<tr>
	<td>Title</td><td>Content</td><td>Attachment</td>
</tr>
<c:forEach items="${articles }" var="article" varStatus="i">
<tr>
	<td>${article.title }</td><td>${article.content }</td><td>${article.attachment }</td>
</tr>
</c:forEach>
</table>

<div>
<a href="${contextPath }/page/article/addArticle.jsp">add articles</a>
</div>
</body>
</html>