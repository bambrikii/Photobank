package org.bambrikii.site.base.struts2.core.beans;

import org.bambrikii.site.base.business.managers.ManagerContainer;

public class ManagerContainerBean {
	private ManagerContainer container;

	public ManagerContainerBean() {
		container = new ManagerContainer();
		container.open();
	}

	public ManagerContainer getContainer() {
		return container;
	}

	public void destroy() {
		container.close();
		container = null;
	}
}
