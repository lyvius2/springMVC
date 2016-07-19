package com.example.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.UserDao;
import com.example.exception.UserNotFoundException;
import com.example.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	/*
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(){
		return "error/unknown";
	}
	
	// UserController에서 발생한 예외처리를 담당하는 메서드
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundExceptionHandler(){
		// 오류 페이지에 해당하는 뷰 이름을 반환한다.
		return "error/user";
	}
	*/
	
	// 요청 URL : "/users"
	@RequestMapping("/users")
	public String users(Model model){
		
		// 전체사용자 조회
		List<User> userList = userDao.getUsers();
		// 뷰에 전달하기 위해서 Model 객체에 저장하기
		model.addAttribute("userList", userList);
		
		// 뷰 이름 반환
		return "users";
	}
	
	// 요청 URL : "/user?no=23"
	@RequestMapping("/user")
	public String userDetail(@RequestParam(value="no", defaultValue="-1")int no, Model model){
		// 전달받은 사용자 번호에 해당하는 사용자 정보 조회하기
		User user = userDao.getUserByNo(no);
		if(user == null){
			throw new UserNotFoundException();
		}
		model.addAttribute("user", user);
		return "user";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerForm(Model model){
		// form 입력값을 저장할 커맨드 객체를 생성해서 "user"라는 이름으로 모델에 저장
		model.addAttribute("user", new User());
		return "userform";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@Valid User user, Errors errors){
		
		// 입력값에 대한 유효성 통과 여부를 체크
		if(errors.hasErrors()){
			// 유효성 검사를 통과하지 못했다.
			return "userform";	// 입력폼으로 이동
		}
		// 업무 로직과 관련된 유효성 통과 여부를 체크
		User registeredUser = userDao.getUserByName(user.getName());
		if(registeredUser!=null){
			// rejectValue(fieldName, code, defaultMessage);
			errors.rejectValue("name", null, "이미 등록된 이름입니다.");
			return "userform";
		}
		userDao.addUser(user);
		return "redirect:/users";
	}
}
