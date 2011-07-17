package org.bambrikii.site.base.struts2.core;

import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.crud.BaseCrudAction;

public abstract class SiteBaseDictionaryAction<T> extends
		SiteBasePagerAction<Pager<T>> implements BaseCrudAction {
	private static final long serialVersionUID = 4821881499611591251L;
	public final String LIST_RESULT = "list";

	public abstract String list() throws Exception;
}
