package org.bambrikii.photobank.web.core;

import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;

public abstract class AbstractFilesAction<T> extends
		SiteBasePagerAction<Pager<T>> {
	private static final long serialVersionUID = -2676948052108259869L;
	private Pager<File> filesPager;

	public Pager<File> getFilesPager() {
		return filesPager;
	}

	public void setFilesPager(Pager<File> filesPager) {
		this.filesPager = filesPager;
	}

	public abstract String files() throws Exception;
}
