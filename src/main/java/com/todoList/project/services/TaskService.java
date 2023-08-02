package com.todoList.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todoList.project.entities.Task;
import com.todoList.project.enuns.TaskStatus;
import com.todoList.project.repositories.TaskRepository;
import com.todoList.project.services.exceptions.DatabaseException;
import com.todoList.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		
		public Task insert(Task task) {
			return taskRepository.save(task);
		}
		
		public void delete(Long id) {
			try {
				taskRepository.deleteById(id);
			}catch(EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException(id);
			}catch(DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
		}
		
		public Task updateStatus(Long id, TaskStatus taskStatus) {
			try {
				Task task = taskRepository.getReferenceById(id);
				newStatus(task, taskStatus);
				System.out.println("TASK TASK TASK : : \n\n\n\\/\\/\\/\\/ "+ task + "^^^^^^\n\n\n\n");
				return taskRepository.save(task);
			}catch(EntityNotFoundException e) {
				throw new ResourceNotFoundException(id);
			}
		}

		private void newStatus(Task task, TaskStatus taskStatus) {
			task.setTaskStatus(taskStatus);
		}
}
