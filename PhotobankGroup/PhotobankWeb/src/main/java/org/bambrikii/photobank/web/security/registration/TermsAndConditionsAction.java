package org.bambrikii.photobank.web.security.registration;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TermsAndConditionsAction extends ActionSupport implements
		SessionAware {
	private static final long serialVersionUID = 7943979452814393082L;
	private Boolean acceptTermsAndConditions;
	private Map session;
	public static String REGISTRATION_TERMS_AND_CONDITIONS_STATUS = "TERMS_AND_CONDITIONS_STATUS";

	public void setAcceptTermsAndConditions(Boolean acceptTermsAndConditions) {
		this.acceptTermsAndConditions = acceptTermsAndConditions;
	}

	public Boolean getAcceptTermsAndConditions() {
		return acceptTermsAndConditions;
	}

	public void validate() {
		if (getAcceptTermsAndConditions() != null
				&& !getAcceptTermsAndConditions()) {
			addFieldError("acceptTermsAndConditions",
					getText("registration.acceptTermsAndConditions.required"));
		}
	}

	public String execute() {
		getSession().put(REGISTRATION_TERMS_AND_CONDITIONS_STATUS, true);
		return INPUT;
	}

	public String accept() {
		return "successAcceptTermsAndConditions";
	}

	public Map getSession() {
		return session;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}
}
