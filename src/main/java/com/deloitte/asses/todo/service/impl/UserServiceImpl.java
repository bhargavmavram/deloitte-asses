package com.deloitte.asses.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.asses.todo.dao.UserRepo;
import com.deloitte.asses.todo.model.User;
import com.deloitte.asses.todo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepository;
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByIdPassword(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
	}

}
