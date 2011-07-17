package org.bambrikii.kbManager.kb2.model;

import java.util.Date;

public class ArtefactAsText extends Artefact {
	private String title;
	private Date publicationTime;
	private String text;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPublicationTime(Date publicationTime) {
		this.publicationTime = publicationTime;
	}

	public Date getPublicationTime() {
		return publicationTime;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
