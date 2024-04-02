package com.jsp.TaskManagement.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.TaskManagement.DAO.TaskDao;
import com.jsp.TaskManagement.DTO.Task;

@RestController
public class TaskController {
	// annotation
	@Autowired
	TaskDao dao;

	// API for inserting object
	@PostMapping("/task")
	public Task insertTask(@RequestBody Task task)
	{
		return dao.addTask(task);
	}
	
	// API for fetching all object 
	@GetMapping("/task")
	public List<Task> allTask()
	{
		return dao.getAllTasks();
	}
	
	// API for fetching one object
	@GetMapping("/gettask")
	public Task getTask(@RequestParam int taskId)
	{
		return dao.findTask(taskId);
	}
	
	// API for deleting an object
	@DeleteMapping("/task")
	public void deleteTask(@RequestParam int taskId)
	{
		dao.deleteTask(taskId);
	}

	// API for updating task object
	@PutMapping("/task")
	public String updateTask(@RequestParam int id, @RequestParam String status , @RequestParam String description)
	{
		return dao.updateTask(id, status, description);
	}
	
	// API for fetching all completed tasks
	@GetMapping("/get")
	public List<Task> getAll()
	{
		return dao.getAllTask();
	}
	
	// API for fetching tasks based on name
	
	
	
	@GetMapping("/name")
	public Task findByName(@RequestParam String name)
	{
		return dao.findByName(name);
	}
}















