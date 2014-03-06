package com.nirman.easymock;

import org.easymock.EasyMock;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.*;

public class TestRetailer {

	// Without any mocks
	@Test
	public void testGetPriceForProduct() throws Exception {
		Customer customer = new Customer();
		Retailer retailer = new Retailer();
		customer.setRetailer(retailer);
		int actual = 0;

		String productId = "101";
		actual = Whitebox.<Integer> invokeMethod(customer, "getProductPrice",
				productId);

		int expected = 110;
		assertEquals(expected, actual);
	}

	// Mocked the getPriceForProduct() in retailer
	@Test
	public void testGetPriceForProductEasyMock() throws Exception {
		Customer customer = new Customer();
		Retailer retailer = EasyMock.createMock(Retailer.class);
		customer.setRetailer(retailer);
		EasyMock.expect(retailer.getPriceForProduct("101")).andReturn(220);
		EasyMock.replay(retailer);

		int actual = 0;

		String productId = "101";
		actual = Whitebox.<Integer> invokeMethod(customer, "getProductPrice",
				productId);

		int expected = 220;
		assertEquals(expected, actual);
	}

	// Assertion Error. As the mock is not activated, actual returned is 0;
	@Test
	public void testGetPriceForProductAssertionError() throws Exception {
		Customer customer = new Customer();
		Retailer retailer = EasyMock.createMock(Retailer.class);
		customer.setRetailer(retailer);
		EasyMock.expect(retailer.getPriceForProduct("401")).andReturn(220);
		int actual = 0;

		String productId = "401";
		actual = Whitebox.<Integer> invokeMethod(customer, "getProductPrice",
				productId);
		int expected = 220;
		assertEquals(expected, actual);
	}

	// Partial Mock. Specific method getTaxRate() is mocked
	@Test
	public void testGetPriceForProductPartialMock() throws Exception {
		Customer customer = new Customer();
		Retailer retailer = EasyMock.createMockBuilder(Retailer.class)
				.addMockedMethod("getTaxRate").createMock();
		customer.setRetailer(retailer);
		EasyMock.expect(retailer.getTaxRate()).andReturn(20);
		EasyMock.replay(retailer);
		int actual = 0;

		String productId = "101";
		actual = Whitebox.<Integer> invokeMethod(customer, "getProductPrice",
				productId);
		int expected = 120;
		assertEquals(expected, actual);
	}

}
