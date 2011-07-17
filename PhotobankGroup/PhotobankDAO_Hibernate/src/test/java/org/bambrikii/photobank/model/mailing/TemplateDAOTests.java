package org.bambrikii.photobank.model.mailing;

import java.util.List;

import org.bambrikii.photobank.mailing.dao.TemplateDAO;
import org.bambrikii.photobank.mailing.model.Template;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.junit.Test;

public class TemplateDAOTests extends DAOTestBase<TemplateDAO> {
	@Test
	public void listTemplatesTest() {
		List<Template> list = dao.getList();
		for (Template item : list) {
			System.out.printf("\t%s,\n\t%s,\n\t%s,\n\t%s\n\n", item.getId(),
					item.getKey(), item.getSubject(), item.getBody());
		}
	}
}
