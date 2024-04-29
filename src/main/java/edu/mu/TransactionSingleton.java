package edu.mu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionSingleton {
	private static TransactionSingleton instance;
	private ArrayList<Product> cart = new ArrayList<>();
	private double total;

	private static BookClubManager bookBoy = new BookClubManager();
	
	private TransactionSingleton() {
        cart = new ArrayList<>();
        total = 0.0;
    }
	
	public static TransactionSingleton getInstance() {
        if (instance == null) {
            instance = new TransactionSingleton();
        }
        return instance;
    }
	
	public void addItemToCart(Product product) {
        cart.add(product);
        total += product.getCost();
    }
	
	public void removeItemFromCart(Product product) {
        cart.remove(product);
        total -= product.getCost();
    }
	
	public void clearCart() {
		cart.clear();
		total = 0.0;
	}
	
	public void printCart() {
		for (Product product : cart) {
            System.out.println(product);
        }
    }

	public boolean BookClub(){
		System.out.println("Are you a member of the book club?\n1. yes \n2. no");
		try {
			Scanner scanner = new Scanner(System.in);
			int type = scanner.nextInt();
			if(type == 1) {
			}
			else if (type == 2){
				return false;
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

    public double getTotal() {
        return total;
    }
    
    public void checkout() {
    	int valid = 0;
    	ICheckoutStrategy checkoutStrategy = null;

		if(BookClub()){
			this.total = this.total * 0.8;
		}

    	System.out.println("Would you like to pay with cash or card? \n1. Cash \n2. Card");
    	while(valid == 0) {
    		try {
    			Scanner scanner = new Scanner(System.in);
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
    	clearCart();
    }
}
