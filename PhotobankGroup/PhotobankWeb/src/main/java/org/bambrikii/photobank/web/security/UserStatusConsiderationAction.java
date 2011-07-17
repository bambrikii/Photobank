package org.bambrikii.photobank.web.security;

import java.util.ArrayList;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

@SiteBaseSecurityAware(allowedRoles = { "root" })
public class UserStatusConsiderationAction extends
		SiteBasePagerAction<Pager<User>> {
	private static final long serialVersionUID = -9026954864913047346L;

	private User model;
	private AuthBean authBean;

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

	// Actions
	public String execute() throws Exception {
		return list();
	}

	public String list() throws Exception {
		setPager(getAuthBean().getList(new ArrayList<UserStatusEnum>() {
			private static final long serialVersionUID = 2301918215210874544L;
			{
				add(UserStatusEnum.WAITING_CONSIDERATION);
			}
		}, getRequestedPage()));
		return SUCCESS;
	}

	public String edit() throws Exception {
		if (getModel() != null && getModel().getId() != null) {
			User user = getAuthBean().getUserById(getModel().getId());
			setModel(user);
		}
		return "considerStatus";
	}

	public String approve() throws Exception {
		getAuthBean().enable(getModel().getId());
		return list();
	}

	public String reject() throws Exception {
		getAuthBean().disable(getModel().getId());
		return list();
	}
}
