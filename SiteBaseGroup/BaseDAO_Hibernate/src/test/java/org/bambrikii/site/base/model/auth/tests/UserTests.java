package org.bambrikii.site.base.model.auth.tests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.dao.PhoneDAO;
import org.bambrikii.site.base.model.Phone;
import org.bambrikii.site.base.model.PhoneTypeEnum;
import org.bambrikii.site.base.tests.core.DAOTestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTests extends DAOTestBase<UserDAO> {
	public static String TEST_LOGIN = "asd";
	private PhoneDAO phoneDao;

	@Before
	public void before() throws DAOException {
		super.before();
		phoneDao = new PhoneDAO(cn);
	}

	@Test
	public void listUsersTest() {
		List<User> items = dao.getList();
		Assert.assertTrue("Zero users found!", items.size() > 0);
		for (User item : items) {
			System.out.printf("%s, %s, %s, %s\n", item.getId(),
					item.getEmail(), item.getLogin(), item.getStatus());
		}
	}

	private User createUser() {
		User item2 = new User();
		String id = String.valueOf(System.currentTimeMillis());
		item2.setLogin("Name_" + id);
		item2.setSurname("Surname_" + id);
		item2.setFirstname("Firstname_" + id);
		item2.setEmail(id + "@test.personastars.com");
		item2.setAddress("address 1");
		item2.setDateOfBirth(Calendar.getInstance().getTime());
		item2.setModificationTime(Calendar.getInstance().getTime());
		item2.setOrganization("organization 1");
		item2.setSortOfActivity("sort of activity 1");
		item2.setPassword(id);
		item2.setStatus(UserStatusEnum.ENABLED);
		return item2;
	}

	@Test
	public void crudUserTest() throws Exception {
		UserDAO dao = new UserDAO(cn);
		cn.beginTransaction();
		try {
			User user = createUser();
			dao.saveOrUpdate(user);
			int id2 = user.getId();
			User item3 = dao.getById(id2);
			item3.setModificationTime(Calendar.getInstance().getTime());
			dao.saveOrUpdate(item3);
			dao.delete(item3);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
	}

	@Test
	public void phoneTest() throws Exception {
		UserDAO dao = new UserDAO(cn);
		cn.beginTransaction();
		try {
			User user = createUser();
			dao.saveOrUpdate(user);
			Phone phone = new Phone();
			phone.setNumber("0123456789");
			phone.setType(PhoneTypeEnum.MOBILE);
			if (user.getPhones() == null) {
				user.setPhones(new ArrayList<Phone>());
			}
			phone.setUser(user);
			phoneDao.saveOrUpdate(phone);
			Assert.assertTrue("Phone has not been saved", phone.getId() != null);
			user.getPhones().add(phone);
			dao.saveOrUpdate(user);
			Assert.assertTrue("No phone added to user.phones collection", user
					.getPhones().size() == 1);
			dao.delete(user);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
	}
}
