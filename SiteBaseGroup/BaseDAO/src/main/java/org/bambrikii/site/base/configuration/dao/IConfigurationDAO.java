package org.bambrikii.site.base.configuration.dao;

import org.bambrikii.site.base.configuration.model.Configuration;

public interface IConfigurationDAO {

	public abstract Configuration getByName(String name);

}