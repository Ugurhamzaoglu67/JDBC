package com.ugurhmz.stock.tests;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;

public class ProductInsertTest {

	public static void main(String[] args) {
		
		Product product1 = new Product(0,"Puma",650);
		ProductManagerDAO manager = new ProductManagerDAO();
		
		
		
		
		try {
			manager.insert(product1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
