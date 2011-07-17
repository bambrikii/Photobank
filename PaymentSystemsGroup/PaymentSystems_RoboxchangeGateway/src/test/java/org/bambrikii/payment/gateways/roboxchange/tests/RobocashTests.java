package org.bambrikii.payment.gateways.roboxchange.tests;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.bambrikii.payment.gateways.roboxchange.RoboxchangeService;
import org.bambrikii.payment.gateways.roboxchange.RoboxchangeServiceException;
import org.junit.Test;

import com.roboxchange.merchant.WebService.CurrenciesList;
import com.roboxchange.merchant.WebService.Currency;
import com.roboxchange.merchant.WebService.PaymentMethodGroup;
import com.roboxchange.merchant.WebService.RatesList;
import com.roboxchange.merchant.WebService.ServiceLocator;
import com.roboxchange.merchant.WebService.ServiceSoap;

public class RobocashTests {
	public static String MERCHANT_LOGIN = "Basko";
	public static String MERCHANT_LANGUAGE = "ru";

	@Test
	public void getRatesTest() throws ServiceException, RemoteException {
		ServiceLocator sl = new ServiceLocator();
		ServiceSoap ss = sl.getServiceSoap();
		System.out.printf("	getRates\n");
		RatesList r = ss.getRates("Basko", "WMZM WMZR", new BigDecimal("1.1"),
				"ru");
		printGroups(r.getGroups());
	}

	@Test
	public void getCurrenciesTest() throws ServiceException, RemoteException {
		ServiceLocator sl = new ServiceLocator();
		ServiceSoap ss = sl.getServiceSoap();
		System.out.printf("	getCurrencies\n");
		CurrenciesList currs = ss.getCurrencies(MERCHANT_LOGIN,
				MERCHANT_LANGUAGE);
		printGroups(currs.getGroups());
	}

	private void printGroups(PaymentMethodGroup[] grps) {
		for (PaymentMethodGroup grp : grps) {
			System.out
					.printf("		%s, %s\n", grp.getCode(), grp.getDescription());
			for (Currency curr : grp.getItems()) {
				System.out.printf("			%s, %s, %s\n", curr.getName(), curr
						.getLabel(), curr.getRate() != null ? curr.getRate()
						.getIncSum() : " none");
			}
		}
	}

	@Test
	public void getRateFromServiceTest() throws ServiceException,
			RemoteException, RoboxchangeServiceException {
		RoboxchangeService s = new RoboxchangeService(MERCHANT_LOGIN);
		BigDecimal r = s
				.getRate("WMZM", new BigDecimal(1.1), MERCHANT_LANGUAGE);
		System.out.printf("	%s", r);
	}
}
