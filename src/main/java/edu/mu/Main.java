package edu.mu;

public class Main {
	public static void main(String[] args) {
		InventoryManager im = new InventoryManager("inventory.csv");
		im.displayAllProductInformation();
		Product p = new DVDProduct(5, "DavidTest", 15.09, 10);
		im.addProduct(p);
		im.saveProductList();
	}
}
