package org.bambrikii.site.base.business.managers.exceptions;

import org.bambrikii.site.base.business.managers.core.ManagerException;

public class AuthenticationException extends ManagerException {
	private static final long serialVersionUID = -5269106400459342177L;

	public AuthenticationException(String message) {
		super(message);
	}

	public AuthenticationException(String message, Exception ex) {
		super(message, ex);
	}

}
