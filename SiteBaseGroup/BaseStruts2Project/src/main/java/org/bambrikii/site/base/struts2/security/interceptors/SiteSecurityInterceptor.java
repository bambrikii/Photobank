package org.bambrikii.site.base.struts2.security.interceptors;

import java.util.List;
import java.util.Map;

import org.bambrikii.site.base.struts2.core.SiteBaseAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SiteSecurityInterceptor implements Interceptor {
	private static final long serialVersionUID = 4838630162186639921L;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Action action = (Action) invocation.getAction();

		SiteBaseSecurityAware securityAwareMethod = action.getClass()
				.getMethod(invocation.getProxy().getMethod())
				.getAnnotation(SiteBaseSecurityAware.class);

		if (securityAwareMethod != null) {
			switch (getRequiredSecurityAction(securityAwareMethod, invocation
					.getInvocationContext().getSession())) {
			case LOGIN:
				return Action.LOGIN;
			case PRIVILEGE_REQUIRED:
				return SiteBaseAction.PRIVILEGE_REQUIRED;
			case INVOKE:
			default:
				return invocation.invoke();
			}
		}

		SiteBaseSecurityAware securityAwareClass = action.getClass()
				.getAnnotation(SiteBaseSecurityAware.class);

		getRequiredSecurityAction(securityAwareClass, invocation
				.getInvocationContext().getSession());

		if (securityAwareClass != null) {
			switch (getRequiredSecurityAction(securityAwareClass, invocation
					.getInvocationContext().getSession())) {
			case LOGIN:
				return Action.LOGIN;
			case PRIVILEGE_REQUIRED:
				return SiteBaseAction.PRIVILEGE_REQUIRED;
			case INVOKE:
			default:
				return invocation.invoke();
			}
		}
		return invocation.invoke();
	}

	private SecurityResult getRequiredSecurityAction(
			SiteBaseSecurityAware securityAware, Map<String, Object> session) {
		if (securityAware != null) {
			if (session.containsKey(AuthBean.USER_ID_KEY)) {
				if (securityAware.allowedRoles().length > 0
						&& session.containsKey(AuthBean.USER_ROLES_KEY)) {
					List<String> userRoles = (List<String>) session
							.get(AuthBean.USER_ROLES_KEY);
					if (userRoles.size() > 0) {
						for (String allowedRole : securityAware.allowedRoles()) {
							if (userRoles.contains(allowedRole)) {
								return SecurityResult.INVOKE;
							}
						}
						return SecurityResult.PRIVILEGE_REQUIRED;
					}
				}
				return SecurityResult.INVOKE;
			}
			return SecurityResult.LOGIN;
		}
		return SecurityResult.INVOKE;
	}

	private enum SecurityResult {
		PRIVILEGE_REQUIRED, INVOKE, LOGIN
	}
}
