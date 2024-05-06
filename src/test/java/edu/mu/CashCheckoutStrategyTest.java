package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class CashCheckoutStrategyTest{
	
	private InputStream stdin;
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running Before Each");
        stdin = System.in; // Backup of System.in
	}

	@AfterEach
	void tearDown() throws Exception {
        System.setIn(stdin); // Restore original System.in
	}

	@Test
	void checkout() {
		CashCheckoutStrategy ccs = new CashCheckoutStrategy();
		String input = "10.0\n90.0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ccs.checkout(100.0);
	}

    

}
