<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form id="insertCheck" action="AttendanceSheet/insertCheck" method="post"> 
	    stuname: <input id=stuname" name="stuname" /><br/> 
	    stuId: <input id="stuid" name="stuid" /><br/> 
	    wId: <input id="wid" name="wid"/><br/> 
	    checkInDate: <input id="checkindate" name="checkindate"/><br/> 
	    checkInTime: <input id="checkintime" name="checkintime"/><br/> 
	    checkOutTime: <input id="checkouttime" name="checkouttime"/><br/> 
	    punchCardResult: <input id="punchcardresult" name="punchcardresult"/><br/> 
	    note: <input id="note" name="note"/><br/> 
	    IP: <input id="IP" name="IP"/><br/> 
	    <input type="submit" value="添加签到表"/> 
	</form>
</body>
</html>