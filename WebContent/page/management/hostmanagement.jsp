<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Host Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />

<%
	File[] roots = File.listRoots();
	for(File root : roots)
	{
		out.print(root.getPath());
		out.print(" TotalSpace: " + root.getTotalSpace());
		out.print(" UsableSpace: " + root.getUsableSpace());

		out.print("<br />");
%>
<%
	}
%>
<div>说明：获取主机的磁盘分区信息（例如在windows下要知道C、D等分区信息）。</div>
<jsp:include page="../common/foot.html" flush="true" />
</body>
</html>