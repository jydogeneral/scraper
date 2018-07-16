package com.sainsburys.webscraper;

import java.io.IOException;
import static java.util.stream.Collectors.*;

import java.util.*;

import com.sainsburys.jsoup.webscraper.*;
import com.sainsburys.jsoup.webscraper.wrapper.URLString;
import com.sainsburys.webscraper.dom.Page;
import com.sainsburys.webscraper.model.*;

public class Client {

	private static final String URL = 
			"https://jsainsburyplc.github.io/serverside-test/site/"
					+ "www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/"
					+ "groceries/berries-cherries-currants6039.html";

	private static List<String> scrapeProductLinks(Page page){
		return page.
				selectAll(".gridItem .productNameAndPromotions a[href]").
				stream().
				map(e -> e.getAttributeValue("abs:href")).
				collect(toList());
	}
	
	private static List<Product> scrapeProductDetails(List<String> links){
		return links.stream().map(link -> {
			try {
				return Scraper.scrape(new JsoupPage(new URLString(link)));
			} catch (IOException e1) {
				return null;
			}
		} ).collect(toList());
	}
	
	public static void main(String[] args ) throws IOException{

		Page homePage = new JsoupPage(new URLString(URL));
		
		List<String> links = scrapeProductLinks(homePage);
		List<Product> results = scrapeProductDetails(links);

		Output output = new Output();
		output.setResults(results);
		System.out.println(output);
	}

}

