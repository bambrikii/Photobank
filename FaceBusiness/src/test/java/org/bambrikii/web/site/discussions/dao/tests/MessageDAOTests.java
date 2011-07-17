package org.bambrikii.web.site.discussions.dao.tests;

import java.util.Calendar;
import java.util.Date;

import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.web.site.services.discussion.dao.MessageDAO;
import org.bambrikii.web.site.services.discussion.model.Message;
import org.bambrikii.web.site.services.discussion.model.MessageStatusEnum;
import org.bambrikii.web.site.services.discussion.model.Topic;
import org.bambrikii.web.site.tests.core.DAOTestBase;
import org.junit.Before;
import org.junit.Test;

public class MessageDAOTests extends DAOTestBase<MessageDAO> {

	public static String DEFAULT_LOGIN = "asd";
	private UserDAO userDao;

	@Before
	public void before() throws DAOException {
		super.before();
		userDao = new UserDAO(cn);
	}

	@Test
	public void createReadUpdateDelete() throws Exception {
		User user = userDao.getByLogin(DEFAULT_LOGIN);

		Date currDate = Calendar.getInstance().getTime();

		try {
			Message msg = new Message();
			msg.setAuthor(user);
			msg.setModificationTime(Calendar.getInstance().getTime());
			msg.setParent(null);
			msg.setStatus(MessageStatusEnum.PUBLISHED);
			msg.setTitle("Message title " + currDate.toString());
			msg.setText("Message text " + currDate.toString());
			Topic topic = null;
			msg.setTopic(topic);
			cn.beginTransaction();
			dao.saveOrUpdate(msg);
			cn.commitTransaction();

			msg.setText("Message text 2");
			cn.beginTransaction();
			dao.saveOrUpdate(msg);
			cn.commitTransaction();

			cn.beginTransaction();
			dao.delete(msg);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
	}
}
