package com.deloitte.asses.todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.asses.todo.model.ToDoTask;

@Repository
public interface ToDoTaskRepo extends JpaRepository<ToDoTask, Long>  {
	
	public List<ToDoTask> findByUserId(String userId);
	
	public ToDoTask findByUserIdAndTaskId(String userId, Long taskId);
}
