package org.bambrikii.payment.gateway;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import org.bambrikii.payment.Payment;

public interface Gateway {
	public void checkout(Payment payment) throws MalformedURLException, UnsupportedEncodingException, IOException, Exception;

	public void cancelPayment(Payment payment) throws Exception;

	public void checkPayment(Payment payment) throws Exception;

}
