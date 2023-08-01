package com.todoList.project.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.todoList.project.entities.Task;
import com.todoList.project.entities.User;
import com.todoList.project.enuns.TaskStatus;
import com.todoList.project.repositories.TaskRepository;
import com.todoList.project.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void run(String... args) throws Exception {
	
		User user0 = new User(null, "Paulo");
		User user1 = new User(null, "Jonatas");
		User user2 = new User(null, "Lorena");
		User user3 = new User(null, "Isabela");
		
		userRepository.saveAll(Arrays.asList(user0,user1,user2,user3));
		
		taskRepository.save(new Task(null, "Ordem de servico",
				"Sistema para agendar tarefas", Instant.parse("2023-07-01T13:17:00Z"),
				user1, TaskStatus.ACTIVE, Instant.parse("2023-07-02T13:17:00Z")));
		
	}
	
	
}
