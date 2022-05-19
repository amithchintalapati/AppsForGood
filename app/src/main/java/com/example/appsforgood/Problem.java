package com.example.appsforgood;

public class Problem {
	// Class variables for a problem
	private String task;
	private String description;
	private int priority;
	private String contactInformation;

	// Empty constructor is necessary for implementation
	public Problem(){

	}

	// Constructor assigns all necessary values to class variables
	public Problem(String task, String description, int priority, String contactInformation) {
		this.task = task;
		this.description = description;
		this.priority = priority;
		this.contactInformation = contactInformation;
	}

	// Getters
	public String getTask() {
		return task;
	}
	
	public int getPriority() {
		return priority;
	}

	public String getDescription() {
		return description;
	}

	public String getContactInformation() {
		return contactInformation;
	}
}
