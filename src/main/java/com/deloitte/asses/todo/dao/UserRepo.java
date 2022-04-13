package com.deloitte.asses.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.asses.todo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByUserIdAndPassword(String userId, String password);
}
