package com.todoList.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoList.project.entities.Task;
import com.todoList.project.enuns.TaskStatus;
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
		
		public Task insert(Task task) {
			return taskRepository.save(task);
		}
		
		public void delete(Long id) {
			taskRepository.deleteById(id);
		}
		
		public Task updateStatus(Long id, String taskStatus) {
			Task task = taskRepository.getReferenceById(id);
			newStatus(task, taskStatus);
			return taskRepository.save(task);
		}

		private void newStatus(Task task, String taskStatus) {
			task.setTaskStatus(TaskStatus.valueOf(taskStatus));
		}
}
