package com.todoList.project.enuns;

public enum TaskStatus {
	PENDING(1),
	CONCLUDED(2),
	ACTIVE(3),
	RUNNING(4);
	
	private int code;
	
	private TaskStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TaskStatus valueOf(int code) {
		for (TaskStatus value: TaskStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid TaskStatus code");
	}
}
