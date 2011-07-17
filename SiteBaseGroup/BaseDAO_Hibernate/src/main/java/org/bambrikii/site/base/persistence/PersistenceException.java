package org.bambrikii.site.base.persistence;

public class PersistenceException extends Exception {
	private static final long serialVersionUID = -8764300937060764074L;

	public PersistenceException(String message){
		super(message);
	}
	
	public PersistenceException(String message, Exception ex) {
		super(message, ex);
	}

}
