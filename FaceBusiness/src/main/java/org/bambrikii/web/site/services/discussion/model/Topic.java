package org.bambrikii.web.site.services.discussion.model;

import java.util.Date;

import org.bambrikii.site.base.auth.model.User;

public class Topic {
	private Integer id;
	private String title;
	private Topic parent;
	private Date modificationTime;
	private TopicStatusEnum status;
	private User author;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Topic getParent() {
		return parent;
	}

	public void setParent(Topic parent) {
		this.parent = parent;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setStatus(TopicStatusEnum status) {
		this.status = status;
	}

	public TopicStatusEnum getStatus() {
		return status;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getAuthor() {
		return author;
	}
}
