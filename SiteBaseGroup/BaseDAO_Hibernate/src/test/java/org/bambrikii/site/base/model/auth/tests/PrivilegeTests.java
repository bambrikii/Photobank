package org.bambrikii.site.base.model.auth.tests;

import java.util.List;

import org.bambrikii.site.base.auth.dao.PrivilegeDAO;
import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrivilegeTests extends DAOTestBase<PrivilegeDAO> {
	private UserDAO userDao;

	@Before
	public void before() throws DAOException {
		super.before();
		userDao = new UserDAO(cn);
	}

	@Test
	public void listUserPrivileges() {
		User user = userDao.getByLogin(UserTests.TEST_LOGIN);
		List<String> privs = dao.getRolesList(user);
		Assert.assertTrue("No privileges found!", privs.size() > 0);
		for (String priv : privs) {
			System.out.printf(" %s\n", priv);
		}
	}
}
