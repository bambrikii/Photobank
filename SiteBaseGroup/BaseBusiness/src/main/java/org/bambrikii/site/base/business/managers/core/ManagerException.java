package org.bambrikii.site.base.business.managers.core;

public class ManagerException extends Exception {

	private static final long serialVersionUID = -1792330815031360660L;

	public ManagerException(String message, Exception ex) {
		super(message, ex);
	}

	public ManagerException(String message) {
		super(message);
	}
}
