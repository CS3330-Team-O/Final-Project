package edu.mu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class InventoryManagerTest {
	private File f = null;
	private InventoryManager im = null;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.im = new InventoryManager();
		this.f = new File("testCSV.csv");
		FileWriter w = new FileWriter("testCSV.csv");
	    w.write("product_id,product_type,product_name,product_price,product_stock\n1,Book,The Hunger Games,30,10\n2,DVD,Finding Nemo,15.20,13\n3,Magazine,Fortune,5.99,50\n4,Audiobook,Lord of the rings,25.35,8");
	    w.close();
	    im.readFromFile("testCSV.csv");
	}

	@AfterEach
	public void tearDown() throws Exception {
		f.delete();
	}
	
	@Test
	@Order(1)
	public void findProductTest() {
		Product findThis = im.productList.get(0);
		boolean found = im.findProduct(findThis);
		assertTrue(found);
	}
	
	@Test
	@Order(1)
	public void findProductByIdTest() {
		Product foundProduct = im.findProduct(1);
		boolean correctProduct = im.findProduct(foundProduct);
		assertTrue(correctProduct);
	}
	
	@Test
	@Order(2)
	public void addProductTest() {
		Product p = new DVDProduct(5, "DavidTest", 15.09, 10);
		im.addProduct(p);
		boolean found = im.findProduct(p);
		assertTrue(found);
	}
	
	@Test
	@Order(2)
	public void removeProductTest() {
		Product p = new DVDProduct(5, "DavidTest", 15.09, 10);
		im.addProduct(p);
		im.removeProduct(p);
		boolean found = im.findProduct(p);
		assertFalse(found);
	}
	
	@Test
	@Order(3)
	public void saveProductListTest() {
		Product p = new DVDProduct(5, "DavidTest", 15.09, 10);
		im.addProduct(p);
		im.saveProductList();
		Object copyOfProductList = new ArrayList<>();
		copyOfProductList= im.getProductList().clone();
		im.readFromFile("testCSV.csv");
		boolean same = copyOfProductList.equals(im.getProductList());
		assertTrue(same);
	}

}
