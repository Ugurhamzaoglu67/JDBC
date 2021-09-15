package com.ugurhmz.stock.tests;

import java.sql.SQLException;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;





public class ProductFindTest {

	public static void main(String[] args) throws SQLException {
		
		ProductManagerDAO manager = new  ProductManagerDAO();
		long productId = 1;
		//long  productId = 1500;
		
		try {
			
			Product product = manager.findById(productId);
			
			if(product != null) {
				
				System.out.println("ID : "+productId);
				System.out.println("Product Name : "+product.getProductName());
				System.out.println("Sales Price : "+product.getSalesPrice());
			} else {
				System.out.println("Product not found : "+productId);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
