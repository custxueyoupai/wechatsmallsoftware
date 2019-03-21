package com.chillax.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestController {
	@RequestMapping(value="/TestController")
	@ResponseBody	
	public    void  Testcontroller(String username,String password,HttpServletRequest request,HttpServletResponse response) throws IOException{
		/* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       response.setContentType("text/html;charset=utf-8");
        //获取微信小程序get的参数值并打印
        String username1 = request.getParameter("username");
        String password1 = request.getParameter("password");
        System.out.println("username="+username1+" ,password="+password1);        
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write("进入后台了");
        out.flush(); 
	}

}
