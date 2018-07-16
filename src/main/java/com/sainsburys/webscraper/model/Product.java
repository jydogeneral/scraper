package com.sainsburys.webscraper.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Product{
	private final String title;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final Integer kcal_per_100g;
	private final BigDecimal unit_price;
	private final String description;

	public Product(String title, Integer kcal_per_100g, BigDecimal unit_price, String description) {
		this.title = title;
		this.kcal_per_100g = kcal_per_100g;
		this.unit_price = unit_price;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public Integer getKcal_per_100g() {
		return kcal_per_100g;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", kcal_per_100g=" + kcal_per_100g + ", unit_price=" + unit_price
				+ ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((kcal_per_100g == null) ? 0 : kcal_per_100g.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((unit_price == null) ? 0 : unit_price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (kcal_per_100g == null) {
			if (other.kcal_per_100g != null)
				return false;
		} else if (!kcal_per_100g.equals(other.kcal_per_100g))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (unit_price == null) {
			if (other.unit_price != null)
				return false;
		} else if (!unit_price.equals(other.unit_price))
			return false;
		return true;
	}
	
}