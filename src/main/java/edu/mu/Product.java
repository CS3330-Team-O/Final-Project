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
		this.type=type;
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
		this.type = type;
	}
	public String getTitle() {
		return this.title;
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
	
	
	/**
	 * Checks if a product is still in stock.
	 *
	 * @param {Product} product The product to check for stock.
	 * @return {boolean} True if the product is in stock, false otherwise.
	 */
	public boolean isInStock(Product product) {
		if(product.stock == 0) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Updates the stock number of a product when it is bought from the store and returns a boolean value
	 * indicating whether the update was successful.
	 *
	 * @param {Product} product The product that was bought.
	 * @returns {boolean} True if the stock was successfully updated, false otherwise.
	 */
	public boolean updateStock(Product product) {
		if(product.getStock()!=0) {
			product.setStock((product.getStock())-1);
			return true;
		}
		System.out.println("The stock cannot be updated, this item is not in stock");
		return false;
	}
}
