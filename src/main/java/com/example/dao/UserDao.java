package com.example.dao;

import java.util.List;

import com.example.vo.User;

public interface UserDao {

	List<User> getUsers();
	User getUserByNo(int no);
	User getUserByName(String name);
	void addUser(User user);
}
