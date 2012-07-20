<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign</title>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#account").focus().change(function(){
		$.get("${contextPath}/login!existed.action?account=" + $(this).val(), function(obj){
			if(!obj.account){
				$("#sign").removeAttr("disabled");
			}else{
				$("#sign").attr("disabled", "disabled");
			}
		})
	});
});
</script>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />

<form action="${contextPath }/login!sign.action" method="post">
<table align="center">
	<tr>
		<td>Account:</td>
		<td><input name="account" value="${account }" id="account" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input name="password" type="password" /></td>
	</tr>
	<tr>
		<td><input type="submit" value="Sign" disabled="disabled" id="sign"/></td>
		<td><input type="reset" value="reset" /></td>
	</tr>
</table>
</form>

<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>