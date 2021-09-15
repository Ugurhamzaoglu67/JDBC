package com.ugurhmz.stock.entity;



public class Product  implements Comparable<Product>{

	private long productId;
	private String productName;
	private double salesPrice;
	
	
	
	public Product() {
		
	}
	
	
	public Product(long productId, String productName, double salesPrice) {
		
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}


	@Override
	public int compareTo(Product o) {
		if(this.productId > o.productId ) {
			return 1;
			
		} else if(this.productId < o.productId) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	
}
