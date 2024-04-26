package edu.mu;

import java.util.ArrayList;

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
    	clearCart();
    }
}
