package com.deloitte.asses.todo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.asses.todo.model.ToDoTask;
import com.deloitte.asses.todo.model.User;
import com.deloitte.asses.todo.service.TodoService;
import com.deloitte.asses.todo.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	TodoService todoTaskService;
	
	@GetMapping("/")
	public String viewLogin(Model model) {
		return "login";
	}
	
	@RequestMapping("/processLogin")
	public String processLogin(HttpServletRequest request, Model model) {
		User user = userService.findUserByIdPassword(request.getParameter("user-name"), request.getParameter("password"));
		if(user != null) {
			model.addAttribute("loggedUserName", user.getUserName());
			model.addAttribute("loggedUserId", user.getUserId());
		} else {
			model.addAttribute("Error", "Logged In Credentials Not Found Sorry !!");
			return "login";
		}
		
		List<ToDoTask> todoTasksForUser = getTasksForUser(user.getUserId());
		System.out.println(todoTasksForUser);
		if(!todoTasksForUser.isEmpty()) {
			model.addAttribute("userTodoTasks", todoTasksForUser);
		}
		return "todo-welcome";
	}

	private List<ToDoTask> getTasksForUser(String userId) {
		return  todoTaskService.getToDoTasksByUserId(userId);
	}
}
