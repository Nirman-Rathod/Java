package com.nirman.easymock;

public class Customer {

	String name;
	Retailer retailer;

	public int getProductPrice(String productId) throws Exception{
		int price = retailer.getPriceForProduct(productId);
		return price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

}
