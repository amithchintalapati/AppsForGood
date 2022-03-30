package com.example.appsforgood;

public class Problem {
	private Account person;
	private String task;
	private String status;
	public Problem(Account person, String task, String status) {
		this.person = person;
		this.task = task;
		this.status = status;
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
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	

}
