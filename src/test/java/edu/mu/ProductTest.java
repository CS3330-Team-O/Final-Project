package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ProductTest {

	private Product p = null;
	//private static Person p2 = null;

	// This method will be invoked even before setUp() method and will be executed once
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Running Before All");
		//p2 = new Person("Jack", 11);
	}

	// This method will be executed after all test methods and tearDown() invocations are complete
	// This will be the last method to be executed this test class.
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	// This method will be invoked for each test method
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Running Before Each");
		p = new Product(2, productType.Audiobook, "Syd's Book", 1.99, 3);
	}

	// This method will be executed after the test method execution is complete
	@AfterEach
	void tearDown() throws Exception {
	}
	


    @Test
    public void testToString() {
        // Create an instance of Product
        Product product = new Product(1, productType.Book, "The Great Gatsby", 9.99, 10);

        // Call the toString() method
        String result = product.toString();

        // Assert that the result matches the expected string
        assertEquals("Product [id=1, type=Book, title=The Great Gatsby, price=9.99, stock=10]", result);
    }
    
	@Test
	@Order(1)
	void testGetID() {
		assertEquals(2, p.getId());
	}
	
	@Test
	@Order(3)
	void testGetType() {
		assertEquals(productType.Audiobook, p.getType());
	}
	
	@Test
	@Order(4)
	void testSetType() {
		p.setType(productType.Audiobook);
		assertEquals(productType.Audiobook, p.getType());
	}
	
	@Test
	@Order(2)
	void testSetID() {
		p.setId(9);
		assertEquals(9, p.getId());
	}
	
	@Test
	@Order(5)
	void testGetTitle() {
		assertEquals("Syd's Book", p.getTitle());
	}
	
	@Test
	@Order(6)
	void testSetTitle() {
		p.setTitle("Not Syd's Book");
		assertEquals("Not Syd's Book", p.getTitle());
	}
	
	@Test
	@Order(7)
	void testGetCost() {
		assertEquals(1.99, p.getCost());
	}
	
	@Test
	@Order(8)
	void testSetCost() {
		p.setCost(3.99);
		assertEquals(3.99, p.getCost());
	}
	
	@Test
	@Order(9)
	void testGetStock() {
		assertEquals(3, p.getStock());
	}
	
	@Test
	@Order(10)
	void testSetStock() {
		p.setStock(5);
		assertEquals(5, p.getStock());
	}
	
	// It is important to select test inputs around the boundaries
	@Test
	void testIsInStock() {
		Product b = new Product(2, productType.Book, "Syd's Book", 1.99, 3);
		assertEquals(true, b.isInStock(b));
	}
	
	@Test
	void testIsInStockFalse() {
		Product b = new Product(2, productType.Book, "Syd's Book", 1.99, 0);
		assertEquals(false, b.isInStock(b));
	}
	
	@Test
	void testUpdateStock() {
		Product b = new Product(2, productType.Book, "Syd's Book", 1.99, 3);
		assertEquals(true, b.updateStock(b));
	}
	
	@Test
	void testUpdateStockFalse() {
		Product b = new Product(2, productType.Book, "Syd's Book", 1.99, 0);
		assertEquals(false, b.updateStock(b));
	}
	

}
