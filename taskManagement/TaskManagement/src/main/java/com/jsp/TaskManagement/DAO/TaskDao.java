package com.jsp.TaskManagement.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.TaskManagement.DTO.Task;
import com.jsp.TaskManagement.REPOSITORY.TaskRepository;

@Repository
public class TaskDao {

	@Autowired
	TaskRepository repository;

	// to add task object to DB (insertion)
	public Task addTask(Task task) {
		// save(object) ---> to insert
		return repository.save(task);
	}

	// to retrieve all objects from DB
	public List<Task> getAllTasks() {
		// findAll() ---> to fetch all objects
		return repository.findAll();
	}

	// to retrieve a object based on ID
	public Task findTask(int taskId) {
		// findById() ---> to fetch one object based on ID
		Optional<Task> opt = repository.findById(taskId);

		if (opt.isPresent()) // to check whether object is present or not
		{
			// if present, retriev object using get()
			return opt.get();
		}
		return null;
	}

	// to delete a object from DB
	public void deleteTask(int taskId) {
		
		Task t = findTask(taskId);
		if (t != null) {
			// to delete a object ---> delete(object)
			repository.delete(t);
			// OR we can delete using ---> deleteById(int id)

		}
	}
	
	// to update status and description of a task
	public String updateTask(int id , String status , String description)
	{
		 // fetching the object which has to be updated based on ID
		 Task t = findTask(id);
		 if( t!=null )
		 {
			 // setting new values to the variables
			 t.setStatus("completed");
			 t.setDescription("done studying..");
			 // saving the updated object to DB 
			 repository.save(t);
			 return "updation successfull..."; // returning string
		 }
		 return "Task not found..Cannot update";
	}

	// to retrieve all completed tasks
	public List<Task> getAllTask()
	{
		return repository.findAllCompletedTask();
	}
	
	// to retrieve task based on name
	public Task findByName(String name)
	{
		return repository.findByName(name);
	}
}

























