package org.bambrikii.site.base.model.payment.tests;

import junit.framework.Assert;

import org.bambrikii.site.base.payment.dao.PaymentSystemDAO;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.payment.model.PaymentSystemStatusEnum;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Test;

public class PaymentSystemTests extends DAOTestBase<PaymentSystemDAO> {
	private static String ROBOXCHANGE_NAME = "Roboxchange";
	private static String ROBOXCHANGE_CHECKOUT_URL = "https://merchant.roboxchange.com/Index.aspx";

	@Test
	public void RoboxchangeTest() {
		PaymentSystem ps = dao.getByName(ROBOXCHANGE_NAME);
		if (ps == null) {
			ps = new PaymentSystem();
			ps.setName(ROBOXCHANGE_NAME);
			ps.setCheckoutUrl(ROBOXCHANGE_CHECKOUT_URL);
			ps.setDefaultMerchantLogin(ROBOXCHANGE_NAME);
			ps.setStatus(PaymentSystemStatusEnum.ENABLED);
			dao.saveOrUpdate(ps);
		} else {
			Assert.assertEquals("Roboxchange checkoutUrl param not valid.",
					ROBOXCHANGE_CHECKOUT_URL, ps.getCheckoutUrl());
		}
	}
}
