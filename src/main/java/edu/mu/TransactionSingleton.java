package edu.mu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionSingleton {
	private static TransactionSingleton instance;
	private ArrayList<Product> cart = new ArrayList<>();
	private double total;

	private static BookClubManager bookBoy = new BookClubManager();

	//Initializes total and array list
	private TransactionSingleton() {
        cart = new ArrayList<>();
        total = 0.0;
    }
	
	//Singleton design pattern to make sure there is only one instance of TransactionSingleton
	public static TransactionSingleton getInstance() {
        if (instance == null) {
            instance = new TransactionSingleton();
        }
        return instance;
    }
	
	//Adds item to cart by adding the item to the cart array list and adding the price to the total
	public boolean addItemToCart(Product product) {
		if(product.isInStock(product)) {
			cart.add(product);
	        total += product.getCost();
	        return true;
		}
        return false;
    }
	
	//Removes item to cart by removing the item to the cart array list and subtracting the price to the total
	public boolean removeItemFromCart(Product product) {
		if(product.updateStock(product)) {
			cart.remove(product);
	        total -= product.getCost();
	        return true;
		}
        return false;
    }
	
	//Helper method to be called in checkout() that clears array list and resets total to 0.0
	public void clearCart() {
		cart.clear();
		total = 0.0;
	}
	
	//Prints cart helper method used in main
	public void printCart() {
		for (Product product : cart) {
            System.out.println(product);
        }
    }

	//Determines if members are in book club
	public boolean BookClub(){
		System.out.println("Are you a member of the book club?\n1. yes \n2. no");
		try {
			Scanner scanner = new Scanner(System.in);
			int type = scanner.nextInt();
			if(type == 1) {
			}
			else if (type == 2){
				System.out.println("Enter your name and email to join. \"last,first email\"");
				String name = scanner.next();
				String email = scanner.next();
				bookBoy.newCustomer(name, email);
				return true;
			} else {
				System.out.println("Invalid input. Enter a 1 or a 2");
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a number.");
		}

		//Name enter to search for customer in book club
		System.out.println("Please enter your name in format (last, first)");
		try {
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			scanner.close();
			if(bookBoy.findCustomer(name)) {
				return true;
			} else {
				return false;
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter your name in format (last, first)");
		}


		return false;
	}

    //Returns total price of books in cart to be used in main
    public double getTotal() {
        return total;
    }
    
    //Checkout checks out the user and uses strategy method to checkout with cash or card
    public boolean checkout() {
    	int valid = 0;
    	Scanner scanner = new Scanner(System.in);
    	ICheckoutStrategy checkoutStrategy = null;

		if(BookClub()){
			this.total = this.total * 0.8;
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
    	scanner.close();
    	if(checkoutStrategy.checkout(total)) {
    		System.out.println("Thank you for shopping with us!");
    		clearCart();
    		return true;
    	}
    	System.out.println("Unable to checkout");
    	return false;
    	
    }
}
