package com.ugurhmz.stock;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManager;

public class MainTest {

	public static void main(String[] args) {
		
		Product product1 = new Product(0,"Puma",650);
		
		
		ProductManager manager = new ProductManager();
		
		try {
			manager.insert(product1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
