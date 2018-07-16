package com.sainsburys.webscraper.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Summary{
	
	private final BigDecimal gross;
	
	private final BigDecimal vat;
	
	private static final BigDecimal VATPERCENTAGE = new BigDecimal("0.2");
	
	public Summary(BigDecimal gross) {
		this.gross = gross;
		this.vat = gross.multiply(VATPERCENTAGE).setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal getGross() {
		return gross;
	}
	
	public BigDecimal getVat() {
		return vat;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gross == null) ? 0 : gross.hashCode());
		result = prime * result + ((vat == null) ? 0 : vat.hashCode());
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
		Summary other = (Summary) obj;
		if (gross == null) {
			if (other.gross != null)
				return false;
		} else if (!gross.equals(other.gross))
			return false;
		if (vat == null) {
			if (other.vat != null)
				return false;
		} else if (!vat.equals(other.vat))
			return false;
		return true;
	}
	

}