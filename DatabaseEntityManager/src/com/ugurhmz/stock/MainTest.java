package com.ugurhmz.stock;

import com.ugurhmz.stock.entity.Product;
import com.ugurhmz.stock.manager.ProductManager;

public class MainTest {

	public static void main(String[] args) {
		
		Product product1 = new Product(0,"Nike Shoes",550);
		
		
		ProductManager manager = new ProductManager();
		manager.insert(product1);

	}

}
