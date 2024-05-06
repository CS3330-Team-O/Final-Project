package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardCheckoutStrategyTest {

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running Before Each");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		CardCheckoutStrategy cardCheckoutStrategy = new CardCheckoutStrategy();
		assertEquals(true, cardCheckoutStrategy.checkout(10.00));
	}

}
