package com.jsp.TaskManagement.REPOSITORY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.TaskManagement.DTO.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>
{
	// using JPQL
	// by default @Query accepts JPQL query
	@Query("select t from Task t where t.status='completed' ")
	 public List<Task> findAllCompletedTask();
	
	
	// using native SQL
	
	//@Query(value = "select * from task where status='completed' ",nativeQuery = true)
	// public List<Task> findAllCompletedTask();

	// Custom query where input can be taken from User
	@Query("select t from Task t where t.name=?1")
	public Task findByName(String name);
}

















