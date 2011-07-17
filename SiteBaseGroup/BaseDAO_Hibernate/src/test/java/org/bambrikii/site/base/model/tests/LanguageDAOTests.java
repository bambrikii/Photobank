package org.bambrikii.site.base.model.tests;

import java.util.List;

import junit.framework.Assert;

import org.bambrikii.site.base.dao.LanguageDAO;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Test;

public class LanguageDAOTests extends DAOTestBase<LanguageDAO> {
	@Test
	public void list() {
		List<Language> list = dao.getList("order");
		Assert.assertTrue("No languages found.", list.size() > 0);
		for (Language language : list) {
			System.out.printf("%s, %s, %s, %s\n", language.getId(),
					language.getLocale(), language.getName(),
					language.getOrder());
		}
	}
}
