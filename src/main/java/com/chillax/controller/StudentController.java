package com.chillax.controller;

import com.google.gson.Gson;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chillax.dto.Student;
import com.chillax.service.StudentService;
@Controller
//@RequestMapping("/Student")
public class StudentController {
   @Resource
   private StudentService studentservice; 
   @RequestMapping(value="/savestudent",produces = "text/plain;charset=UTF-8")
   //录入学生信息
   @ResponseBody
   public String save(HttpServletRequest request, HttpServletResponse response) {
	   /* 设置响应头允许ajax跨域访问 */  
       response.setHeader("Access-Control-Allow-Origin", "*");  
       /* 星号表示所有的异域请求都可以接受， */  
       response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
      response.setContentType("text/html;charset=utf-8");
       //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据
	   // 直接从表单中获取数据
		String stuId = request.getParameter("stuid");
		String stuName = request.getParameter("stuname");
		String stuSex = request.getParameter("stusex");
		String registrationTime = request.getParameter("registrationtime");
		String wId = request.getParameter("wid");
       String major = request.getParameter("major");
       String institute = request.getParameter("institute");
       Student student = new Student();
		student.setStuId(stuId);
		student.setStuName(stuName);
		student.setStuSex(stuSex);
		student.setwId(wId);
		student.setRegistrationTime(registrationTime);
		student.setMajor(major);
		student.setInstitute(institute);
		if(studentservice.query(wId)!=null) {
			return  "flase";
		}else {
			studentservice.save(student);
			return "true";
		}
		
   }
		//删除学生信息
		@RequestMapping(value="/deletestudent")
		@ResponseBody	
		public String delete(HttpServletRequest request, HttpServletResponse response) {
			 /* 设置响应头允许ajax跨域访问 */  
	        response.setHeader("Access-Control-Allow-Origin", "*");  
	        /* 星号表示所有的异域请求都可以接受， */  
	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
	       response.setContentType("text/html;charset=utf-8");
	        //获取微信小程序get的参数值并打印 
			// 直接从表单中获取数据
			String stuId=request.getParameter("id");
			studentservice.delete(stuId);
			return "redirect:";
		}
		 @RequestMapping(value="/updatastudent")
		   //修改学生信息
		 @ResponseBody
		   public String updata(HttpServletRequest request, HttpServletResponse response) {
			 /* 设置响应头允许ajax跨域访问 */  
		        response.setHeader("Access-Control-Allow-Origin", "*"); 
		        /* 星号表示所有的异域请求都可以接受， */  
		        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
		       response.setContentType("text/html;charset=utf-8");
		        //获取微信小程序get的参数值并打印 
				// 直接从表单中获取数据
			    Student student = new Student();
				// 直接从表单中获取数据
				String stuId = request.getParameter("stuid");
				String stuName = request.getParameter("stuname");
				String stuSex = request.getParameter("stusex");
				String wId = request.getParameter("wid");
				String registrationTime = request.getParameter("registrationtime");
//				DateTime registrationTime = null;
//		       // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
//		        DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss"); 
//		       try {
//		    	   registrationTime = DateTime.parse(request.getParameter("registrationTime"),format);
//		       } catch (ParseException e) {
//		           e.printStackTrace();
//		       }
		       String major = request.getParameter("major");
		       String institute = request.getParameter("institute");
				student.setStuId(stuId);
				student.setStuName(stuName);
				student.setStuSex(stuSex);
				student.setwId(wId);
				student.setRegistrationTime(registrationTime);
				student.setMajor(major);
				student.setInstitute(institute);
				studentservice.updata(student);
				return "redirect:";
		   }
		 @RequestMapping(value="/querystudent",produces = "text/plain;charset=UTF-8")
		 @ResponseBody
		   public String query(HttpServletRequest request, HttpServletResponse response) {
			 /* 设置响应头允许ajax跨域访问 */  
		        response.setHeader("Access-Control-Allow-Origin", "*");  
		        /* 星号表示所有的异域请求都可以接受， */  
		        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
		       response.setContentType("text/html;charset=utf-8");
		        //获取微信小程序get的参数值并打印
			    String wId = request.getParameter("wid");
			    System.out.println(wId);
				Student student = studentservice.query(wId);				
				Gson gson = new Gson();
				String stuQuery = gson.toJson(student);	
				System.out.println(stuQuery);
				return stuQuery;
			}
		 
	}