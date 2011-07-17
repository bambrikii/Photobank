package org.bambrikii.photobank.web.info;

import com.opensymphony.xwork2.ActionSupport;

public class InfoAction extends ActionSupport {
	private static final long serialVersionUID = -8797938392508047007L;
	private String key;

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public String execute() {
		return SUCCESS;
	}
}
