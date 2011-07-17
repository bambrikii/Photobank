package org.bambrikii.site.base.struts2.mailing.beans;

import java.util.List;
import java.util.Map;

import javax.activation.DataSource;

import org.bambrikii.site.base.auth.model.User;

public interface MailingBean {

	public abstract void email(String templateKey, String locale, String to,
			Map<String, Object> params) throws Exception;

	public abstract void email(String templateKey, String locale, String to,
			List<DataSource> attachments, Map<String, Object> params)
			throws Exception;

	public abstract String getLocale(User user);

}