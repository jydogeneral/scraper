package com.sainsburys.webscraper.dom;

import java.util.List;

public interface PageElement{
	List<PageElement> siblings();
	List<PageElement> children();
	PageElement parent();
	PageElement select(String cssQuery);
	List<PageElement> selectAll(String cssQuery);
	String text();
	List<String> texts();
	String getAttributeValue(String attribute);
}