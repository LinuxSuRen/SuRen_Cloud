<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Module Management</title>
<script type="text/javascript" src="${contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name='module.name']").blur(function(){
		$.ajax({
			url : "${contextPath }/module!checkName.action?module.name=" + $(this).val(),
			dataType : "json",
			success : function(data){
				var module = data.module;
				if(module != null){
					alert(module.name + "已经存在.");
					$("input[name='module.name']").val("");
				}
			}
		});
	})
});
</script>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />
<div>
<form action="${contextPath }/module!save.action">
<table>
	<tr>
		<td>Name</td><td><input name="module.name" value="${module.name }" /></td>
	</tr>
	<tr>
		<td>Link</td>
		<td>
		<select name="module.link">
		<c:forEach items="${actions }" var="action" varStatus="i">
			<c:choose>
				<c:when test="${module.name == action}">
				<option value="${action }" selected="selected">${action }</option>
				</c:when>
				<c:otherwise>
				<option value="${action }">${action }</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td>Home</td><td><input name="module.home" value="${module.home }" /></td>
	</tr>
	<tr>
		<td>Visible</td>
		<td>
		<select name="module.link">
			<option value="true">可见</option>
			<option value="false">不可见</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>Visible</td>
		<td><textarea name="module.desc">${module.desc }</textarea></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit" /></td>
		<td><input type="reset" value="reset" /></td>
	</tr>
</table>
</form>
</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>