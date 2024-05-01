package edu.mu;

public class DVDProduct extends Product{
	
	public DVDProduct() {
	}
	
	public DVDProduct(int id, String title, double price, int stock) {
		super.id = id;
		super.type=productType.DVD;
		super.title=title;
		super.price=price;
		super.stock=stock;
	}
	
	public void copy(DVDProduct d) {
		this.id = d.id;
		this.title=d.title;
		this.price=d.price;
		this.stock=d.stock;
	}

}
