package org.bambrikii.photobank.web.security.registration;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.bambrikii.photobank.web.security.beans.UserActionHelper;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.springframework.beans.factory.annotation.Required;

public class RegisterAction extends SiteBaseAction {
	private static final long serialVersionUID = -53996818578644899L;

	private User model;
	private AuthBean authBean;
	private String captcha;
	private String passwordAgain;

	public void setModel(User model) {
		this.model = model;
	}

	public User getModel() {
		return model;
	}

	@Required
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public List<Language> getAvailableLanguages() throws Exception {
		return getAuthBean().getAvailableLanguages();
	}

	public static String stack2string(Exception e) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return "------\r\n" + sw.toString() + "------\r\n";
		} catch (Exception e2) {
			return "bad stack2string";
		}
	}

	// Validation
	public void validate() {
		// validating captcha
		if (getSession()
				.containsKey(
						TermsAndConditionsAction.REGISTRATION_TERMS_AND_CONDITIONS_STATUS)
				&& !(Boolean) getSession()
						.get(TermsAndConditionsAction.REGISTRATION_TERMS_AND_CONDITIONS_STATUS)) {
			addActionError("registration.acceptTermsAndConditions.required");
		}

		if (getCaptcha() == null
				|| !getCaptcha()
						.equals(getSession()
								.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY))) {
			addFieldError("captcha", getText("captcha.invalid_validation_code"));
		}
		UserActionHelper.validate(this, getModel());

		if (getModel() == null || getModel().getPassword() == null
				|| "".equals(getModel().getPassword())) {
			addFieldError("model.password", getText("profile.password.invalid"));
		}

		if (!"".equals(getModel().getPassword())
				&& !getModel().getPassword().equals(getPasswordAgain())) {
			addFieldError("passwordAgain", getText("profile.password.invalid"));
		}
	}

	// Actions
	public String execute() throws Exception {
		return INPUT;
	}

	public String apply() throws Exception {
		try {
			User user = getAuthBean().register(getModel());
			if (user != null) {
				setModel(user);
				return "successRegister";
			} else {
				return INPUT;
			}
		} catch (Exception ex) {
			addActionError(ex.getMessage() + "<br />" + stack2string(ex));
			return INPUT;
		}
	}
}
