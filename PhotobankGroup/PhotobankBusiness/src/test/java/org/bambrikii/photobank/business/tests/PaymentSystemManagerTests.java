package org.bambrikii.photobank.business.tests;

import junit.framework.Assert;

import org.bambrikii.photobank.business.managers.PaymentSystemManager;
import org.bambrikii.photobank.business.tests.core.ManagerTestBase;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.junit.Test;

public class PaymentSystemManagerTests extends
		ManagerTestBase<PaymentSystemManager> {
	@Test
	public void findRoboxchangeTest() {
		PaymentSystem paymentSystem = mgr.getByName("Roboxchange");
		Assert.assertTrue("Categories should exist!", paymentSystem != null);
		Assert.assertTrue("Currency should've been set!",
				paymentSystem.getCurrency() != null);
	}
}
