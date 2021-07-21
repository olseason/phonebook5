package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PhoneController {

	//필드
	//생성자
	//메소드gs
	//메소드일반
	
	@RequestMapping(value="/test")
	public String test() {
		System.out.println("test");
		
		return "/WEB-INF/views/test.jsp";  //DispatcherServlet 해당된 주소를 포워드하라고 명령 
	}
	
}
