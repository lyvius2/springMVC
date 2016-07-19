package com.example.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.UserNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {

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
}
