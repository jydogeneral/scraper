package com.sainsburys.jsoup.webscraper;

import java.util.List;

import com.sainsburys.jsoup.webscraper.JsoupPage;
import com.sainsburys.jsoup.webscraper.wrapper.HTMLString;
import com.sainsburys.webscraper.dom.PageElement;

import junit.framework.TestCase;

public class JsoupPageElementTest extends TestCase {
	private PageElement element;
	private HTMLString htmlFragment = new HTMLString(
			  "<body>"
			+ "<div id='info'><div><a>Info Link</a></div></div>"
			+ "<div class='gridItem'><div class='productNameAndPromotions'><a>Link1</a></div></div>"
			+ "<div class='gridItem'><div class='productNameAndPromotions'><a>Link2</a></div></div>"
			+ "</body>");
	
	public void setUp() {
		element = new JsoupPage(htmlFragment).select("body");
	}
	public void testChildElements() {
		List<PageElement> children = element.children();
		assertEquals(3, children.size());
	}
	
	public void testSiblings() {
		PageElement infoDivElement = element.select("#info");
		List<PageElement> siblings = infoDivElement.siblings();
		assertEquals(2, siblings.size());
	}
	
	public void testText() {
		PageElement bodyElement = element.select("body");
		assertEquals("Info Link Link1 Link2", bodyElement.text());
	}

}
