package com.deloitte.asses.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User {
	
	@Id
	private String userId;
	private String password;
	private String userName;
	
	public User() {
		
	}

	public User(String userId, String password, String userName) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Name :").append(this.userName)
		.append("\nUserId : ").append(this.userId).toString();
	}
	
	

}
