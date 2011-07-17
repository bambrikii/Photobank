package org.bambrikii.site.base.core.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 5373867738712189181L;

	public DAOException(String message, Exception ex) {
		super(message, ex);
	}
}
