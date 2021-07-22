package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
//@RequestMapping(value="/pb")
public class PhoneController {

	//필드
	//생성자
	//메소드gs
	//메소드일반
	
	
	//리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET} )
	public String list(Model model) {
		System.out.println("[PhoneController.list]");
		
		//Dao 사용
		PhoneDao phoneDao = new PhoneDao();
		
		//데이터 가져오기
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		//model 담기 --> DispatcherServlet 전달됨 --> request의 "/WEB-INF/views/list.jsp" 넣는다
		model.addAttribute("personList", personList);
		
		//view
		return "/WEB-INF/views/list.jsp";
	}
	
	
	//쓰기폼
	@RequestMapping(value= "/writeForm", method= {RequestMethod.GET, RequestMethod.POST} )
	public String writeForm() {
		System.out.println("[PhoneController.writeForm]");
		
		return"/WEB-INF/views/writeForm.jsp";
	}

	
	//쓰기
	/*
	//파라미터가 있을 때 or 없을 때도 있을 상황에
	@RequestMapping(value= "/write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@RequestParam("name") String name,
						@RequestParam("hp")String hp,
						@RequestParam(value="company", required=false, defaultValue="-1")String company) {
		System.out.println("[PhoneController.write]");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		return "";
	}
	*/
	
	
	//@ModelAttribute로 받을 때
	@RequestMapping(value= "/write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.write]");
		
		//@ModelAttribute --> new PersonVo()
		//                --> 기본생성자 + setter
		System.out.println(personVo);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phonebook3/list";
	}
	
	
	/*
	//파라미터를 1개씩 받을 때
	@RequestMapping(value= "/write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@RequestParam("name") String name,
						@RequestParam("hp")String hp,
						@RequestParam("company")String company) {
		System.out.println("[PhoneController.write]");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		return "";
	}
	*/
	
	
	@RequestMapping(value="/board/read/{no}", method= {RequestMethod.GET, RequestMethod.POST} )
	public String read(@PathVariable("no") int boardNo) {
		System.out.println("PathVariable [read]");
		
		//localhost:8088/phonebook3/board/read/1
		//localhost:8088/phonebook3/board/read/2
		//localhost:8088/phonebook3/board/read/100
		
		System.out.println(boardNo);
		
		return"";
	}
	
	
	
	@RequestMapping(value="/test")
	public String test() {
		System.out.println("test");
		
		return "/WEB-INF/views/test.jsp";  //DispatcherServlet 해당된 주소를 포워드하라고 명령 
	}
	

	
}
