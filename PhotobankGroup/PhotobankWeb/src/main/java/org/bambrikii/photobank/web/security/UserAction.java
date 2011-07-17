package org.bambrikii.photobank.web.security;

import java.util.Arrays;
import java.util.List;

import org.bambrikii.photobank.web.security.beans.UserActionHelper;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.struts2.core.SiteBaseDictionaryAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

@SiteBaseSecurityAware(allowedRoles = { "root" })
public class UserAction extends SiteBaseDictionaryAction<User> {
	private static final long serialVersionUID = -9133474887334892171L;

	private User model;

	private AuthBean authBean;

	public void setAuthBean(AuthBean authBean) {
		this.authBean = authBean;
	}

	public AuthBean getAuthBean() {
		return authBean;
	}

	public User getModel() {
		return model;
	}

	public void setModel(User model) {
		this.model = model;
	}

	public List<Language> getAvailableLanguages() throws Exception {
		return getAuthBean().getAvailableLanguages();
	}

	public List<UserStatusEnum> getUserStatusList() {
		return Arrays.asList(UserStatusEnum.values());
	}

	// Actions

	@Override
	public String save() throws Exception {
		User user;
		if (getModel() != null && getModel().getId() != null) {
			user = getAuthBean().getUserById(getModel().getId());
		} else {
			user = new User();
		}
		UserActionHelper.copyData(getAuthBean(), getModel(), user);
		user.setLogin(getModel().getLogin());
		user.setStatus(getModel().getStatus());
		getAuthBean().saveOrUpdate(user);
		setModel(user);
		return list();
	}

	@Override
	public String delete() throws Exception {
		User user = getAuthBean().getUserById(getModel().getId());
		getAuthBean().delete(user);
		return list();
	}

	public String execute() throws Exception {
		return list();
	}

	@Override
	public String list() throws Exception {
		Pager<User> pgr = getAuthBean().getUsers(getRequestedPage());
		setPager(pgr);
		return LIST_RESULT;
	}

	@Override
	public String edit() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			User user = getAuthBean().getUserById(getModel().getId());
			setModel(user);
		}
		return EDIT_RESULT;
	}

	public void validate() {
		// UserActionHelper.validate(this, getModel());
	}
}
