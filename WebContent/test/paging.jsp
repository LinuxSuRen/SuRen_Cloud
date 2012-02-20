<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.nercis.cbtes.entity.Student" %>
<%@ page import="com.nercis.cbtes.util.Page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Page<Student> paging = (Page<Student>)request.getAttribute("paging");

List<Student> students = paging.getResult();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页demo</title>
</head>
<body>

<c:forEach items="${paging.result }" var="stu">
<div>Name:${stu.name }, age:${stu.age }</div>
</c:forEach>
<div>
<c:if test="${paging.previous != -1 }"><a href="page.action?paging.start=${paging.previous }">上一页</a>，</c:if>
当前第${paging.current}页，
<c:if test="${paging.next != -1 }"><a href="page.action?paging.start=${paging.next }">下一页</a>，</c:if>
共有：${paging.size }页，${paging.total }条
</div>

</body>
</html>