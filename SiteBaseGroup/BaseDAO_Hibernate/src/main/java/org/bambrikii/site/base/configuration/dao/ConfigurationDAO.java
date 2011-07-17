package org.bambrikii.site.base.configuration.dao;

import org.bambrikii.site.base.configuration.model.Configuration;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ConfigurationDAO extends DAOBase<Configuration> implements IConfigurationDAO {

	public ConfigurationDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.configuration.dao.IConfigurationDAO#getByName(java.lang.String)
	 */
	@Override
	public Configuration getByName(String name) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("name", name));
		return (Configuration) criteria.uniqueResult();
	}
}
