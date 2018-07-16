package com.sainsburys.webscraper.dom;

import java.util.List;

public interface Page{
	PageElement select(String cssSelector);
	List<PageElement> selectAll(String cssSelector);
}