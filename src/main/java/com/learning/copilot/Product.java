package com.learning.copilot;

public class Product {
	private int id;
	private String name;
	private int quantity;

	// Constructor
	public Product(int id, String name, int quantity) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	// Getters and Setters
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

	// toString method
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", quantity=" + quantity +
				'}';
	}
}
