package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.example.exception.UserNotFoundException;
import com.example.vo.User;
@Repository
public class DummyUserDao implements UserDao {

	List<User> users = new ArrayList<User>();
	AtomicInteger atom = new AtomicInteger();
	public DummyUserDao(){
		users.add(new User(atom.incrementAndGet(), "홍길동", "010-1111-2222"));
		users.add(new User(atom.incrementAndGet(), "이순신", "010-3333-4444"));
	}
	
	@Override
	public List<User> getUsers() {
		return users;
	}

	@Override
	public User getUserByNo(int no) {
		for (User u : users){
			if(u.getNo() == no){
				return u;
			}
		}
		throw new UserNotFoundException();
	}

	@Override
	public User getUserByName(String name) {
		for (User u : users){
			if (u.getName().equals(name)){
				return u;
			}
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		user.setNo(atom.incrementAndGet());
		users.add(user);
	}

}
