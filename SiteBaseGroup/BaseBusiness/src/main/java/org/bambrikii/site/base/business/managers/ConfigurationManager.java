package org.bambrikii.site.base.business.managers;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.configuration.dao.ConfigurationDAO;
import org.bambrikii.site.base.configuration.model.Configuration;

public class ConfigurationManager extends
		ManagerBase<Configuration, ConfigurationDAO> {
	private static Map<String, String> configCache = new HashMap<String, String>();

	public ConfigurationManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
	}

	public Configuration getByName(String name) {
		return dao.getByName(name);
	}

	public String getValue(String name) throws ManagerException {
		Configuration configuration = dao.getByName(name);
		if (configuration != null) {
			return configuration.getValue();
		}
		throw new ManagerException("No configuration found for {0}");
	}

	public String getCacheConfigValue(String configurationName)
			throws ManagerException {
		if (configCache.containsKey(configurationName)) {
			return configCache.get(configurationName);
		}
		return setCacheConfigValue(configurationName);
	}

	private synchronized String setCacheConfigValue(String configurationName)
			throws ManagerException {
		Configuration cfg = dao.getByName(configurationName);
		if (cfg != null) {
			String cfgVal = cfg.getValue();
			if (cfgVal != null) {
				configCache.put(configurationName, cfgVal);
				return cfgVal;
			} else {
				throw new ManagerException(MessageFormat.format(
						"Configuration value of {0} is null.",
						configurationName));
			}
		} else {
			throw new ManagerException(MessageFormat.format(
					"Configuration {0} not found.", configurationName));
		}
	}

}
