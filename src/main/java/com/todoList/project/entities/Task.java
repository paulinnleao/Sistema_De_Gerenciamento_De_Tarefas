package com.todoList.project.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todoList.project.enuns.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dateCreation;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant deadline;
	
	private int taskStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Task(Long id, String name, String description,Instant dateCreation,User user, TaskStatus taskStatus, Instant deadline) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.dateCreation = dateCreation;
		this.user = user;
		setTaskStatus(taskStatus);
		this.deadline = deadline;
	}
	public Task() {
	}
	
	public TaskStatus getTaskStatus() {
		return TaskStatus.valueOf(this.taskStatus);
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		if(taskStatus!=null) {
			this.taskStatus = taskStatus.getCode();
		}
	}
	public Instant getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Instant dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Instant getDeadline() {
		return deadline;
	}
	public void setDeadline(Instant deadline) {
		this.deadline = deadline;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(id, other.id);
	}
}
