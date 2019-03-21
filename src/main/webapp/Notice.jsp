<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="addNotice" action="notice/insert" method="post"> 
	    userid: <input id="userid" name="userid" /><br/> 
	    time: <input id="time" name="time" /><br/> 
	    title: <input id="title" name="title"/><br/>
	    content:<input  id="content"  name="content"/><br/> 
	    <input type="submit" value="添加notice"/> 
	</form>

</body>
</html>