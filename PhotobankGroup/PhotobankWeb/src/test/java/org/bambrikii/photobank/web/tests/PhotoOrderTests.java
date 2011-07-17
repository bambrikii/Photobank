package org.bambrikii.photobank.web.tests;

import junit.framework.Assert;

import org.bambrikii.photobank.business.managers.PhotoOrderManager;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.Test;

public class PhotoOrderTests {
	@Test
	public void test1() throws ManagerException{
		ManagerContainer container	= new ManagerContainer();
		container.open();
		PhotoOrderManager phom	= (PhotoOrderManager) container.getManager(PhotoOrderManager.class);
		PhotoOrderItem item	= phom.getItemById(682);
		container.close();
		Assert.assertNotNull(item);
	}
}
