<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div align="right">
您好,<a href="${contextPath }">${session_user.name }</a>
<c:if test="${session_user.type =='vistor' }"><a href="${contextPath }/page/login/login.jsp">Login</a></c:if>
<c:if test="${session_user.type !='vistor' }"><a href="${contextPath }/login!logout.action">Logout</a></c:if>
<a href="${contextPath }/page/login/sign.jsp">Sign</a>
</div>
