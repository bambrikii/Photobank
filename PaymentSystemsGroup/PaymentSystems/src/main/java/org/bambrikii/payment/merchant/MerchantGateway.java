package org.bambrikii.payment.merchant;

import org.bambrikii.payment.Payment;

public interface MerchantGateway {
	public String getRedirectToPaymentUrl(Payment payment)
			throws MerchantGatewayException;

	public MerchantResponseResult checkResult(MerchantResponse response)
			throws MerchantGatewayException;
}
