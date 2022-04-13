package com.deloitte.asses.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.asses.todo.dao.ToDoTaskRepo;
import com.deloitte.asses.todo.model.ToDoTask;
import com.deloitte.asses.todo.service.TodoService;

@Service
public class ToDoServiceImpl implements TodoService {
	
	@Autowired
	private ToDoTaskRepo toDoTaskRepository;

	@Override
	public List<ToDoTask> getToDoTasksByUserId(String userId) {
		// TODO Auto-generated method stub
		return toDoTaskRepository.findByUserId(userId);
	}

	@Override
	public void save(ToDoTask toDoTask) {
		toDoTaskRepository.save(toDoTask);
	}

	@Override
	public void deleteByTaskId(Long taskId) {
		toDoTaskRepository.deleteById(taskId);
	}

	@Override
	public ToDoTask getToDoTasksByUserIdAndTaskId(String userId, Long taskId) {
		// TODO Auto-generated method stub
		return toDoTaskRepository.findByUserIdAndTaskId(userId, taskId);
	}

}
