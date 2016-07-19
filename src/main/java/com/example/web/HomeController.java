package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	// 핸들러 메서드 정의하기
	//	- 특정한 URL과 매핑되어 있고,
	//	    매핑된 URL 요청이 오면 실행된다.
	@RequestMapping(value={"/", "/home"})
	public String homePage(){
		
		// 이동할 뷰 페이지의 이름을 반환한다.
		return "home";
	}
	/*
	@RequestMapping(value={"/about"})
	public String aboutPage(Model model){
		// Model 객체에 뷰를 전달할 값을 확장할 수 있다.
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		model.addAttribute("count", 10);
		
		return "about";
	}
	*/
	@RequestMapping(value={"/about"})
	public ModelAndView aboutPage(){
		ModelAndView mav = new ModelAndView();
		
		// View 페이지에 전달할 값을 ModelAndView에 저장한다.
		mav.addObject("message", "저희 회사를 소개합니다.");
		mav.addObject("count", 10);
		
		// 이동할 View의 이름을 ModelAndView객체에 저장한다.
		mav.setViewName("about");
		return mav;
	}
	
	@RequestMapping(value="/contacts")
	public String contactsPage(Model model){
		String[] names = {"사장 : 010-1234-5678","전무 : 010-1247-8956"};
		
		model.addAttribute("contacts", names);
		
		return "contacts";
	}
}
