<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form id="addManager" action="manager/save" method="post"> 
	    userid: <input id=UserId" name="UserId" /><br/> 
	    username: <input id="UserName" name="UserName" /><br/> 
	    usertime: <input id="UserTime" name="UserTime"/><br/>
	    userinstitute: <input id="UserInstitute" name="UserInstitute"/><br/> 
	    usersex: <input id="UserSex" name="UserSex"/><br/> 
	   
	    <input type="submit" value="添加新用户"/> 
	</form>

</body>
</html>