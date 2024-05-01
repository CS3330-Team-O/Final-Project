package edu.mu;

public class Main {

	public static void main(String[] args) {
		//start
		System.out.println("Library-------\n");
		//"Instantiate" singleton
		TransactionSingleton transaction = TransactionSingleton.getInstance();
		
		//Read in inventory
		InventoryManager im = new InventoryManager("inventory.csv");
		
		//Display inventory
		im.displayAllProductInformation();
		
		//Add DVD product
		Product p = new DVDProduct(5, "DavidTest", 15.09, 10);
		im.addProduct(p);
		
		//Add another product
		Product p1 = new BookProduct(6, "AshleyTest", 16.00, 2);
		im.addProduct(p1);
		
		//Add that DVD product to cart
		transaction.addItemToCart(p);
		
		//Add another item to cart
		transaction.addItemToCart(p1);
		
		//Print cart
		System.out.println("Cart with two products:");
		transaction.printCart();
		
		//check total
		double total = transaction.getTotal();
		System.out.println("Total = " + total);
		
		//Remove the DVD product to cart
		transaction.removeItemFromCart(p);
		
		//Print cart
		System.out.println("Cart with one product:");
		transaction.printCart();
		
		//check total
		total = transaction.getTotal();
		System.out.println("Total = " + total);
		
		//Checkout
		transaction.checkout();
		
		//Make sure checkout worked
		System.out.println("Cart with no products:");
		transaction.printCart();
		total = transaction.getTotal();
		System.out.println("Total = " + total);
		
		//Save product back to inventory
		im.saveProductList();
	}

}
