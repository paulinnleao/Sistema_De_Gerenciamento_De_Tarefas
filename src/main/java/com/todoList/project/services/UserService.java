package com.todoList.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.todoList.project.entities.User;
import com.todoList.project.repositories.UserRepository;
import com.todoList.project.services.exceptions.DatabaseException;
import com.todoList.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	public User update(Long id, User user) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, user);
			return userRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
	}
}
