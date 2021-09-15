package com.ugurhmz.stock.tests;


import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;





public class ProductUpdateTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ProductManagerDAO manager  = new ProductManagerDAO();
		//Product product = new Product(13124,"LCD NEW TV",7600);
		Product product = new Product(4,"LCD NEW TV",7600);
		
		if(manager.update(product)) {
			System.out.println("Updated success");
			System.out.println(product.getProductId() + " "+ product.getProductName() + " "+product.getSalesPrice());
		} else {
			System.out.println("Product not updated");
		}
		
		
	}

}
