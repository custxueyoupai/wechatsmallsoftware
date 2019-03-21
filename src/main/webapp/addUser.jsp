<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addStudent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form id="save" action="Student/savestudent" method="post"> 
	    stuId: <input id="stuid" name="stuid" /><br/> 
	    stuName: <input id="stuname" name="stuname" /><br/> 
	    stuSex: <input id="stusex" name="stusex"/><br/>
	    wId: <input id="wid" name="wid"/><br/>
	    registrationTime: <input id="registrationtime" name="registrationtime"/><br/>
	    major: <input id="major" name="major"/><br/>
	    institute: <input id="institute" name="institute"/><br/>
	    
	    <input type="submit" value="添加新用户"/> 
	</form>
  </body>
</html>