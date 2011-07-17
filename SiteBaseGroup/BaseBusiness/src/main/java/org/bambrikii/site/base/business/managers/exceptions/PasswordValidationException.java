package org.bambrikii.site.base.business.managers.exceptions;

public class PasswordValidationException extends AuthenticationException {
	private static final long serialVersionUID = 8397237497055578342L;

	public PasswordValidationException(String message, Exception ex) {
		super(message, ex);
	}
}
