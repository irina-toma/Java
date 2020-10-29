package com.example.models;

public class Product {
	private int id;
	private String name;
	private int quantity;
	private double price;
	
	public Product(int id, String name, int quantity, double price ) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
