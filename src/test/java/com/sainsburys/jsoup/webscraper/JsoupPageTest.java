package com.sainsburys.jsoup.webscraper;

import com.sainsburys.jsoup.webscraper.JsoupPage;
import com.sainsburys.jsoup.webscraper.wrapper.HTMLString;
import com.sainsburys.webscraper.dom.PageElement;

import junit.framework.TestCase;

public class JsoupPageTest extends TestCase{
	
	private JsoupPage page;
	private HTMLString htmlFragment = new HTMLString(
			"<body>"
			+ "<div class='gridItem'><div class='productNameAndPromotions'><a>Link1</a></div></div>"
			+ "<div class='gridItem'><div class='productNameAndPromotions'><a>Link2</a></div></div>"
			+ "</body>");
	
	public void setUp() {
		page = new JsoupPage(htmlFragment);
	}
	
	public void testElementsSelectionUsingCSSQuery() {
		java.util.List<PageElement> links = page.selectAll(".gridItem .productNameAndPromotions");
		assertTrue(links != null);
		assertEquals(2, links.size());
		assertEquals("<a>Link1</a>",String.valueOf(links.get(0)));
		assertEquals("<a>Link2</a>",String.valueOf(links.get(1)));
	}
	
	public void testSingleElementsSelectionUsingCSSQuery() {
		PageElement firstLink = page.select(".gridItem .productNameAndPromotions");
		assertTrue(firstLink != null);
		assertEquals("<a>Link1</a>", String.valueOf(firstLink));
	}
	
	public void tearDown() {}
	
}