package com.nirman.easymock;

public class Retailer {

	private int taxes_in_percent = 10;

	public int getPriceForProduct(String productId) throws Exception {
		int price;
		if (productId.equals("101")) {
			price = getPrice(100);
		} else if (productId.equals("102")) {
			price = getPrice(200);
		} else if (productId.equals("103")) {
			price = getPrice(300);
		} else {
			price = 0;
		}
		return price;
	}

	private int getPrice(int basePrice) {
		int finalPrice = basePrice + ((basePrice * getTaxRate()) / 100);
		return finalPrice;
	}

	public int getTaxRate() {
		return taxes_in_percent;
	}
}
