package org.bambrikii.kbManager.parser.model;

public class Knowledge {
	private int id;
	private Knowledge subject;
	private Knowledge object;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setSubject(Knowledge subject) {
		this.subject = subject;
	}

	public Knowledge getSubject() {
		return subject;
	}

	public void setObject(Knowledge object) {
		this.object = object;
	}

	public Knowledge getObject() {
		return object;
	}
}
