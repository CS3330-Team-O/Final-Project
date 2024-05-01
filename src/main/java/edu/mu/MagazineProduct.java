package edu.mu;

public class MagazineProduct extends Product{

	public MagazineProduct() {
	}
	
	public MagazineProduct(int id, String title, double price, int stock) {
		super.id = id;
		super.type=productType.Magazine;
		super.title=title;
		super.price=price;
		super.stock=stock;
	}
	
	
	public void copy(MagazineProduct m) {
		this.id = m.id;
		this.title=m.title;
		this.price=m.price;
		this.stock=m.stock;
	}
		
	

	
}
