package org.bambrikii.site.base.business.managers.exceptions;

public class LoginInfoRequiredException extends AuthenticationException {
	private static final long serialVersionUID = 7762657815917731970L;

	public LoginInfoRequiredException(String message) {
		super(message);
	}
}
