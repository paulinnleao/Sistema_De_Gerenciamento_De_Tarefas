package com.todoList.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
