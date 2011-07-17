package org.bambrikii.payment.conversion;

public class CurrencyConversionException extends Exception {
	private static final long serialVersionUID = 2293383538831291075L;

	public CurrencyConversionException(String message) {
		super(message);
	}

	public CurrencyConversionException(String message, Exception ex) {
		super(message, ex);
	}
}
