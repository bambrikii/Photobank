package org.bambrikii.photobank.news.model;

import org.bambrikii.site.base.model.Language;

public class NewsLocalized {
	private Integer id;
	private String title;
	private String content;

	// private News news;
	// private Language language;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
	/*
	 * public void setNews(News news) { this.news = news; }
	 *
	 * public News getNews() { return news; }
	 *
	 * public void setLanguage(Language language) { this.language = language; }
	 *
	 * public Language getLanguage() { return language; }
	 */
}
