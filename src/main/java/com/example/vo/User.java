package com.example.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private int no;
	
	@NotNull(message="이름은 필수 입력값입니다.")
	@Size(min=2, max=4, message="이름은 2글자 이상 4글자 이하입니다.")
	private String name;
	
	@NotNull(message="전화번호는 필수입력값입니다.")
	@Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$",
			message="올바른 형식의 전화번호가 아닙니다.")
	private String phone;
	
	private String email;
	private String addr;
	private String filename;
	
	public User() {}

	public User(int no, String name, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


}
