package org.bambrikii.photobank.web.security;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.exceptions.AuthenticationException;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1380370295198181709L;
	private AuthBean authBean;

	private String login;

	private Map session;

	public AuthBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	private void resetSessionValue(String key, Object value) {
		if (getSession().containsKey(key)) {
			getSession().remove(key);
		}
		getSession().put(key, value);
	}

	// Actions
	public String login() throws Exception {
		try {
			User user = getAuthBean().getUser(getLogin(), getPassword());
			if (user != null) {
				resetSessionValue(AuthBean.USER_ID_KEY, user.getId());
				resetSessionValue(AuthBean.USER_ROLES_KEY, getAuthBean()
						.getUserRoles(user));
				getAuthBean().setLocale(getSession(), user);
				return "loginSuccessful";
			} else {
				addActionError(getText("login.failed"));
				return ERROR;
			}
		} catch (AuthenticationException ex) {
			addActionError(getText("login.failed") + ". " + ex.getMessage());
			return ERROR;
		}
	}

	public String privilegeRequired() {
		return SiteBaseAction.PRIVILEGE_REQUIRED;
	}

	public String logout() {
		if (session.containsKey(AuthBean.USER_ID_KEY)) {
			session.remove(AuthBean.USER_ID_KEY);
		}
		if (session.containsKey(AuthBean.USER_ROLES_KEY)) {
			session.remove(AuthBean.USER_ROLES_KEY);
		}
		return LOGIN;
	}

	public void validate() {
		if (getLogin() == null || "".equals(getLogin())) {
			addFieldError("login", getText("login.invalid"));
		}
		if (getPassword() == null || "".equals(getPassword())) {
			addFieldError("password", getText("login.password.invalid"));
		}
	}

	public String execute() throws Exception {
		if (getSession().containsKey(AuthBean.USER_ID_KEY)) {
			return "alreadyLoggedIn";
		} else {
			return LOGIN;
		}
	}
}
