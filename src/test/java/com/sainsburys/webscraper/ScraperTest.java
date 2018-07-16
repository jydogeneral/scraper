package com.sainsburys.webscraper;

import java.math.BigDecimal;

import com.sainsburys.jsoup.webscraper.JsoupPage;
import com.sainsburys.jsoup.webscraper.wrapper.HTMLString;
import com.sainsburys.webscraper.dom.Page;
import com.sainsburys.webscraper.model.Product;

import junit.framework.TestCase;

public class ScraperTest extends TestCase {
	
	public void testScrapeProduct() {
		Product result = new Product("Sainsbury's Strawberries 400g", 33, new BigDecimal("1.75"), "by Sainsbury's strawberries");
		Page page = new JsoupPage(new HTMLString(PAGE));
		assertEquals(result, Scraper.scrape(page ));
	}

	public static final String PAGE = "<html>\n" + 
			"<head>\n" + 
			"<title>Sainsbury&#039;s Strawberries 400g | Sainsbury&#039;s</title>\n" + 
			"</head>\n" + 
			"<body id='productDetails'>\n" + 
			"<div id='page'>\n" + 
			"<div id='main'>\n" + 
			"<div class='article' id='content'>\n" + 
			"<div class='section productContent'>\n" + 
			"<div class='pdp'>\n" + 
			"<div class='productSummary'>\n" + 
			"<div class=\"pricing\">\n" + 
			"<p class=\"pricePerUnit\">\n" + 
			"£1.75<abbr title=\"per\">/</abbr><abbr title=\"unit\"><span\n" + 
			"	class=\"pricePerUnitUnit\">unit</span></abbr>\n" + 
			"</p>\n" + 
			"<p class=\"pricePerMeasure\">\n" + 
			"£4.38<abbr title=\"per\">/</abbr><abbr title=\"kilogram\"><span\n" + 
			"	class=\"pricePerMeasureMeasure\">kg</span></abbr>\n" + 
			"</p>\n" + 
			"</div>\n" + 
			"<div class='productTitleDescriptionContainer'>\n" + 
			"<h1>Sainsbury's Strawberries 400g</h1></div></div></div>\n" + 
			"<div class='mainProductInfoWrapper'>\n" + 
			"<div class='mainProductInfo'>		\n" + 
			"<div class='tabs'>\n" + 
			"<div class='section' id='information'>\n" + 
			"<h2 class='access'>Information</h2>\n" + 
			"<ProductContent>\n" + 
			"<HTMLContent>\n" + 
			"<h3 class='productDataItemHeader'>Description</h3>\n" + 
			"<div class='productText'><p>by Sainsbury's strawberries</p><p><p></p></p></div>\n" + 
			"<h3 class='productDataItemHeader'>Nutrition</h3>\n" + 
			"<div class='productText'><div><p><strong>Table of Nutritional Information</strong></p>\n" + 
			"<div class='tableWrapper'>\n" + 
			"<table class='nutritionTable'>\n" + 
			"<thead>\n" + 
			"<tr class='tableTitleRow'>\n" + 
			"	<th scope='col'>Typical Values</th>\n" + 
			"	<th scope='col'>Per 100g&nbsp;</th>\n" + 
			"	<th scope='col'>% based on RI for Average Adult</th>\n" + 
			"</tr>\n" + 
			"</thead>\n" + 
			"<tr class='tableRow1'>\n" + 
			"	<th scope='row' class='rowHeader' rowspan='2'>Energy</th>\n" + 
			"	<td class='tableRow1'>140kJ</td>\n" + 
			"	<td class='tableRow1'>-</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow0'>\n" + 
			"	<td class='nutritionLevel1'>33kcal</td>\n" + 
			"	<td class='nutritionLevel1'>2%</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow1'>\n" + 
			"	<th scope='row' class='rowHeader'>Fat</th>\n" + 
			"	<td class='nutritionLevel1'>&lt;0.5g</td>\n" + 
			"	<td class='nutritionLevel1'>-</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow0'>\n" + 
			"	<th scope='row' class='rowHeader'>Saturates</th>\n" + 
			"	<td class='nutritionLevel1'>&lt;0.1g</td>\n" + 
			"	<td class='nutritionLevel1'>-</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow1'>\n" + 
			"	<th scope='row' class='rowHeader'>Carbohydrate</th>\n" + 
			"	<td class='tableRow1'>6.1g</td>\n" + 
			"	<td class='tableRow1'>2%</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow0'>\n" + 
			"	<th scope='row' class='rowHeader'>Total Sugars</th>\n" + 
			"	<td class='nutritionLevel2'>6.1g</td>\n" + 
			"	<td class='nutritionLevel2'>7%</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow1'>\n" + 
			"	<th scope='row' class='rowHeader'>Fibre</th>\n" + 
			"	<td class='tableRow1'>1.0g</td>\n" + 
			"	<td class='tableRow1'>-</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow0'>\n" + 
			"	<th scope='row' class='rowHeader'>Protein</th>\n" + 
			"	<td class='tableRow0'>0.6g</td>\n" + 
			"	<td class='tableRow0'>1%</td>\n" + 
			"</tr>\n" + 
			"<tr class='tableRow1'>\n" + 
			"	<th scope='row' class='rowHeader'>Salt</th>\n" + 
			"	<td class='nutritionLevel1'>&lt;0.01g</td>\n" + 
			"	<td class='nutritionLevel1'>-</td>\n" + 
			"</tr>\n" + 
			"</table>\n" + 
			"</div></div></div></HTMLContent> </ProductContent></div></div></div></div></div></div></div></div>\n" + 
			"</body>\n" + 
			"</html>";
}
