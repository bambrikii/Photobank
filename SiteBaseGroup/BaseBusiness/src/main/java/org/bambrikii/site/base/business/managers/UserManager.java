package org.bambrikii.site.base.business.managers;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.site.base.auth.dao.IPrivilegeDAO;
import org.bambrikii.site.base.auth.dao.PrivilegeDAO;
import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.managers.exceptions.LoginInfoRequiredException;
import org.bambrikii.site.base.business.managers.exceptions.PasswordIncorrectException;
import org.bambrikii.site.base.business.managers.exceptions.PasswordValidationException;
import org.bambrikii.site.base.business.managers.exceptions.UserDoesNotExistException;
import org.bambrikii.site.base.business.managers.exceptions.UserStatusException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.dao.LanguageDAO;
import org.bambrikii.site.base.dao.PhoneDAO;
import org.bambrikii.site.base.model.Language;
import org.bambrikii.site.base.model.Phone;

public class UserManager extends ManagerBase<User, UserDAO> {
	private IPrivilegeDAO privilegeDao;
	private LanguageDAO languageDao;
	private PhoneDAO phoneDao;

	public Pager<User> pager = new Pager<User>(1, 150);

	public UserManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		privilegeDao = new PrivilegeDAO(dao.getConnector());
		languageDao = new LanguageDAO(dao.getConnector());
		phoneDao = new PhoneDAO(dao.getConnector());
	}

	private String getEncryptedPassword(String password)
			throws PasswordValidationException {
		try {
			MessageDigest mdEnc = MessageDigest.getInstance("SHA-1");
			mdEnc.update(password.getBytes("UTF-8"));
			return new BigInteger(1, mdEnc.digest()).toString(16);
		} catch (NoSuchAlgorithmException ex) {
			throw new PasswordValidationException(
					"Password validation exception occurred", ex);
		} catch (UnsupportedEncodingException ex2) {
			throw new PasswordValidationException(
					"Password validation exception occurred", ex2);
		}
	}

	public User login(String login, String password)
			throws LoginInfoRequiredException, UserDoesNotExistException,
			PasswordIncorrectException, NoSuchAlgorithmException,
			UnsupportedEncodingException, PasswordValidationException,
			UserStatusException {
		if (login == null || "".equals(login) || password == null
				|| "".equals(password)) {
			throw new LoginInfoRequiredException("Login fields not filled");
		}
		User user = dao.getByLogin(login);
		if (user == null) {
			throw new UserDoesNotExistException("User does not exist");
		}
		if (user.getStatus() == UserStatusEnum.DISABLED) {
			throw new UserStatusException("User is disabled");
		}
		if (user.getStatus() == UserStatusEnum.WAITING_CONSIDERATION) {
			throw new UserStatusException(
					"User status is waiting for consideration");
		}
		if (!getEncryptedPassword(password).equals(user.getPasswdSHA1())) {
			throw new PasswordIncorrectException("Password is incorrect");
		}
		return user;
	}

	public List<String> getUserPrivileges(User user) {
		return privilegeDao.getRolesList(user);
	}

	public List<String> getUserRoles(User user) {
		return privilegeDao.getRolesList(user);
	}

	public User getUserByLogin(String login) {
		return dao.getByLogin(login);
	}

	@Override
	public void saveOrUpdate(User user) throws ManagerException {
		user.setModificationTime(Calendar.getInstance().getTime());
		if (!(user.getPassword() == null || "".equals(user.getPassword()))) {
			user.setPasswdSHA1(getEncryptedPassword(user.getPassword()));
		}
		super.saveOrUpdate(user);
	}

	public List<Language> getLanguages(Boolean activeOnly) {
		if (activeOnly) {
			return languageDao.getList(activeOnly, "order");
		} else {
			return languageDao.getList("order");
		}
	}

	public Language getLanguageById(Integer id) {
		return languageDao.getById(id);
	}

	public void saveOrUpdatePhone(Phone phone) {
		phoneDao.saveOrUpdate(phone);
	}

	public Pager<User> getUsersPager(String sortOrder, Integer currPage) {
		Pager<User> pg = pager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getUsersCount());
		pg.setRecords(dao.getList(sortOrder, pg.getStart(), pg.getLength()));
		return pg;
	}

	public Pager<User> getUsersPager(List<UserStatusEnum> statuses,
			String sortOrder, Integer currPage) {
		Pager<User> pg = pager.clone();
		pg.setCurrPage(currPage);
		pg.setTotalRecordsCount(dao.getUsersCount(statuses));
		pg.setRecords(dao.getUsersList(statuses, sortOrder, pg.getStart(),
				pg.getLength()));
		return pg;
	}
}
