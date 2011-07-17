package org.bambrikii.site.base.struts2.core;

import org.bambrikii.site.base.business.pagers.Pager;

public class SiteBasePagerAction<T extends Pager<?>> extends
		SiteBaseAction {
	private static final long serialVersionUID = 4964876856515865900L;

	private Integer requestedPage;

	public Integer getRequestedPage() {
		return requestedPage == null ? 0 : requestedPage;
	}

	public void setRequestedPage(Integer requestedPage) {
		this.requestedPage = requestedPage;
	}

	private T pager;

	public T getPager() {
		return pager;
	}

	public void setPager(T pager) {
		this.pager = pager;
	}
}
