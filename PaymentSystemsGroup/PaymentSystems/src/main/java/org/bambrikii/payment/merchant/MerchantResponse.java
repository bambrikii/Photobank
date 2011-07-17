package org.bambrikii.payment.merchant;

import org.bambrikii.payment.Payment;

public class MerchantResponse extends Payment {
	private String _signatureValue;

	public String getSignatureValue() {
		return _signatureValue;
	}

	public void setSignatureValue(String signatureValue) {
		_signatureValue = signatureValue;
	}
}
