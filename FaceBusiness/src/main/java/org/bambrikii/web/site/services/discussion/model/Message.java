package org.bambrikii.web.site.services.discussion.model;

import java.util.Date;

import org.bambrikii.site.base.auth.model.User;

public class Message {
	private Integer id;
	private String title;
	private String text;
	private MessageStatusEnum status;
	private User author;
	private Topic topic;
	private Date modificationTime;
	private Message parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageStatusEnum getStatus() {
		return status;
	}

	public void setStatus(MessageStatusEnum status) {
		this.status = status;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getAuthor() {
		return author;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setParent(Message parent) {
		this.parent = parent;
	}

	public Message getParent() {
		return parent;
	}
}
