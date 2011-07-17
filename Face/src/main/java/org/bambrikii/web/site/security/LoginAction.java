package org.bambrikii.web.site.security;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

public class LoginAction extends SiteBaseAction implements SessionAware {
	private static final long serialVersionUID = -5676640940437924258L;
	private Map<?, ?> session;
	private String username;
	private String password;

	private SecurityBean securityBean;

	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}

	public void setSecurityBean(SecurityBean securityBean) {
		this.securityBean = securityBean;
	}

	public SecurityBean getSecurityBean() {
		return securityBean;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public synchronized String login() throws Exception {
		// TODO:
		// 1. check user
		// 2. set session values
		User user;
		;
		try {
			user = getSecurityBean().getUser(getUsername(), getPassword());
			if (user == null) {
				throw new Exception("User does not exist");
			}
			getSession().put(AuthBean.USER_ID_KEY, user.getId());
			getSession().put(AuthBean.USER_ROLES_KEY,
					getSecurityBean().getUserRoles(user));
			return "loggedin";
		} catch (Exception ex) {
			this.addActionError(ex.getLocalizedMessage());
			return ERROR;
		}
		// return SUCCESS;
	}

	public synchronized String logout() {
		if (session.containsKey(AuthBean.USER_ID_KEY)) {
			session.remove(AuthBean.USER_ID_KEY);
		}
		if (session.containsKey(AuthBean.USER_ROLES_KEY)) {
			session.remove(AuthBean.USER_ROLES_KEY);
		}
		return SUCCESS;
	}
}
