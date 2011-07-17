package org.bambrikii.site.base.dao;

import java.util.List;

import org.bambrikii.site.base.model.Language;

public interface ILanguageDAO {

	public abstract List<Language> getList(Boolean active, String order);

}