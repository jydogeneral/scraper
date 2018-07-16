package com.sainsburys.jsoup.webscraper;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sainsburys.jsoup.webscraper.wrapper.HTMLString;
import com.sainsburys.jsoup.webscraper.wrapper.URLString;
import com.sainsburys.webscraper.dom.Page;
import com.sainsburys.webscraper.dom.PageElement;

public class JsoupPage implements Page{

	private final Document document;

	public JsoupPage(HTMLString html){

		this.document = Jsoup.parse(html.getHtmlDocument());
	}
	
	public JsoupPage(URLString url) throws IOException{

		this.document = Jsoup.connect(url.getUrl()).get();
	}

	@Override
	public PageElement select(String cssQuery) {
		Element e = document.selectFirst(cssQuery);
		return e == null ? null : new JsoupPageElement(e);
	}

	@Override
	public List<PageElement> selectAll(String cssQuery) {
		Elements es = document.select(cssQuery); 
		return es == null ? new ArrayList<>() : es.stream().map(e -> new JsoupPageElement(e)).collect(toList());
	}

	@Override
	public String toString() {
		return document.html();
	}
	
	
}