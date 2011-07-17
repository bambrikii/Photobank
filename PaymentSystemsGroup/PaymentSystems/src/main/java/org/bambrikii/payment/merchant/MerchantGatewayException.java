package org.bambrikii.payment.merchant;

public class MerchantGatewayException extends Exception {

	private static final long serialVersionUID = -2976105291987512044L;

	public MerchantGatewayException(String message, Exception ex) {
		super(message, ex);
	}
}
