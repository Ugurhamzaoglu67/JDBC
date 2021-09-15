package com.ugurhmz.stock.tests;

import com.ugurhmz.stock.manager.ProductManagerDAO;




public class ProductDeleteTest {

	public static void main(String[] args) {
		ProductManagerDAO manager = new ProductManagerDAO();
		long productId = 43;
		
		try {
			if(manager.delete(productId)) {
				System.out.println(productId+" : Product deleted.");
			} else {
				System.out.println("Product could not be deleted");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
}
