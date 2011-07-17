package org.bambrikii.photobank.web.security;

import java.util.List;

import org.bambrikii.photobank.web.security.beans.UserActionHelper;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.springframework.beans.factory.annotation.Required;

@SiteBaseSecurityAware
public class ProfileAction extends SiteBaseAction {
	private static final long serialVersionUID = 3426775292590359365L;
	private AuthBean authBean;

	private User model;
	private String passwordAgain;

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

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

	public List<Language> getAvailableLanguages() throws Exception {
		return getAuthBean().getAvailableLanguages();
	}

	// Actions
	public String register() {
		return SUCCESS;

	}

	public String update() throws Exception {
		User user = getAuthBean().getUserById(
				(Integer) getSession().get(AuthBean.USER_ID_KEY));
		UserActionHelper.copyData(authBean, getModel(), user);
		getAuthBean().saveOrUpdate(user);
		getAuthBean().setLocale(getSession(), user);
		return SUCCESS;
	}

	public String execute() throws Exception {
		if (getSession().containsKey(AuthBean.USER_ID_KEY)) {
			try {
				Integer id = (Integer) getSession().get(AuthBean.USER_ID_KEY);
				User user = getAuthBean().getUserById(id);
				setModel(user);
				return SUCCESS;
			} catch (Exception ex) {
				return ERROR;
			}
		}
		return ERROR;
	}

	public void validate() {
		if (!getSession().containsKey(AuthBean.USER_ID_KEY)) {
			addFieldError("login", "profile.login.user_id_required");
		}
		UserActionHelper.validate(this, getModel());
		if (!(getModel().getPassword() == null
				|| "".equals(getModel().getPassword()) || getModel()
				.getPassword().equals(getPasswordAgain()))) {
			addFieldError("passwordAgain", getText("profile.password.invalid"));
		}

	}
}
