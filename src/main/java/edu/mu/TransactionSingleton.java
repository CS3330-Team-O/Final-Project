package edu.mu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionSingleton {
	private static TransactionSingleton instance;
	private ArrayList<Product> cart = new ArrayList<>();
	private double total;
	
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

    public double getTotal() {
        return total;
    }
    
    public void checkout() {
    	int valid = 0;
    	ICheckoutStrategy checkoutStrategy = null;
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
