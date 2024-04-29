package edu.mu;

public abstract class Product {
	
	protected int id = 0;
	protected productType type = null;
	protected String title;
	protected double price;
	protected int stock;
	
	public int getId() {
		return id;
	}
	public void setId() {
		this.id++;
	}
	public productType gettype() {
		return type;
	}
	public void setType(productType type) {
		try {
			this.type = type;
		}catch(Exception e) {
			System.out.println("Error in setType: " + e);
		}
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
	
	public abstract int updateStock(int stock);
}
