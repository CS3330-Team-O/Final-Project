package edu.mu;

public class BookProduct extends Product {

	public BookProduct() {
	}
	
	
	public BookProduct(int id, productType type, String title, double price, int stock) {
		super.id = id;
		super.type=type;
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
		
	

	@Override
	public boolean isInStock(int stock) {
		if(stock == 0) {
			System.out.println("This book is out of stock!");
			return false;
		}
		else {
			System.out.println("This book is still in stock!");
			return true;
		}
	}

	@Override
	public int updateStock(int stock) {
		return stock--;
	}
	
	

}
