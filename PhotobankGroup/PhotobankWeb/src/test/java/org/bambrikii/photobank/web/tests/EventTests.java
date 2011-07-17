package org.bambrikii.photobank.web.tests;

import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.web.events.beans.EventBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.core.beans.ManagerContainerBean;
import org.junit.Test;

public class EventTests {

	@Test
	public void listEventFilesTest() throws WebException, ManagerException {
		Integer id = 41527;
		EventBean eventBean = new EventBean();
		eventBean.setContainerBean(new ManagerContainerBean());
		Event event = eventBean.getById(id);
		List<File> files = eventBean.getFiles(event);
		Assert.assertTrue(files.size() > 0);
	}
}
