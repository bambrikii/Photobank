package org.bambrikii.kbManager.feeds.model;

import java.util.Date;

public class FeedNews {
	private int _id;

	public int getId() {

		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	private String _title;

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _description;

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _content;

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _url;

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	private String _author;

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	private Date _pubDate;

	public Date getPubDate() {
		return _pubDate;
	}

	public void setPubDate(Date pubDate) {
		_pubDate = pubDate;
	}

	private FeedSite _site;

	public void setSite(FeedSite site) {
		_site = site;
	}

	public FeedSite getSite() {
		return _site;
	}

}
