package org.bambrikii.payment.gateways.roboxchange;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.bambrikii.payment.conversion.CurrencyConversionException;
import org.bambrikii.payment.conversion.CurrencyConverter;

import com.roboxchange.merchant.WebService.RatesList;
import com.roboxchange.merchant.WebService.ServiceLocator;
import com.roboxchange.merchant.WebService.ServiceSoap;

public class RoboxchangeService implements CurrencyConverter {
	private String merchantLogin;
	private ServiceLocator serviceLocator;
	private ServiceSoap serviceSoap;

	public RoboxchangeService(String merchantLogin)
			throws RoboxchangeServiceException {
		try {
			this.merchantLogin = merchantLogin;
			serviceLocator = new ServiceLocator();
			serviceSoap = serviceLocator.getServiceSoap();
		} catch (ServiceException ex) {
			throw new RoboxchangeServiceException(
					"RoboxchangeService initialization failed", ex);
		}
	}

	public BigDecimal getRate(String incCurrLabel, BigDecimal outSum,
			String language) throws RemoteException,
			RoboxchangeServiceException {
		if (incCurrLabel == null || "".equals(incCurrLabel)) {
			throw new RoboxchangeServiceException(
					"incCurrLabel parameter required");
		}
		RatesList rl = serviceSoap.getRates(merchantLogin, incCurrLabel,
				outSum, language);
		if (rl != null && rl.getGroups() != null && rl.getGroups().length == 1
				&& rl.getGroups()[0].getItems() != null
				&& rl.getGroups()[0].getItems().length == 1) {
			return rl.getGroups()[0].getItems()[0].getRate().getIncSum();
		} else {
			throw new RoboxchangeServiceException(
					"Incorrect records count to be returned");
		}
	}

	@Override
	public Double convertTo(Double srcAmount, String dstCurrency)
			throws CurrencyConversionException {
		try {
			return new Double(getRate(dstCurrency, new BigDecimal(srcAmount),
					null).toString());
		} catch (Exception ex) {
			throw new CurrencyConversionException("Currency conversion failed");
		}
	}
}
