package edu.mu;

public class CardCheckoutStrategy implements ICheckoutStrategy {

	/**
	 * Checkout strategy implemented for card
	 * 
	 * @param total
	 * @return {boolean} true if checkout was successful, false if it was not
	 */
	@Override
	public boolean checkout(double total) {
		System.out.println("Thank you for checking out with card. Your total is $" + total);
		return true;
	}
	
}
