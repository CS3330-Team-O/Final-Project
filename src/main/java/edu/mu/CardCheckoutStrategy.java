package edu.mu;

public class CardCheckoutStrategy implements ICheckoutStrategy {

	//Card checkout strategy that simply displays total
	@Override
	public void checkout(double total) {
		System.out.println("Thank you for checking out with card. Your total is $" + total);
	}
	
}
