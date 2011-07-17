package org.bambrikii.web.site.services.kb;

import java.util.ArrayList;
import java.util.List;

import org.bambrikii.site.base.struts2.core.SiteBaseAction;

public class KBAction extends SiteBaseAction {
	private static final long serialVersionUID = -1113396976916514577L;
	private String text;

	private List<?> foundItems = new ArrayList<Object>();

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setFoundItems(List<?> foundItems) {
		this.foundItems = foundItems;
	}

	public List<?> getFoundItems() {
		return foundItems;
	}

	public String execute() {
		return SUCCESS;
	}

	public String find() {
		return "find";
	}
}
