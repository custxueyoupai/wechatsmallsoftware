<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>show user</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/mt.css">
<script type="text/javascript" src="js/mt.js" charset="utf-8"></script>

</head>
<body>
<%
		request.getSession().getAttribute("user");
	%>
	<table width="208">
		<tr align="left">
			<td align="right">ID</td>
			<td align="right">${user.userid}</td>
		</tr>
		<tr align="left">
			<td align="right">姓名</td>
			<td align="right">${user.username}</td>
		</tr>
		<tr align="left">
			<td align="right">密码</td>
			<td align="right">${user.usertime}</td>
		</tr>
		
	</table>


</body>
</html>