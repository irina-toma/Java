package com.link.weather;

public class Sky {
	private String main;
	private String description;
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Sky(String main, String description) {
		super();
		this.main = main;
		this.description = description;
	}
	
}
