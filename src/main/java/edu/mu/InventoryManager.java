package edu.mu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryManager {
	
	public ArrayList <Product> productList = new ArrayList<>();
	
	public boolean readFromFile(String fileName) {
		String line = "";
		String split = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while ((line = br.readLine()) != null) { 
				String[] v = line.split(split);
				int id = Integer.parseInt(v[0]);
				String type = v[1];
				String title = v[1];
				double price = Double.parseDouble(v[3]);
				int stock = Integer.parseInt(v[4]);
				switch (type) {
					case "Book":
						Product book = new BookProduct(id, title, price, stock);
						this.productList.add(book);
						break;
					case "Audiobook":
						Product audiobook = new AudioBookProduct(id, title, price, stock);
						this.productList.add(audiobook);
						break;
					case "Magazine":
						Product magazine = new MagazineProduct(id, title, price, stock);
						this.productList.add(magazine);
						break;
					case "DVD":
						Product dvd = new DVDProduct(id, title, price, stock);
						this.productList.add(dvd);
						break;
				}
			}
			br.close();
			return true;
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			return false;
		}
	}

	public InventoryManager(String fileName) {
		readFromFile(fileName);
	}
	
	public InventoryManager() {
		
	}
	
	public void displayAllProductInformation() {
		boolean cars = false;
		for(int i = 0; i < productList.size(); i++){
				if(productList.get(i) instanceof Product) {
					cars=true;
					System.out.println("id: " + productList.get(i).id + ", title: " + productList.get(i).title + ", price: " + productList.get(i).price + ", stock: " + productList.get(i).stock);
				}
			}
		if(!cars) {
			System.out.println("There are no cars in this list!");
		}
	}

}