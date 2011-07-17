package org.bambrikii.web.site.discussions.dao.tests;

import java.util.Calendar;
import java.util.Date;

import org.bambrikii.site.base.auth.dao.UserDAO;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.web.site.services.discussion.dao.TopicDAO;
import org.bambrikii.web.site.services.discussion.model.Topic;
import org.bambrikii.web.site.services.discussion.model.TopicStatusEnum;
import org.bambrikii.web.site.tests.core.DAOTestBase;
import org.junit.Before;
import org.junit.Test;

public class TopicDAOTests extends DAOTestBase<TopicDAO> {

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
			Topic topic = new Topic();
			topic.setAuthor(user);
			topic.setModificationTime(Calendar.getInstance().getTime());
			topic.setParent(null);
			topic.setStatus(TopicStatusEnum.OPEN);
			topic.setTitle("Message title " + currDate.toString());
			cn.beginTransaction();
			dao.saveOrUpdate(topic);
			cn.commitTransaction();

			topic.setTitle("Topic title "
					+ Calendar.getInstance().getTime().toString());
			cn.beginTransaction();
			dao.saveOrUpdate(topic);
			cn.commitTransaction();

			cn.beginTransaction();
			dao.delete(topic);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
	}
}
