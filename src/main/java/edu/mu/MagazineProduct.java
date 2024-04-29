package edu.mu;

public class MagazineProduct extends Product{

	public MagazineProduct() {
	}
	
	
	public MagazineProduct(int id, productType type, String title, double price, int stock) {
		super.id = id;
		super.type=type;
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
		
	

	@Override
	public boolean isInStock(int stock) {
		if(stock == 0) {
			System.out.println("This magazine is out of stock!");
			return false;
		}
		else {
			System.out.println("This magazine is still in stock!");
			return true;
		}
	}
	
}
