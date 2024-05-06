package edu.mu;

import java.util.Scanner;

public class CashCheckoutStrategy implements ICheckoutStrategy {

	/**
	 * Checkout strategy implemented for card
	 * 
	 * @param total
	 * @return {boolean} true if checkout was successful, false if it was not
	 */
	@Override
	public boolean checkout(double total) {
		Scanner scanner = new Scanner(System.in);
		double payWith = 0.0;
		System.out.println("Thank you for checking out with cash. Your total is $" + total);
		boolean check = true;
		while(check) {
			System.out.println("How much would you like to pay with? ");
			payWith = scanner.nextDouble();
			if(payWith < total) {
				System.out.println("Sorry, thats not enough.");
				continue;
			}
			check = false;
		}
		double change = payWith - total;
		scanner.close();
		if(change > 0.0) {
			System.out.printf("Your change is $" + "%.2f%n", change);
			return true;
		}
		return false;
	}

}
