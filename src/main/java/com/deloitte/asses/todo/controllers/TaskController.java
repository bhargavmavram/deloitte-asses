package com.deloitte.asses.todo.controllers;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deloitte.asses.todo.model.ToDoTask;
import com.deloitte.asses.todo.service.TodoService;

@Controller
public class TaskController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	

	@Autowired
	private TodoService todoTaskService;
	
	@RequestMapping("/addTodoTask")
	public String addTodoTask(HttpServletRequest request, Model model) {
		String taskDate = request.getParameter("todoDateTime");
		//logger.info("BHMA loggedUser--"+taskDate);
		//logger.info("BHMA taskDate--"+getDate(taskDate));
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(taskDate);
			logger.info("BHMA taskDate--"+new SimpleDateFormat("MM/dd/yyyy").format(date));
			date = new SimpleDateFormat("MM/dd/yyyy").parse(new SimpleDateFormat("MM/dd/yyyy").format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ToDoTask toDoTask = new ToDoTask(date, request.getParameter("todoTaskDescription"), request.getParameter("loggedUserId"), request.getParameter("todoTaskName")); 
		model.addAttribute("loggedUserName", request.getParameter("loggedUserName"));
		model.addAttribute("loggedUserId", request.getParameter("loggedUserId"));
		todoTaskService.save(toDoTask);
		
		List<ToDoTask> todoTasksForUser = todoTaskService.getToDoTasksByUserId(model.getAttribute("loggedUserId").toString());
		System.out.println(todoTasksForUser);
		if(!todoTasksForUser.isEmpty()) {
			model.addAttribute("userTodoTasks", todoTasksForUser);
		}
		
		return "todo-welcome";
	}
	
	@RequestMapping("/task/updateTaskForm")
	public String addTodoTask(@RequestParam("taskId") String taskId, @RequestParam("userId") String userId,  Model model) {
		
		ToDoTask toDoTask = todoTaskService.getToDoTasksByUserIdAndTaskId(userId, Long.parseLong(taskId));

		model.addAttribute("todoTask", toDoTask);
		return "update-form";
	}
	
	@RequestMapping("/todoTask/save")
	public String addTodoTask(@ModelAttribute("todoTask") ToDoTask todoTask, Model model) {
		
		todoTaskService.save(todoTask);
		model.addAttribute("loggedUserId", todoTask.getUserId());
		List<ToDoTask> todoTasksForUser = todoTaskService.getToDoTasksByUserId(todoTask.getUserId());
		System.out.println(todoTasksForUser);
		if(!todoTasksForUser.isEmpty()) {
			model.addAttribute("userTodoTasks", todoTasksForUser);
		}
		return "todo-welcome";
	}
	
	
	private Date getDate(String dateStr) {
		String date, month, year, hours, mins = "";
		
		date = dateStr.split("T")[0].split("-")[2];
		month = dateStr.split("T")[0].split("-")[1];
		year = dateStr.split("T")[0].split("-")[0];
		
		hours = dateStr.split("T")[1].split(":")[0];
		mins = dateStr.split("T")[1].split(":")[1];
		
		Date formattedDate = null;
		try {
			formattedDate = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(new StringBuilder().append(date).append("-").append(month).append("-").append(year).append(" ").append(hours).append(":").append(mins).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return formattedDate;
	}
}
