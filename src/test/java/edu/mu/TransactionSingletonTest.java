package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionSingletonTest {
	
	private static TransactionSingleton transactionSingleton;
	private static InventoryManager inventoryManager;
	private static Product p = null;

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
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testTransactionSingletonInstance() {
        TransactionSingleton TransactionSingleton1 = TransactionSingleton.getInstance();
        TransactionSingleton TransactionSingleton2 = TransactionSingleton.getInstance();
        assertSame(TransactionSingleton1, TransactionSingleton2);
    }

	@Test
	void testaddItemToCart() {
		assertEquals(true, transactionSingleton.addItemToCart(p));
	}
	
	@Test
	void testremoveItemFromCart() {
		assertEquals(true, transactionSingleton.removeItemFromCart(p));
	}
	
	/*
	@Test
	void testBookClub() {
		assertEquals(true, transactionSingleton.BookClub());
	}*/
	
	/*
	@Test
	void testCheckout() {
		fail("Not yet implemented");
	}
	*/

}
