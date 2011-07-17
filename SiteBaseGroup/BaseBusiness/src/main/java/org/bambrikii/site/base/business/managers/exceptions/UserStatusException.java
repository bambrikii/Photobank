package org.bambrikii.site.base.business.managers.exceptions;

public class UserStatusException extends AuthenticationException {
	private static final long serialVersionUID = -6567844676782563180L;

	public UserStatusException(String message) {
		super(message);
	}
}
