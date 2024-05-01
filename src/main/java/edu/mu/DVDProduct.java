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

	@Override
	public boolean isInStock(int stock) {
		if(stock == 0) {
			System.out.println("This DVD is out of stock!");
			return false;
		}
		else {
			System.out.println("This DVD is still in stock!");
			return true;
		}
	}
}
