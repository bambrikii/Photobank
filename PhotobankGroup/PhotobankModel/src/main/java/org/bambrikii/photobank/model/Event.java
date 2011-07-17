package org.bambrikii.photobank.model;

import java.util.Date;

public class Event extends Category {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private Date insertionTime;

	public Date getInsertionTime() {
		return insertionTime;
	}

	public void setInsertionTime(Date insertionTime) {
		this.insertionTime = insertionTime;
	}

	private Date modificationTime;

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
}
