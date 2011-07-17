package org.bambrikii.site.base.struts2.core;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class SiteBaseAction extends ActionSupport implements
		SessionAware {
	private static final long serialVersionUID = 8045613394912594718L;

	public static final String PRIVILEGE_REQUIRED = "privilegeRequired";

	private Map<?, ?> session;

	@SuppressWarnings("rawtypes")
	public void setSession(Map session) {
		this.session = session;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession() {
		return session;
	}
}
