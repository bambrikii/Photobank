package org.bambrikii.web.site.services.dictionary;

import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;

public class DictionaryAction extends
		SiteBasePagerAction<Pager<ArtefactAsText>> {
	private static final long serialVersionUID = 7954432864375509197L;

	private DictionaryBean dictionaryBean;

	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setDictionaryBean(DictionaryBean dictionaryBean) {
		this.dictionaryBean = dictionaryBean;
	}

	public DictionaryBean getDictionaryBean() {
		return dictionaryBean;
	}

	// Actions
	public String execute() {
		return search();
	}

	public String search() {
		return SUCCESS;
	}

	public String find() throws ManagerException {
		setPager(getDictionaryBean().getPager(getText(), getRequestedPage()));
		return "list";
	}
}
