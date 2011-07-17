package org.bambrikii.payment.gateways.roboxchange;

import javax.xml.rpc.ServiceException;

public class RoboxchangeServiceException extends Exception {
	private static final long serialVersionUID = 9208486007268293901L;

	public RoboxchangeServiceException(String message) {
		super(message);
	}

	public RoboxchangeServiceException(String message, ServiceException ex) {
		super(message, ex);
	}
}
