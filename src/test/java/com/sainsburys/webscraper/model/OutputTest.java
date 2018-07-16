package com.sainsburys.webscraper.model;

import java.math.BigDecimal;
import java.util.Arrays;

import junit.framework.TestCase;

public class OutputTest extends TestCase {
	private Output output;
	public void setUp() {
		output = new Output();
		output.setResults(Arrays.asList(new Product("Product 1", 33, new BigDecimal("1.75"), "description x"),
				new Product("Product 2", 57, new BigDecimal("2.25"), "description y"),
				new Product("Product 3", 45, new BigDecimal("2"), "description z")));
	}
	public void testVatCalculation() {
		assertEquals(new BigDecimal("1.20"), output.getTotal().getVat());
	}
	
	public void testGrossValue() {
		assertEquals(new BigDecimal("6.00"), output.getTotal().getGross());
	}
	
	public void testJSONOutputWhenProductHasNoCaloriesValueSpecified() {
		output.setResults(Arrays.asList(new Product("Product 1", null, new BigDecimal("1.75"), "description x")));
		String jsonOutput = output.toString();
		System.out.println(jsonOutput);
		assertTrue(jsonOutput.indexOf("\"kcal_per_100g\"") <= -1);
	}

}
