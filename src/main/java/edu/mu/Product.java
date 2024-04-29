package edu.mu;

public abstract class Product {
	
	protected int id = 0;
	protected String type;
	protected String title;
	protected double price;
	protected int stock;
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id++;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getCost() {
		return price;
	}
	public void setCost(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", title=" + title + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
	
	public abstract boolean isInStock(int stock);
}
