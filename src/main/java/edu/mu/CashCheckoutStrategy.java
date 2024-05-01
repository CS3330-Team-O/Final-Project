package edu.mu;

import java.util.Scanner;

public class CashCheckoutStrategy implements ICheckoutStrategy {

	//Cash checkout strategy that returns change
	@Override
	public void checkout(double total) {
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
		System.out.printf("Your change is $" + "%.2f%n", change);
		scanner.close();
	}

}
