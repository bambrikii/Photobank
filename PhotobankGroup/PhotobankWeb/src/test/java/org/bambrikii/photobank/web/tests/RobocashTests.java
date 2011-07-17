package org.bambrikii.photobank.web.tests;

import org.bambrikii.photobank.web.payment.beans.RobocashBean;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.Test;

public class RobocashTests {
	public static String ROBOCASSA_URL = "";

	@Test
	public void loadCurrenciesTest() throws ManagerException {
		ManagerContainer container = new ManagerContainer();
		container.open();
		ConfigurationManager configMgr = (ConfigurationManager) container
				.getManager(ConfigurationManager.class);
		String url = configMgr
				.getCacheConfigValue(RobocashBean.CONFIG_PARAM__SERVICE_URL);
		System.out.printf("%s\n", url);

		String rateServiceUrl = "http://test.robokassa.ru/Xml/Rate.ashx";
		container.close();
	}
}
