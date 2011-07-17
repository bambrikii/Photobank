package org.bambrikii.site.base.model.auth.tests;

import java.util.List;

import org.bambrikii.site.base.auth.dao.GroupDAO;
import org.bambrikii.site.base.auth.dao.PrivilegeDAO;
import org.bambrikii.site.base.auth.model.Group;
import org.bambrikii.site.base.auth.model.Privilege;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthTests extends DAOTestBase<GroupDAO> {
	PrivilegeDAO privilegeDao;

	@Before
	public void before() throws DAOException {
		super.before();
		privilegeDao = new PrivilegeDAO(cn);
	}

	@Test
	public void listPrivilegesTest() {
		List<Privilege> items = privilegeDao.getList();
		Assert.assertTrue("Zero privileges found!", items.size() > 0);
		for (Privilege item : items) {
			System.out.printf("%s, %s, %s\n", item.getId(), item.getName(),
					item.getOrder());
		}
	}

	@Test
	public void listGroupsTest() {
		List<Group> items = dao.getList();
		Assert.assertTrue("Zero groups found!", items.size() > 0);
		for (Group item : items) {
			System.out.printf("%s, %s, %s\n", item.getId(), item.getName(),
					item.getOrder());
		}
	}
}
