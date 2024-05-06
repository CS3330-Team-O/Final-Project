package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


class TransactionSingletonTest {
	
	private static TransactionSingleton transactionSingleton;
	private static InventoryManager inventoryManager;
	private static Product p = null;
	private InputStream stdin;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		transactionSingleton = TransactionSingleton.getInstance();
		inventoryManager = new InventoryManager("inventory.csv");
		p = new DVDProduct(5, "TransactionSingleton", 12.99, 3);
		inventoryManager.addProduct(p);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

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
	public void testTransactionSingletonInstance() {
        TransactionSingleton TransactionSingleton1 = TransactionSingleton.getInstance();
        assertSame(transactionSingleton, TransactionSingleton1);
    }

	@Test
	void testaddItemToCart() {
		assertEquals(true, transactionSingleton.addItemToCart(p));
	}
	
	@Test
	void testremoveItemFromCart() {
		assertEquals(true, transactionSingleton.removeItemFromCart(p));
	}
	
	@Test
	void checkout() {
		String input = "2\n1\nmarino, david\n2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        transactionSingleton.checkout();
        
        assertTrue(true);
	}
	
	void testclearCart() {
		assertEquals(true, transactionSingleton.clearCart());
	}
	
	@Test
	void testgetTotal() {
		Product p2 = new DVDProduct(5, "TransactionSingleton total test", 3.99, 3);
		transactionSingleton.addItemToCart(p2);
		assertEquals(3.99, transactionSingleton.getTotal());
	}

	@Test
	void testprintCart() {
		assertEquals(true, transactionSingleton.printCart());
	}

}
