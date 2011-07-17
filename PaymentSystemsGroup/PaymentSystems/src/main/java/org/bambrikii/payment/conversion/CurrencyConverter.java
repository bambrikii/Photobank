package org.bambrikii.payment.conversion;

public interface CurrencyConverter {
	Double convertTo(Double srcAmount, String dstCurrency)
			throws CurrencyConversionException;
}
