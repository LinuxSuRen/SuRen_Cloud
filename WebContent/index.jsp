<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<div>
${session_user.name }您好,
<c:if test="${session_user.type =='vistor' }"><a href="page/login/login.jsp">Login</a></c:if>
<c:if test="${session_user.type !='vistor' }"><a href="${contextPath }/login!logout.action">Logout</a></c:if>
<a href="page/login/sign.jsp">Sign</a>
</div>
<hr>
<a href="${contextPath }/article.action">Article</a>
</body>
</html>