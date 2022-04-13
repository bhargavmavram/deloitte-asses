package com.deloitte.asses.todo.service;

import java.util.List;

import com.deloitte.asses.todo.model.ToDoTask;

public interface TodoService {
	
	public List<ToDoTask> getToDoTasksByUserId(String userId);
	
	public ToDoTask getToDoTasksByUserIdAndTaskId(String userId, Long taskId);
	
	public void save(ToDoTask toDoTask);

	public void deleteByTaskId(Long taskId);

}
