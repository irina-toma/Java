package com.link.todo;

public class Todo {
	private Integer id;
	private String title;
	private String desc;
	private String status;
	private Boolean inProgress;

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

	public Boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(Boolean inProgress) {
		this.inProgress = inProgress;
	}

	public Todo(Integer id, String title, String desc, String status, Boolean inProgress) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.status = status;
		this.inProgress = inProgress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.title + " " + this.desc;
	}

	

}
