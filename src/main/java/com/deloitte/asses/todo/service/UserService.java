package com.deloitte.asses.todo.service;

import java.util.List;

import com.deloitte.asses.todo.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public User findUserByIdPassword(String userId, String password);
	
	
}
