package com.todoList.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoList.project.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
