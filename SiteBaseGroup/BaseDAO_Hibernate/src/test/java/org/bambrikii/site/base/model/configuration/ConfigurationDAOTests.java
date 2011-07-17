package org.bambrikii.site.base.model.configuration;

import junit.framework.Assert;

import org.bambrikii.site.base.configuration.dao.ConfigurationDAO;
import org.bambrikii.site.base.configuration.model.Configuration;
import org.bambrikii.site.base.persistence.PersistenceException;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Test;

public class ConfigurationDAOTests extends DAOTestBase<ConfigurationDAO> {
	@Test
	public void crudTest() throws PersistenceException {
		String value1 = "value1";
		String value2 = "value2";
		Configuration config = new Configuration();
		config.setName("PhotobankModel.temp.ConfigName1");
		config.setValue(value1);
		cn.beginTransaction();
		dao.saveOrUpdate(config);
		cn.commitTransaction();
		Assert.assertTrue("Configuration was expected to be saved.",
				config.getId() > 0);
		Configuration config2 = dao.getById(config.getId());
		Assert.assertTrue("Configuration was not found by id", config2 != null);
		config2.setValue(value2);
		dao.saveOrUpdate(config2);
		Configuration config3 = dao.getById(config2.getId());
		Assert.assertTrue("Update failed.", value2.equals(config3.getValue()));
		Configuration config4 = dao.getByName(config3.getName());
		Assert.assertTrue("Configuration was not found by id", config4 != null);
		cn.beginTransaction();
		dao.delete(config4);
		cn.commitTransaction();
	}
}
