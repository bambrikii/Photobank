package org.bambrikii.photobank.mailing.core.exceptions;

public class PhotobankMailingException extends Exception {
	private static final long serialVersionUID = 5057773914674897826L;

	public PhotobankMailingException(String message, Exception ex) {
		super(message, ex);
	}
}
