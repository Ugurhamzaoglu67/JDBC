package com.ugurhmz.stock.tests;


import java.util.TreeSet;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;

public class ProductListTest {
	public static void main(String[] args) throws ClassNotFoundException {
		
		ProductManagerDAO manager = new ProductManagerDAO();
		
		TreeSet<Product> productList = (TreeSet<Product>) manager.listAll();
		
		if(productList != null) {
			for(Product prd : productList) {
				System.out.printf("%10d  %-20s %10.2f \r\n",prd.getProductId(),prd.getProductName(), prd.getSalesPrice());
			}
			
			
		} else {
			System.out.println("Products not found!!");
		}
	}
}
