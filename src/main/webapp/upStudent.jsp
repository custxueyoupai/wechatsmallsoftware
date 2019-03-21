<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="updata" action="Student/updata" method="post"> 
	    wid: <input id="userid" name="wid" /><br/> 
	    stuid: <input id="time" name="stuid" /><br/> 
	    stuname: <input id="title" name="stuname"/><br/> 
	    institute:<input id="content" name="institute"/><br/>
	   stusex:<input id="content" name="stusex"/><br/>
	    major:<input id="content" name="major"/><br/>
	    registrationtime:<input id="content" name="registrationtime"/><br/>
	    <input type="submit" value="更新student"/> 
	</form>

</body>
</html>