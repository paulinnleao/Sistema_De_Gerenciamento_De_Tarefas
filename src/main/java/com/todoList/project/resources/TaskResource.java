package com.todoList.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoList.project.entities.Task;
import com.todoList.project.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskResource {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		List<Task> list = taskService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id){
		Task obj = taskService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
