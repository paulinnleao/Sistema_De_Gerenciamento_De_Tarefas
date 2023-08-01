package com.todoList.project.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import com.todoList.project.enuns.TaskStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private LocalDate dateCreation;
	private Date deadline;
	
	private int taskStatus;
	
	@ManyToOne
	private User user;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Task(Long id, String name, String description, TaskStatus taskStatus, String daedline) {
		this.id = id;
		this.name = name;
		this.description = description;
		setTaskStatus(taskStatus);
		dateCreation = LocalDate.now();
		try {
			this.deadline = sdf.parse(daedline);
		}catch(ParseException e) {
			e.printStackTrace();
		}
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
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
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
