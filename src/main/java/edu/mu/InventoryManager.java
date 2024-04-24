package edu.mu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InventoryManager {
	
	public boolean readFromFile(String fileName) {
		String line = "";
		String split = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while ((line = br.readLine()) != null) { 
				String[] v = line.split(split);
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

}