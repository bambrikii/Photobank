package org.bambrikii.site.base.struts2.security.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.UserManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.model.Phone;
import org.bambrikii.site.base.model.PhoneTypeEnum;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.core.WebException;
import org.bambrikii.site.base.struts2.mailing.beans.MailingBean;

import com.opensymphony.xwork2.interceptor.I18nInterceptor;

public class AuthBean extends SiteBaseBean {
	public static final String USER_ID_KEY = "userId";
	public static final String USER_ROLES_KEY = "userRoles";
	public static final String EMAIL_VALIDATION_PATTERN = ".*@([\\w\\d-]+\\.){1,}\\w+";

	private MailingBean mailingBean;

	private String informUserStatusTemplateKey;
	private String restoreUserPasswordTemplateKey;

	public void setMailingBean(MailingBean mailingBean) {
		this.mailingBean = mailingBean;
	}

	public MailingBean getMailingBean() {
		return mailingBean;
	}

	/*
	 * Property required for email templates handling!
	 */
	public void setRestoreUserPasswordTemplateKey(
			String restoreUserPasswordTemplateKey) {
		this.restoreUserPasswordTemplateKey = restoreUserPasswordTemplateKey;
	}

	public String getRestoreUserPasswordTemplateKey() {
		return restoreUserPasswordTemplateKey;
	}

	/*
	 * Property required for email templates handling!
	 */
	public void setInformUserStatusTemplateKey(
			String informUserStatusTemplateKey) {
		this.informUserStatusTemplateKey = informUserStatusTemplateKey;
	}

	public String getInformUserStatusTemplateKey() {
		return informUserStatusTemplateKey;
	}

	public User getUserById(Integer id) throws Exception {
		try {
			UserManager mgr = (UserManager) getContainer().getManager(
					UserManager.class);
			User user = mgr.getById(id);
			return user;
		} catch (Exception ex2) {
			throw ex2;
		}
	}

	public User getUser(String login, String password) throws Exception {
		try {
			UserManager mgr = (UserManager) getContainer().getManager(
					UserManager.class);
			User user = mgr.login(login, password);
			return user;
		} catch (Exception ex2) {
			throw ex2;
		}
	}

	public void setUserPhone(User user, String phoneNumber) {
		if (user.getPhones() == null) {
			user.setPhones(new ArrayList<Phone>());
		}
		Phone foundPhone = null;
		for (Phone phone : user.getPhones()) {
			if (phone.getNumber() == phoneNumber
					|| phone.getType() == PhoneTypeEnum.MAIN) {
				foundPhone = phone;
				break;
			}
		}
		if (foundPhone == null) {
			foundPhone = new Phone();
			foundPhone.setNumber(phoneNumber);
			foundPhone.setType(PhoneTypeEnum.MAIN);
			foundPhone.setUser(user);
			user.getPhones().add(foundPhone);
		} else {
			foundPhone.setNumber(phoneNumber);
			foundPhone.setType(PhoneTypeEnum.MAIN);
		}
	}

	public void saveOrUpdate(User user) throws Exception {
		try {
			UserManager mgr = (UserManager) getContainer().getManager(
					UserManager.class);
			getContainer().begin();
			try {
				if (user.getPhones() != null) {
					for (Phone phone : user.getPhones()) {
						mgr.saveOrUpdatePhone(phone);
					}
				}
				mgr.saveOrUpdate(user);
				getContainer().commit();

			} catch (Exception ex) {
				getContainer().rollback();
				throw ex;
			}
		} catch (Exception ex2) {
			throw ex2;
		}
	}

	public List<String> getUserRoles(User user) throws Exception {
		try {
			UserManager mgr = (UserManager) getContainer().getManager(
					UserManager.class);
			List<String> privs = mgr.getUserRoles(user);
			return privs;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public User register(User user) throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		User user2 = mgr.getUserByLogin(user.getLogin());
		if (user2 != null) {
			throw new ManagerException("User already exists");
		}
		user.setStatus(UserStatusEnum.WAITING_CONSIDERATION);
		saveOrUpdate(user);
		return user;
	}

	public List<Language> getAvailableLanguages() throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		return mgr.getLanguages(true);
	}

	public Language getLanguageById(Integer id) throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		return mgr.getLanguageById(id);
	}

	public Pager<User> getUsers(Integer currPage) throws ManagerException {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		return mgr.getUsersPager("status DESC, login", currPage);
	}

	public void delete(User user) throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		getContainer().begin();
		try {
			mgr.delete(user);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw new Exception("Failed to delete", ex);
		}
	}

	public void setLocale(Map session, User user) {
		if (user.getLanguage() != null
				&& user.getLanguage().getLocale() != null) {
			Locale locale = new Locale(user.getLanguage().getLocale());
			if (session.containsKey(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE)) {
				session.remove(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE);
			}
			session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
		}
	}

	public static String getStackTrace(Throwable aThrowable) {
		final java.io.Writer result = new java.io.StringWriter();
		final java.io.PrintWriter printWriter = new java.io.PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}

	public Pager<User> getList(List<UserStatusEnum> statuses,
			Integer currentPage) throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		return mgr.getUsersPager(statuses, "login", currentPage);
	}

	private void updateUserStatusAndInform(Integer userId,
			UserStatusEnum newStatus) throws Exception {
		UserManager mgr = (UserManager) getContainer().getManager(
				UserManager.class);
		ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);

		final User user = mgr.getById(userId);

		getMailingBean().email(
				cfgMgr.getCacheConfigValue(getInformUserStatusTemplateKey())
						+ newStatus.toString(),
				getMailingBean().getLocale(user), user.getEmail(),
				new HashMap<String, Object>() {
					private static final long serialVersionUID = 1L;
					{
						put("firstname",
								!(user.getFirstname() == null || "".equals(user
										.getFirstname())) ? user.getFirstname()
										: user.getLogin());
						put("surname", user.getSurname());

					}
				});

		getContainer().begin();
		try {
			user.setStatus(newStatus);
			mgr.saveOrUpdate(user);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void enable(Integer id) throws Exception {
		updateUserStatusAndInform(id, UserStatusEnum.ENABLED);
	}

	public void disable(Integer id) throws Exception {
		updateUserStatusAndInform(id, UserStatusEnum.DISABLED);
	}

	public void restorePassword(String login, String email) throws Exception {
		UserManager userMgr = (UserManager) getContainer().getManager(
				UserManager.class);
		final User user = userMgr.getUserByLogin(login);
		if (user == null) {
			throw new WebException("User does not exist");
		}
		if (email.equals(user.getEmail())) {
			final String newPassword = UUID.randomUUID().toString();
			getContainer().begin();
			try {
				user.setPassword(newPassword);
				userMgr.saveOrUpdate(user);
				getContainer().commit();
			} catch (Exception ex) {
				getContainer().rollback();
				throw new WebException("Failed to update password");
			}

			ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
					.getManager(ConfigurationManager.class);
			getMailingBean()
					.email(cfgMgr
							.getCacheConfigValue(getRestoreUserPasswordTemplateKey()),
							getMailingBean().getLocale(user), user.getEmail(),
							new HashMap<String, Object>() {
								private static final long serialVersionUID = 1L;
								{
									put("firstname",
											!(user.getFirstname() == null || ""
													.equals(user.getFirstname())) ? user
													.getFirstname() : user
													.getLogin());
									put("surname", user.getSurname());
									put("newpassword", newPassword);

								}
							});
		} else {
			throw new WebException("Email is not from your profile");
		}

	}
}
