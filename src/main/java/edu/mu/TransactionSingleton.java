package edu.mu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionSingleton {
	private static TransactionSingleton instance;
	private ArrayList<Product> cart = new ArrayList<>();
	private double total;

	private static final BookClubManager bookBoy = new BookClubManager();

	/**
	 * Constructor that initializes total and array list
	 */
	private TransactionSingleton() {
        cart = new ArrayList<>();
        total = 0.0;
    }
	
	/**
	 * Singleton design pattern to make sure there is only one instance of TransactionSingleton
	 * 
	 * @return {instance} returns singleton instance
	 */
	public static TransactionSingleton getInstance() {
        if (instance == null) {
            instance = new TransactionSingleton();
        }
        return instance;
    }
	
	/**
	 * Adds item to cart by adding the item to the cart array list and adding the price to the total
	 * 
	 * @param {product} product to add to cart
	 * @return {boolean} true if item was in stock add added to card, false if the item was not in stock
	 */
	public boolean addItemToCart(Product product) {
		if(product.isInStock(product)) {
			cart.add(product);
	        total += product.getCost();
	        return true;
		}
        return false;
    }
	
	/**
	 * Removes item to cart by removing the item to the cart array list and subtracting the price to the total
	 * 
	 * @param {product} product that will be removed from cart
	 * @return {boolean} true if product was removed from the cart, false if the product could not be removed from the stock
	 */
	public boolean removeItemFromCart(Product product) {
		if (product.updateStock(product)) {
			cart.remove(product);
	        total -= product.getCost();
	        return true;
		}
        return false;
    }
	
	/**
	 * Clears cart
	 * Helper method to be called in checkout() that clears array list and resets total to 0.0
	 * 
	 * @return {boolean}
	 */
	public boolean clearCart() {
		cart.clear();
		total = 0.0;
		if(total == 0.0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Prints cart
	 * Helper method used in main
	 */
	public boolean printCart() {
		for (Product product : cart) {
            System.out.println(product);
        }
		return true;
    }

	/**
	 * Returns total price of books in cart
	 * Helper method used in main
	 */
    public double getTotal() {
        return total;
    }
    
    /**
     * Checkout checks out the user and uses strategy method to checkout with cash or card
     * 
     */
    public void checkout() {
    	int valid = 0;
    	Scanner scanner = new Scanner(System.in);
    	ICheckoutStrategy checkoutStrategy = null;

		if(bookBoy.BookClub(scanner)){
			this.total = this.total * 0.8;
		} else {
			System.out.println("Name not found");
		}

    	System.out.println("Would you like to pay with cash or card? \n1. Cash \n2. Card");
    	while(valid == 0) {
    		try {
        		int type = scanner.nextInt();
            	if(type == 1) {
            		checkoutStrategy = new CashCheckoutStrategy();
            		valid =1;
            	}
            	else if(type == 2) {
            		checkoutStrategy = new CardCheckoutStrategy();
            		valid =1;
            	}
            	else {
            		System.out.println("Invalid input. Enter a 1 or a 2");
            	}
        	}
        	catch (InputMismatchException e) {
        		System.out.println("Invalid input. Please enter a number.");
        	}
    	}
    	checkoutStrategy.checkout(total);
    	System.out.println("Thank you for shopping with us!");
    	scanner.close();
    	clearCart();
    }
    
}
