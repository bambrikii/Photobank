package org.bambrikii.photobank.news.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class News {
	private Integer id;
	private String title;
	private String content;
	private Date time;
	private Date modificationTime;
	private NewsStatusEnum status;
	private Map<Integer, NewsLocalized> localizations = new HashMap<Integer, NewsLocalized>();

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String string) {
		this.title = string;
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

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setStatus(NewsStatusEnum status) {
		this.status = status;
	}

	public NewsStatusEnum getStatus() {
		return status;
	}

	public void setLocalizations(Map<Integer, NewsLocalized> localizations) {
		this.localizations = localizations;
	}

	public Map<Integer, NewsLocalized> getLocalizations() {
		return localizations;
	}
}
