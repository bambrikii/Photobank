package org.bambrikii.web.site.services.dictionary;

import org.apache.commons.lang.xwork.StringUtils;
import org.bambrikii.kbManager.kb2.managers.ArtefactManager;
import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;

public class DictionaryBean extends SiteBaseBean {
	private static final int TXT_PAGER_COLS = 1;
	private static final int TXT_PAGER_ROWS = 150;

	public Pager<ArtefactAsText> getPager(String title, Integer currPage)
			throws ManagerException {
		ArtefactManager mgr = getContainerBean().getContainer().getManager(
				ArtefactManager.class);
		return mgr.getArtefacts(StringUtils.isEmpty(title) ? null : title,
				currPage, TXT_PAGER_COLS, TXT_PAGER_ROWS);
	}

	public Pager<ArtefactAsText> getLanguages(String title, Integer currPage)
			throws ManagerException {
		ArtefactManager mgr = getContainerBean().getContainer().getManager(
				ArtefactManager.class);
		return mgr.getDstArtefacts(title, "Language", currPage, TXT_PAGER_COLS,
				TXT_PAGER_ROWS);
	}
}
