package com.deloitte.asses.todo.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_todoTasks")
public class ToDoTask {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long taskId;
	private String todoTaskName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String toDoData;
	private String userId;
	
	public ToDoTask() {
		
	}
	
	public ToDoTask(long taskId, Date date, String toDoData, String userId, String todoTaskName) {
		super();
		this.taskId = taskId;
		this.date = date;
		this.toDoData = toDoData;
		this.userId = userId;
		this.todoTaskName = todoTaskName;
	}
	
	public ToDoTask(Date date, String toDoData, String userId, String todoTaskName) {
		super();
		this.date = date;
		this.toDoData = toDoData;
		this.userId = userId;
		this.todoTaskName = todoTaskName;
	}

	public String getTodoTaskName() {
		return todoTaskName;
	}

	public void setTodoTaskName(String todoTaskName) {
		this.todoTaskName = todoTaskName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getToDoData() {
		return toDoData;
	}

	public void setToDoData(String toDoData) {
		this.toDoData = toDoData;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("taskId :").append(this.taskId)
				.append("\n todoTaskName : ").append(this.todoTaskName)
				.append("\n date : ").append(this.date)
				.append("\n toDoData : ").append(this.toDoData)
				.append("\n userId : ").append(this.userId).toString();
	}
	
	
	

}
