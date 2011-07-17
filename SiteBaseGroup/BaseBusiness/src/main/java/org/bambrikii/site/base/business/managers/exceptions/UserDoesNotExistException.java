package org.bambrikii.site.base.business.managers.exceptions;

public class UserDoesNotExistException extends AuthenticationException {
	private static final long serialVersionUID = 5972880709416210315L;

	public UserDoesNotExistException(String message) {
		super(message);
	}
}
