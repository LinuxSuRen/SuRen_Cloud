<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Host Management</title>
</head>
<body>
<jsp:include page="../common/head.jsp" flush="true" />

<%
	File[] roots = File.listRoots();
	for(File root : roots)
	{
		long total = root.getTotalSpace();
		long used = root.getUsableSpace();

		out.print(root.getPath() + "\t");
		out.print("Total:\t" + total + "\t");
		out.print("Used:\t" + used + "\t");

		out.print("<br />");
%>
<%
	}
%>
<div>说明：获取主机的磁盘分区信息（例如在windows下要知道C、D等分区信息）。</div>
<jsp:include page="../common/foot.jsp" flush="true" />
</body>
</html>