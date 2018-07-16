package com.sainsburys.jsoup.webscraper.wrapper;

public class HTMLString{
	
	private final String htmlDocument;
	
	public HTMLString(String html) {
		this.htmlDocument = html;
	}
	
	public String getHtmlDocument() {
		return this.htmlDocument;
	}
}