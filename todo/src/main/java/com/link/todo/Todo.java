package com.link.todo;

public class Todo {
	private int id;
	private String title;
	private String desc;
	private String status;
	private boolean inProgress;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public Todo(int id, String title, String desc, String status, boolean inProgress) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.status = status;
		this.inProgress = inProgress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	

}
