package edu.mu;

public class BookProduct extends Product {

	public BookProduct() {
	}
	
	public BookProduct(int id, String title, double price, int stock) {
		super.id = id;
		super.type=productType.Book;
		super.title=title;
		super.price=price;
		super.stock=stock;
	}
	
	
	public void copy(BookProduct b) {
		this.id = b.id;
		this.title=b.title;
		this.price=b.price;
		this.stock=b.stock;
	}
		
	



}
