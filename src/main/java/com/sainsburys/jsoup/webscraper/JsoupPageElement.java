package com.sainsburys.jsoup.webscraper;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.jsoup.nodes.Element;

import com.sainsburys.webscraper.dom.PageElement;

public class JsoupPageElement implements PageElement{

	private final Element element;

	public JsoupPageElement(Element element){
		this.element = element;
	}

	@Override
	public List<PageElement> siblings() {
		return element.siblingElements().stream().map(e_ -> new JsoupPageElement(e_)).collect(toList());
	}

	@Override
	public PageElement select(String cssQuery) {
		return new JsoupPageElement(element.selectFirst(cssQuery));
	}

	@Override
	public List<PageElement> selectAll(String cssQuery) {
		return element.select(cssQuery).stream().map(e_ -> new JsoupPageElement(e_)).collect(toList());
	}

	@Override
	public List<PageElement> children() {
		return element.children().stream().map(e_ -> new JsoupPageElement(e_)).collect(toList());
	}

	@Override
	public PageElement parent() {
		return new JsoupPageElement(element.parent());
	}

	@Override
	public String text() {
		return element.text();
	}

	@Override
	public List<String> texts() {
		return element.getAllElements().eachText();
	}

	@Override
	public String getAttributeValue(String attribute) {
		return element.attr(attribute);
	}
	
	@Override
	public String toString() {
		return element.html();
	}
}