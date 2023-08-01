package com.todoList.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoList.project.entities.User;
import com.todoList.project.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(null, "Paulo");
		return ResponseEntity.ok().body(user);
	}
	
//	public ResponseEntity<User> findById(@PathVariable Long id){
//		
//	}
}
