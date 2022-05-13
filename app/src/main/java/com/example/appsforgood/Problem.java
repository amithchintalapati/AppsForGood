package com.example.appsforgood;

public class Problem {
	private Account person;
	private String task;
	private String description;
	private int priority;

	public Problem(){

	}

	public Problem(String task, String description, int priority) {
		this.task = task;
		this.description = description;
		this.priority = priority;
	}
	
	public void setAccount(Account person) {
		this.person = person;
	}
	
	public Account getAccount() {
		return person;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public String getTask() {
		return task;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
