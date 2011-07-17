package org.bambrikii.photobank.business.managers;

import org.bambrikii.photobank.mailing.dao.TemplateDAO;
import org.bambrikii.photobank.mailing.model.Template;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class TemplateManager extends ManagerBase<Template, TemplateDAO> {
	public TemplateManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public Template getByKey(String key) {
		return dao.getByKey(key);
	}

	public Template getByKey(String key, String locale) {
		Template tpl = null;
		if (locale != null && !"".equals(locale)) {
			tpl = dao.getByKey(key + "_" + locale);
		}
		if (tpl == null) {
			tpl = dao.getByKey(key);
		}
		return tpl;
	}
}
