package com.chillax.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chillax.dto.Notice;
import com.chillax.service.NoticeService;
@Controller
//@RequestMapping("/notice")
public class NoticeController {
   @Resource
   private NoticeService noticeservice;
  
   @RequestMapping(value="/insertnotice")
   @ResponseBody
	//录入通知信息
   public String insert(HttpServletRequest request, HttpServletResponse response) {
	   /* 设置响应头允许ajax跨域访问 */  
       response.setHeader("Access-Control-Allow-Origin", "*");  
       /* 星号表示所有的异域请求都可以接受， */  
       response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      response.setContentType("text/html;charset=utf-8");
       //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据
	    Notice notice = new Notice();
	    String userId = request.getParameter("userid");
//		DateTime time = null;
//       // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
//		DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
//		try {
//       	time = DateTime.parse(request.getParameter("time"),format);
//       } catch (ParseException e) {
//           e.printStackTrace();
//       }
	    String time=request.getParameter("time");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		notice.setUserid(userId);
		notice.setTime(time);
		notice.setTitle(title);
		notice.setContent(content);
		noticeservice.insert(notice);
		
		return "redirect:";
	}
   @RequestMapping(value="/updatanotice")
   @ResponseBody
   //修改通知记录
   public String updata(HttpServletRequest request, HttpServletResponse response) {
	   /* 设置响应头允许ajax跨域访问 */  
       response.setHeader("Access-Control-Allow-Origin", "*");  
       /* 星号表示所有的异域请求都可以接受， */  
       response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      response.setContentType("text/html;charset=utf-8");
       //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据
	    Notice notice = new Notice();
	    String userid = request.getParameter("userid");
//		DateTime time = null;
//       // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
//		DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
//		try {
//       	time = DateTime.parse(request.getParameter("time"),format);
//       } catch (ParseException e) {
//           e.printStackTrace();
//       }
	    String time=request.getParameter("time");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		notice.setTitle(title);
		notice.setContent(content);
		notice.setTime(time);
		notice.setUserid(userid);
		noticeservice.updata(notice);	
		return "redirect:";
	}
 //删除通知信息
 		@RequestMapping(value="/deletenotice")
 		@ResponseBody
 		public String delete(HttpServletRequest request, HttpServletResponse response) {
 			/* 设置响应头允许ajax跨域访问 */  
 	        response.setHeader("Access-Control-Allow-Origin", "*");  
 	        /* 星号表示所有的异域请求都可以接受， */  
 	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
 	       response.setContentType("text/html;charset=utf-8");
 	        //获取微信小程序get的参数值并打印 
 			String userid=request.getParameter("userid");
 			String time=request.getParameter("time");
 			Notice notice=new Notice();
 			notice.setUserid(userid);
 			notice.setTime(time);
 			noticeservice.delete(notice);
 			return "redirect:";
 		}
 		@RequestMapping(value="/querynotice")
		   //查询通知信息
 		@ResponseBody
 	   public String query(HttpServletRequest request, HttpServletResponse response) {
 			/* 设置响应头允许ajax跨域访问 */  
 	        response.setHeader("Access-Control-Allow-Origin", "*");  
 	        /* 星号表示所有的异域请求都可以接受， */  
 	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
 	       response.setContentType("text/html;charset=utf-8");
 	        //获取微信小程序get的参数值并打印 
 			String userid= request.getParameter("userid");
 	//		DateTime time = null;
 	       // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
// 			DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
// 			try {
// 	       	time = DateTime.parse(request.getParameter("time"),format);
// 	       } catch (ParseException e) {
// 	           e.printStackTrace();
// 	       } 		
 			String time=request.getParameter("time");
 			Notice notice=new Notice();
 			notice.setTime(time);
 			notice.setUserid(userid);
 			Notice notice1=noticeservice.query(notice);	
 			System.out.println(notice1.getContent());
 			System.out.println(notice1.getTitle());
 			return "noticequ";
			}
   
}
