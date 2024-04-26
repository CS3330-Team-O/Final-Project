package edu.mu;

import java.util.Scanner;

public class CashCheckoutStrategy implements ICheckoutStrategy {

	@Override
	public void checkout(double total) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Thank you for checking out with cash. Your total is " + total);
		System.out.println("How much would you like to pay with? ");
		double payWith = scanner.nextDouble();
		double change = payWith - total;
		System.out.println("Your change is" + change);
		scanner.close();
	}

}
