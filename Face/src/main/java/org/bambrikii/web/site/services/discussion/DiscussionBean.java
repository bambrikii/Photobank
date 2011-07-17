package org.bambrikii.web.site.services.discussion;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.UserManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.web.site.services.discussion.business.MessageManager;
import org.bambrikii.web.site.services.discussion.business.TopicManager;
import org.bambrikii.web.site.services.discussion.model.Message;
import org.bambrikii.web.site.services.discussion.model.MessageStatusEnum;
import org.bambrikii.web.site.services.discussion.model.Topic;
import org.bambrikii.web.site.services.discussion.model.TopicStatusEnum;

public class DiscussionBean extends SiteBaseBean {

	public void postTopic(String title, Integer userId, Integer parentId)
			throws ManagerException {
		if (userId == null) {
			throw new ManagerException(
					"User identifier should be set for topic creation!");
		}
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		UserManager umgr = (UserManager) getContainer().getManager(
				TopicManager.class);
		Topic parent = parentId != null ? mgr.getById(parentId) : null;
		User author = umgr.getById(userId);
		Topic topic = new Topic();
		topic.setAuthor(author);
		topic.setParent(parent);
		topic.setStatus(TopicStatusEnum.OPEN);
		topic.setTitle(title);
		getContainer().begin();
		try {
			mgr.saveOrUpdate(topic);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void postMessage(String title, String text, Integer userId,
			Integer topicId, Integer parentMessageId) throws ManagerException {
		if (userId == null) {
			throw new ManagerException(
					"User identifier should be set for message creation!");
		}
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		TopicManager tmgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		UserManager umgr = (UserManager) getContainer().getManager(
				UserManager.class);
		Topic topic = topicId != null ? tmgr.getById(topicId) : null;
		Message prntMsg = parentMessageId != null ? mgr
				.getById(parentMessageId) : null;
		User author = umgr.getById(userId);
		Message msg = new Message();
		msg.setAuthor(author);
		msg.setTopic(topic);
		msg.setParent(prntMsg);
		msg.setStatus(MessageStatusEnum.PUBLISHED);
		msg.setTitle(title);
		msg.setText(text);
		getContainer().begin();
		try {
			mgr.saveOrUpdate(msg);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void deleteTopic(Integer id, Integer userId) throws ManagerException {
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		getContainer().begin();
		try {
			Topic topic = mgr.getById(id);
			mgr.delete(topic);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void deleteMessage(Integer id, Integer userId)
			throws ManagerException {
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		getContainer().begin();
		try {
			Message msg = mgr.getById(id);
			mgr.delete(msg);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public Pager<Topic> getTopicsPager(Integer parentId, User user,
			Integer requestedPage) throws ManagerException {
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		Topic parent = parentId != null ? mgr.getById(parentId) : null;
		return mgr.getPager(parent, "modificationTime DESC", requestedPage);
	}

	public Topic getTopicById(Integer id) throws ManagerException {
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		return mgr.getById(id);
	}

	public void saveOrUpdate(Topic topic, User user) throws ManagerException {
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		getContainer().begin();
		try {
			mgr.saveOrUpdate(topic);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void delete(Topic topic, User user) throws ManagerException {
		TopicManager mgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		getContainer().begin();
		try {
			mgr.delete(topic);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public Pager<Message> getMessagesPager(Integer topicId,
			Message parentMessage, User user, Integer requestedPage)
			throws ManagerException {
		TopicManager tmgr = (TopicManager) getContainer().getManager(
				TopicManager.class);
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		Topic topic = tmgr.getById(topicId);
		if (topic == null) {
			throw new ManagerException("Topic id required!");
		}
		return mgr.getPager(topic, parentMessage, "modificationTime DESC",
				requestedPage);
	}

	public Message getMessageById(Integer id) throws ManagerException {
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		return mgr.getById(id);
	}

	public void saveOrUpdate(Message message, User user)
			throws ManagerException {
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		getContainer().begin();
		try {
			mgr.saveOrUpdate(message);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}

	public void delete(Message message, User user) throws ManagerException {
		MessageManager mgr = (MessageManager) getContainer().getManager(
				MessageManager.class);
		getContainer().begin();
		try {
			mgr.delete(message);
			getContainer().commit();
		} catch (ManagerException ex) {
			getContainer().rollback();
			throw ex;
		}
	}
}
