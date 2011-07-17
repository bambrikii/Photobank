package org.bambrikii.site.base.struts2.core;

import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.struts2.core.beans.ManagerContainerBean;

public abstract class SiteBaseBean {

	private ManagerContainerBean containerBean;

	public ManagerContainer getContainer() {
		return getContainerBean().getContainer();
	}

	public void setContainerBean(ManagerContainerBean mgrContainerBean) {
		this.containerBean = mgrContainerBean;
	}

	public ManagerContainerBean getContainerBean() {
		return containerBean;
	}
}
