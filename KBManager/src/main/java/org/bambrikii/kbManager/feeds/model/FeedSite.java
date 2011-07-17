package org.bambrikii.kbManager.feeds.model;

import java.util.List;

public class FeedSite {
	private int _id;

	public int getId() {

		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	private String _name;

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _url;

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private List<FeedNews> _news;

	public List<FeedNews> getNews() {
		return _news;
	}

	public void setNews(List<FeedNews> news) {
		_news = news;
	}
}
