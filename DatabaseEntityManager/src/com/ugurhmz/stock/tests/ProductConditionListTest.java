package com.ugurhmz.stock.tests;

import java.sql.SQLException;
import java.util.List;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;

public class ProductConditionListTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ProductManagerDAO manager = new ProductManagerDAO();
		double salesPrice = 7500;
		
		List<Product> productList = manager.listAllBySalesPriceGreaterThan(salesPrice);
		
		if(productList != null) {
			for(Product prd : productList) {
				System.out.printf("%10d  %-20s %10.2f \r\n",prd.getProductId(),prd.getProductName(), prd.getSalesPrice());
			}
			
		} else {
			System.out.println("Product list  not found");
		}
		
		
	}
}
