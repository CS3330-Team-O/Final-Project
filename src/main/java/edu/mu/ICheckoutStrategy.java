package edu.mu;

public interface ICheckoutStrategy {
	
	/**
	 * Checkout strategy that will be implemented for cash or card
	 * 
	 * @param total
	 * @return {boolean} true if checkout was successful, false if it was not
	 */
	boolean checkout(double total);
	
}
