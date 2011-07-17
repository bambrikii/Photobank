package org.bambrikii.site.base.struts2.core;

public class WebException extends Exception {
	private static final long serialVersionUID = 5156798789506076158L;

	public WebException(String message) {
		super(message);
	}

	public WebException(String message, Exception ex) {
		super(message, ex);
	}
}
