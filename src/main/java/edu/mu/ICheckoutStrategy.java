package edu.mu;

public interface ICheckoutStrategy {
	//Checkout strategy that will be implemented for cash or card
	boolean checkout(double total);
}
