package edu.mu;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import junit.framework.TestCase;

public class InventoryManagerTest extends TestCase {
	
	private ArrayList <Product> productList = new ArrayList<>();
	private File f;

	public InventoryManagerTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		this.f = new File("testCSV.csv");
		FileWriter w = new FileWriter("testCSV.csv");
	    w.write("product_id,product_type,product_name,product_price,product_stock\n1,Book,The Hunger Games,30,10\n2,DVD,Finding Nemo,15.20,13\n3,Magazine,Fortune,5.99,50\n4,Audiobook,Lord of the rings,25.35,8");
	    w.close();
	}

	protected void tearDown() throws Exception {
		f.delete();
	}

}
