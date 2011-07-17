package org.bambrikii.web.site.services.kb;

import org.bambrikii.site.base.struts2.core.SiteBaseAction;

public class KBParsingAction extends SiteBaseAction {
	private static final long serialVersionUID = 6683791914909309195L;

	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public String execute() {
		return SUCCESS;
	}

	public String parse() {
		return "parse";
	}

}
