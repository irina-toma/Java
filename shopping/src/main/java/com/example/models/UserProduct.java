package com.example.models;

public class UserProduct {
	private int id;
	private int userId;
	private int productId;
	private int quantity;
	private String state;
	
	public UserProduct(int id, int userId, int productId, int quantity, String state) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.state = state;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
