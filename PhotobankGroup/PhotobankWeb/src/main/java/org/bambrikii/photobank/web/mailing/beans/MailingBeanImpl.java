package org.bambrikii.photobank.web.mailing.beans;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.bambrikii.photobank.business.managers.TemplateManager;
import org.bambrikii.photobank.mailing.core.managers.MailManager;
import org.bambrikii.photobank.mailing.model.Template;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.mailing.beans.MailingBean;

public class MailingBeanImpl extends SiteBaseBean implements MailingBean {
	private static final String SERVICE_EMAIL_FROM = ".ru.psfotos.mailing.service.from";
	private static final String SERVICE_EMAIL_HOST = ".ru.psfotos.mailing.service.mailHost";
	private static final String SERVICE_LOGIN_USERNAME = ".ru.psfotos.mailing.service.auth.username";
	private static final String SERVICE_LOGIN_PASSWORD = ".ru.psfotos.mailing.service.auth.password";

	private static MailManager mailMgr;

	protected MailManager getMailManager() throws ManagerException {
		if (mailMgr == null) {
			ConfigurationManager cfgMgr = (ConfigurationManager) getContainer()
					.getManager(ConfigurationManager.class);

			org.bambrikii.photobank.mailing.core.model.Configuration cfg = new org.bambrikii.photobank.mailing.core.model.Configuration();
			cfg.setFrom(cfgMgr.getCacheConfigValue(SERVICE_EMAIL_FROM));
			cfg.setMailHost(cfgMgr.getCacheConfigValue(SERVICE_EMAIL_HOST));
			cfg.setRequiresAuthentication(true);
			cfg.setUsername(cfgMgr.getCacheConfigValue(SERVICE_LOGIN_USERNAME));
			cfg.setPassword(cfgMgr.getCacheConfigValue(SERVICE_LOGIN_PASSWORD));

			mailMgr = new MailManager(cfg);
		}
		return mailMgr;
	}

	@Override
	public void email(String templateKey, String locale, String to,
			Map<String, Object> params) throws Exception {
		TemplateManager tplMgr = (TemplateManager) getContainer().getManager(
				TemplateManager.class);
		Template tpl = tplMgr.getByKey(templateKey, locale);
		getMailManager().send(tpl.getSubject(), tpl.getBody(),
				tpl.getContentType().getValue(), to, params, tpl.getKey());

	}

	@Override
	public void email(String templateKey, String locale, String to,
			List<DataSource> attachments, Map<String, Object> params)
			throws Exception {
		TemplateManager tplMgr = (TemplateManager) getContainer().getManager(
				TemplateManager.class);
		Template tpl = tplMgr.getByKey(templateKey, locale);
		getMailManager().send(tpl.getSubject(), tpl.getBody(),
				tpl.getContentType().getValue(), to, attachments, params,
				tpl.getKey());
	}

	@Override
	public String getLocale(User user) {
		return (user.getLanguage() != null && user.getLanguage().getLocale() != null) ? user
				.getLanguage().getLocale() : null;
	}
}
