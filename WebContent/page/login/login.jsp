<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	text-align: center;
}

#m {
	margin: 0 auto;
	width: 680px;
	align: center;
}
</style>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var msg;

	$("#account").focus();
	$("form").submit(function(e){
		if(!valid()){
			alert(msg);
			return false;
		}
	});

	function valid(){
		if("" == $("#account").val() || "" == $("#password").val()){
			msg = "帐号或密码为空";
			return false;
		}

		return true;
	}

	var errorInfo = $("#login_error_info").html();
	if($.trim(errorInfo) != ""){
		$("#password").val("");
	}
});
</script>
<title>Login page.</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />

<div id="m">
<div id="login_error_info">
<c:if test="${error != null }">${error }</c:if>
</div>
<form action="${contextPath }/login.action" method="post">
<table>
	<tr>
		<td>Account:</td>
		<td><input name="account" value="${account }" id="account" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input name="password" type="password" id="password" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Login" /></td>
		<td><input type="reset" value="Reset" /></td>
	</tr>
</table>
</form>
</div>

<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>