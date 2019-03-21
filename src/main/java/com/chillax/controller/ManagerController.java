package com.chillax.controller;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chillax.dto.Manager;
import com.chillax.service.ManagerService;
import com.google.gson.Gson;

@Controller
//@RequestMapping("/manager")//不理解这里干什么的jsp中的映射
public class ManagerController {
    @Resource
	private  ManagerService managerService;
	@RequestMapping(value="/savemanager")
	@ResponseBody
	//录入教师信息
	public String save(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
		// 直接从表单中获取数据
		String wid = request.getParameter("WId");
		String username = request.getParameter("UserName");
		String usertime=request.getParameter("UserTime");
		String institute  = request.getParameter("Institute");
		String usersex = request.getParameter("UserSex");
//		DateTime userTime = null;
//        // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
//		DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
//		try {
//        	userTime = DateTime.parse(request.getParameter("UserTime"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
		Manager manager=new Manager();
		manager.setWid(wid);
		manager.setUsername(username);
		manager.setUsertime(usertime);
		manager.setInstitute(institute);
		System.out.println(institute+manager.getInstitute());
		manager.setUsersex(usersex);
		managerService.save(manager);		
		return "redirect:";
	}
	//删除教师信息
	@RequestMapping(value="/deletemanager")
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,Model model) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
        Manager manager=new Manager();
		String username = request.getParameter("username");
		manager.setUsername(username);
		managerService.delete(manager);
		return "redirect:";
	}
	//修改教师信息
	@RequestMapping(value="/updatamanager")
	@ResponseBody	
		public String updata(HttpServletRequest request, HttpServletResponse response) {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
			// 直接从表单中获取数据
			String wid = request.getParameter("WId");
			String username = request.getParameter("UserName");
			String usertime=request.getParameter("UserTime");
			String institute  = request.getParameter("Institute");
			String usersex = request.getParameter("UserSex");
//			DateTime userTime = null;
//	        // String 类型按照 yyyy-MM-dd HH:mm:ss的格式转换为 java.util.Date 类
//	        DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss"); 
//	        try {
//	        	userTime = DateTime.parse(request.getParameter("UserTime"),format);
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        }
	        Manager manager=new Manager();
			manager.setWid(wid);
			manager.setUsername(username);
			manager.setUsertime(usertime);
			manager.setInstitute(institute);
			manager.setUsersex(usersex);
			managerService.updata(manager);
			return "redirect:";
		}
	//查看教师信息
	@RequestMapping(value="/showmanager",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String show(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印 
        String wid = request.getParameter("wid");
		System.out.println(wid);
		Gson gson = new Gson();
		Manager manager=managerService.show(wid);
		if(manager!=null)
			System.out.println("不是空");
		else
			System.out.println("空");	
		String managerTable=gson.toJson(manager);
		System.out.println(managerTable);
	    return managerTable;
	}
}