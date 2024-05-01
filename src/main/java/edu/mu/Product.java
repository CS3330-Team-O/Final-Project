package edu.mu;

public class Product {
	protected int id;
	protected productType type = null;
	protected String title;
	protected double price;
	protected int stock;
	
	public Product() {
	}
	
	public Product(int id, productType type,String title, double price, int stock) {
		this.id = id;
		this.type=productType.Audiobook;
		this.title=title;
		this.price=price;
		this.stock=stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public productType getType() {
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
	
	
	public boolean isInStock(Product product) {
		if(product.stock == 0) {
			return false;
		}
		return true;
	}
	
	public int updateStock(Product product) {
		if(product.stock!=0) {
			return --product.stock;
		}
		System.out.println("The stock cannot be updated, this item is not in stock");
		return product.stock;
	}
}
