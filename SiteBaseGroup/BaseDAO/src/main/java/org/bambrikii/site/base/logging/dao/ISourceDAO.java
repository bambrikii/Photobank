package org.bambrikii.site.base.logging.dao;

import org.bambrikii.site.base.logging.model.Source;

public interface ISourceDAO {

	public abstract Source getByName(String name);

	public abstract Source checkSource(String name);

}