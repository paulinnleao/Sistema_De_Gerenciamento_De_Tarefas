package com.todoList.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.project.entities.Task;
import com.todoList.project.repositories.TaskRepository;

@Service
public class TaskService {

		@Autowired
		private TaskRepository taskRepository;
		
		public List<Task> findAll(){
			return taskRepository.findAll();
		}
		
		public Task findById(Long id) {
			Optional<Task> obj = taskRepository.findById(id);
			return obj.get();
		}
}
