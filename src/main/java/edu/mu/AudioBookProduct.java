package edu.mu;

public class AudioBookProduct extends Product {

	public AudioBookProduct() {
	}
	
	public AudioBookProduct(int id, String title, double price, int stock) {
		super.id = id;
		super.type=type;
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
		



}
