package org.bambrikii.site.base.business.tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.business.managers.UserManager;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.business.tests.core.ManagerTestBase;
import org.bambrikii.site.base.model.Language;
import org.junit.Test;

public class UserManagerTests extends ManagerTestBase<UserManager> {
	public static String TEST_LOGIN = "asd";

	@Test
	public void getUserPrivilegesTest() {
		User user = mgr.getUserByLogin(TEST_LOGIN);
		List<String> privs = mgr.getUserRoles(user);
		Assert.assertTrue("No privileges found!", privs.size() > 0);
		for (String priv : privs) {
			System.out.printf(" %s\n", priv);
		}
	}

	@Test
	public void getAvailableLanguages() {
		List<Language> list = mgr.getLanguages(true);
		Assert.assertTrue("No languages found.", list.size() > 0);
		for (Language language : list) {
			System.out.printf("%s, %s, %s, %s\n", language.getId(),
					language.getLocale(), language.getName(),
					language.getOrder());
		}
	}

	@Test
	public void getPagerTest() {
		Pager<User> pg = mgr.getUsersPager("login", 0);
		Assert.assertTrue("No count calculated", pg.getTotalRecordsCount() > 0);
		Assert.assertTrue("No records fetched", pg.getRecords().size() > 0);
		printUsersPager(pg);
	}

	private void printUsersPager(Pager<User> pg) {
		System.out
				.printf("	totalRecordsCount: %s\n", pg.getTotalRecordsCount());
		for (User user : pg.getRecords()) {
			System.out.printf("%s, %s, %s\n", user.getId(), user.getLogin(),
					user.getStatus());
		}
	}

	@Test
	public void getPagerByStatusFilterTest() {
		Pager<User> pg = mgr.getUsersPager(new ArrayList<UserStatusEnum>() {
			private static final long serialVersionUID = 7767139139246826255L;
			{
				add(UserStatusEnum.DISABLED);
				add(UserStatusEnum.ENABLED);
			}
		}, "login", 0);

		for (User user : pg.getRecords()) {
			Assert.assertTrue("User status field is wrong",
					user.getStatus().equals(UserStatusEnum.ENABLED)
							|| user.getStatus().equals(UserStatusEnum.DISABLED));
		}
		printUsersPager(pg);
	}
}
