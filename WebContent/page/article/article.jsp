<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Article List.</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<a href="${contextPath }/page/article/addArticle.jsp">add articles</a>
</div>

<table>
<tr>
	<td>Title</td><td>Content</td><td>Attachment</td>
</tr>
<c:forEach items="${articles }" var="article" varStatus="i">
<tr>
	<td>${article.title }</td><td>${article.content }</td>
	<td><a href="${contextPath }/article!fetchAttachment.action?attID=${article.attachment.id }">${article.attachment.name }</a></td>
	<td>${article.attachment.type }</td>
	<td>
	<c:if test="${fn:startsWith(article.attachment.type, 'image') }">
	<img width="120" src="${contextPath }/article!fetchAttachment.action?attID=${article.attachment.id }"></img>
	</c:if>
	</td>
</tr>
</c:forEach>
</table>

<div>
<a href="${contextPath }/page/article/addArticle.jsp">add articles</a>
</div>

<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>