package edu.mu;

public class AudioBookProduct extends Product {

	public AudioBookProduct() {
	}
	
	
	public AudioBookProduct(int id, String type, String title, double price, int stock) {
		super.id = id;
		super.type="AudioBook";
		super.title=title;
		super.price=price;
		super.stock=stock;
	}
	
	
	public void copy(AudioBookProduct ab) {
		this.id = ab.id;
		this.title=ab.title;
		this.price=ab.price;
		this.stock=ab.stock;
	}
		
	

	@Override
	public boolean isInStock(int stock) {
		if(stock == 0) {
			System.out.println("This audiobook is out of stock!");
			return false;
		}
		else {
			System.out.println("This audibook is still in stock!");
			return true;
		}
	}



}
