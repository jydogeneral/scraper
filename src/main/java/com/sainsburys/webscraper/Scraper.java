package com.sainsburys.webscraper;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.sainsburys.webscraper.dom.*;
import com.sainsburys.webscraper.model.Product;

public class Scraper{
	
	public static Product scrape(Page page) {
		Product product = new Product(getTitle(page), getKCal(page), getProductPrice(page), getProductDescription(page));
		return product;
	}
	
	private static BigDecimal getProductPrice(Page page) {
		String productPrice = page.select(".productSummary .pricing .pricePerUnit").texts().get(0);
		return toDecimal(productPrice);
	}

	private static String getProductDescription(Page page) {
		PageElement prodDescElem = page.select("#information");
		String prodDesc = "";
		for(int i = 0; i < prodDescElem.texts().size(); i++) {
			String e = prodDescElem.texts().get(i);
			if(e.equalsIgnoreCase("Description")) {
				prodDesc = prodDescElem.texts().get(i+1);
				break;
			}
		}
		return prodDesc;
	}

	private static String getTitle(Page page) {
		PageElement productTitleElem = page.select(".productSummary .productTitleDescriptionContainer");
		String productTitle = productTitleElem.texts().get(0);
		return productTitle;
	}

	private static Integer getKCal(Page page) {
		String kcal = "";
		PageElement productKCalElem = page.select("#information table.nutritionTable");
		if(productKCalElem != null) {
			PageElement calRow = findCaloriesRowElement(productKCalElem);
			Integer index = findCaloriesColumn(productKCalElem);
			if(calRow != null && index != null)
				kcal = calRow.children().get(index).text();
		}
		return toInt(kcal);
	}

	private static PageElement findCaloriesRowElement(PageElement productKCalElem) {
		List<PageElement> rows = productKCalElem.selectAll("tr");
		PageElement row = null;
		for(int i = 0; i < rows.size(); i++) {
			PageElement el = rows.get(i).select("th");
			String headerText = el.text().trim();
			if("Energy".equalsIgnoreCase(headerText)) {
				row = el.parent().siblings().get(0);
				break;
			}
			else if("Energy kcal".equalsIgnoreCase(headerText)) {
				row = el.parent();
				break;
			}
		}
		return row;
	}

	private static Integer findCaloriesColumn(PageElement productKCalElem) {
		Integer index = null;
		List<PageElement> headers = productKCalElem.selectAll("thead tr th");
		for(int i = 1; i < headers.size(); i++) {
			String headerText = headers.get(i).text();
			if("per 100g".equalsIgnoreCase(headerText)) {
				index = i - 1;
				break;
			}
			else if("(as sold) per 100g".equalsIgnoreCase(headerText)) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static BigDecimal toDecimal(String productPrice) {

		if(productPrice != null) {
			int indexOfSign = productPrice.indexOf('£');
			String p_ = indexOfSign > -1 ? productPrice.substring(indexOfSign + 1, productPrice.length()) : productPrice;

			indexOfSign = p_.indexOf('/');
			p_ = indexOfSign > -1 ? p_.substring(0, indexOfSign) : p_;
			return new BigDecimal(p_).setScale(2, RoundingMode.HALF_UP);
		}
		return null;
	}

	private static Integer toInt(String kcal) {
		try {
			kcal = kcal.trim();
			int indexOfSign = kcal.indexOf("kcal");
			String p_ = indexOfSign > -1 ? kcal.substring(0,indexOfSign) : kcal;
			return Integer.parseInt(p_);
		}catch(Exception e) {
			return null;
		}
	}
}