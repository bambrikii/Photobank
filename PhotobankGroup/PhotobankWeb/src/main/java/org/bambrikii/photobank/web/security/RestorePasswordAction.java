package org.bambrikii.photobank.web.security;

import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

public class RestorePasswordAction extends SiteBaseAction {
	private static final long serialVersionUID = -4146037299889659642L;

	private AuthBean authBean;

	private String login;
	private String email;
	private String captcha;

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	// Validate
	public void validate() {
		if (getLogin() == null || "".equals(getLogin())) {
			addFieldError("login",
					getText("passwordRestoration.login.required"));
		}
		if (getEmail() == null || "".equals(getEmail())) {
			addFieldError("email",
					getText("passwordRestoration.email.required"));
		}
		if (getCaptcha() == null
				|| !getCaptcha()
						.equals(getSession()
								.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY))) {
			addFieldError("captcha", getText("captcha.invalid_validation_code"));
		}
	}

	// Actions
	public String execute() {
		return SUCCESS;
	}

	public String restore() throws Exception {
		try {
			getAuthBean().restorePassword(getLogin(), getEmail());
		} catch (WebException ex) {
			addActionError(ex.getLocalizedMessage());
			return INPUT;
		}
		return "restore";
	}

}
