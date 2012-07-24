<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<title>SuRen</title>
<script type="text/javascript" src="${contextPath}/resources/js/suren.js"></script>
</head>
<body>
<jsp:include page="page/common/head.jsp" flush="true" />

<a href="${contextPath }/article.action">Article</a>
<a href="${contextPath }/page/management/hostmanagement.jsp">Management</a>
<a href="${contextPath }/user!edit.action?id=${session_user.id }">Edit User</a>
<a href="${contextPath }/weather.action">City List.</a>
<a href="${contextPath }/module.action">Module List.</a>
<a href="${contextPath }/visitor.action">Visitor List.</a>
<a href="${contextPath }/resources/suren.jnlp">SuRen_Mail</a>

<jsp:include page="page/common/foot.jsp" flush="true" />
</body>
</html>