package com.sainsburys.webscraper.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Output{
	private List<Product> results = new ArrayList<>();
	private Summary total = null;

	public Summary getTotal() {
		return total;
	}
	public void setTotal(Summary total) {
		this.total = total;
	}
	public List<Product> getResults() {
		return results;
	}
	public void setResults(List<Product> results) {
		this.results = results;
		this.total = new Summary(calculateGross(results));
	}
	private BigDecimal calculateGross(List<Product> results2) {
		return results2.stream().map((p) -> p.getUnit_price()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {}
		return "";
	}
	
}