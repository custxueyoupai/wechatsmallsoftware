package com.chillax.controller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import com.chillax.dto.AttendanceSheet;
import com.chillax.service.AttendanceSheetService;
 @Controller
//@RequestMapping("/AttendanceSheet")
public class AttendanceSheetController {
	@Resource
	private AttendanceSheetService attendancesheetservice;
	@RequestMapping(value="/insertCheck")
	//插入签到表信息
	@ResponseBody
    public String insertCheck(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据
		String stuid = request.getParameter("stuid");	
		String stuname = request.getParameter("stuname");
		String wid = request.getParameter("wid");
		String checkindate = request.getParameter("checkindate");
		String checkintime = request.getParameter("checkintime");
		String checkouttime = request.getParameter("checkouttime");
        String note = request.getParameter("note");
        String ip = request.getParameter("IP");
        AttendanceSheet attendancesheet = new AttendanceSheet();
        attendancesheet.setStuName(stuid);
        attendancesheet.setStuId(stuname);
        attendancesheet.setwId(wid);
        attendancesheet.setCheckInDate(checkindate);
        attendancesheet.setCheckInTime(checkintime);
        attendancesheet.setCheckOutTime(checkouttime);
       // attendancesheet.setPunchCardResult(punchcardresult);
        attendancesheet.setNote(note);
        attendancesheet.setIp(ip);
        System.out.println(attendancesheet.getIp());
        attendancesheetservice.insertCheck(attendancesheet);
        return "redirect:";
    }
	@RequestMapping(value="/deletesheet")
	//删除签到信息
	@ResponseBody
    public String delete(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		String stuId = request.getParameter("stuid");
		String checkInDate = request.getParameter("checkindate");
		AttendanceSheet ash=new AttendanceSheet();
		ash.setStuId(stuId);
		ash.setCheckInDate(checkInDate);
		attendancesheetservice.delete(ash);	
        return "redirect:";
    }
	@RequestMapping(value="/updatasheet")
	//修改签到表
	@ResponseBody
	public String update(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据	
		String stuId = request.getParameter("stuid");
		String stuName = request.getParameter("stuname");
		String wId = request.getParameter("wid");
		String checkInDate = request.getParameter("checkindate");
		String checkInTime = request.getParameter("checkintime");
		String checkOutTime = request.getParameter("checkouttime");
        Integer punchCardResult = Integer.parseInt(request.getParameter("punchcardresult"));
        String note = request.getParameter("note");
        String ip = request.getParameter("IP");
		System.out.println(ip);
        AttendanceSheet attendancesheet = new AttendanceSheet();
        attendancesheet.setStuId(stuId);
        attendancesheet.setCheckInDate(checkInDate);
        attendancesheet.setCheckInTime(checkInTime);
        attendancesheet.setStuName(stuName);
        attendancesheet.setwId(wId);
        attendancesheet.setCheckOutTime(checkOutTime);
        attendancesheet.setPunchCardResult(punchCardResult);
        attendancesheet.setNote(note);
        attendancesheet.setIp(ip);
		System.out.println(attendancesheet.getIp());
        attendancesheetservice.update(attendancesheet);
		System.out.println(attendancesheet.getStuName());
        return "redirect:";
    }
	@RequestMapping(value="/selectsheet")
	@ResponseBody
	public String select(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		String stuId = request.getParameter("wid");	
		String checkInDate = request.getParameter("checkindate");
		AttendanceSheet asheet = new AttendanceSheet();
		Gson gson = new Gson();
		asheet = attendancesheetservice.showBystuId(stuId,checkInDate);
		if(asheet!=null)
			System.out.println("不是空");
		else
			System.out.println("空");
		String stuCheck=gson.toJson(asheet);
		System.out.println(stuCheck);
		return stuCheck;
	}
	@RequestMapping(value="/selectalltime")
	@ResponseBody
	public String selectAllTime(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		String wId = request.getParameter("wid");
		System.out.println(wId);
		//AttendanceSheet asheet = new AttendanceSheet();
		List<AttendanceSheet> asheetlist = new ArrayList<AttendanceSheet>();
		Gson gson = new Gson();
		asheetlist = attendancesheetservice.showBystuIdHistory(wId);
		if(asheetlist!=null)
			System.out.println("不是空");
		else
			System.out.println("空");
		String stuAllTimeCheck=gson.toJson(asheetlist);
		System.out.println(stuAllTimeCheck);
		return stuAllTimeCheck;
	}
}