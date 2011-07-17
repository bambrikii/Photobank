package org.bambrikii.site.base.business.managers.exceptions;

public class PasswordIncorrectException extends AuthenticationException {
	private static final long serialVersionUID = -5458534633562179422L;

	public PasswordIncorrectException(String message) {
		super(message);
	}

}
