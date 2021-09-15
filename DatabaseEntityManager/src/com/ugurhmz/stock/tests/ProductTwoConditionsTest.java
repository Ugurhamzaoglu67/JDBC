package com.ugurhmz.stock.tests;

import java.util.List;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManagerDAO;

public class ProductTwoConditionsTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ProductManagerDAO manager = new ProductManagerDAO();
		
		String likeProductName="S%";
		double salesPrice = 700;
		
		
		List<Product> listProduct = manager.listAllByProductNameLike(likeProductName, salesPrice);

		if(listProduct != null) {
			for(Product prd : listProduct) {
				System.out.printf("%10d  %-20s %10.2f \r\n",prd.getProductId(),prd.getProductName(), prd.getSalesPrice());
			}
			
		} else {
			System.out.println("Product list  not found");
		}
		
	}

}
