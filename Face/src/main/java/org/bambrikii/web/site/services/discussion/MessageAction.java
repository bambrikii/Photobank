package org.bambrikii.web.site.services.discussion;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.bambrikii.web.site.security.SecurityBean;
import org.bambrikii.web.site.services.discussion.model.Message;
import org.bambrikii.web.site.services.discussion.model.Topic;

public class MessageAction extends SiteBasePagerAction<Pager<Message>> {
	private static final long serialVersionUID = -2812545193142813317L;

	private DiscussionBean discussionBean;
	private SecurityBean securityBean;

	private Message model;

	public void setDiscussionBean(DiscussionBean discussionBean) {
		this.discussionBean = discussionBean;
	}

	public DiscussionBean getDiscussionBean() {
		return discussionBean;
	}

	public void setSecurityBean(SecurityBean securityBean) {
		this.securityBean = securityBean;
	}

	public SecurityBean getSecurityBean() {
		return securityBean;
	}

	public Message getModel() {
		return model;
	}

	public void setModel(Message model) {
		this.model = model;
	}

	private Integer getUserId() {
		return (Integer) getSession().get(AuthBean.USER_ID_KEY);
	}

	private Integer getTopicId() {
		return getModel() != null && getModel().getTopic() != null
				&& getModel().getTopic().getId() != null ? getModel()
				.getTopic().getId() : null;
	}

	private Integer getMessageId() {
		return getModel() != null && getModel().getId() != null ? getModel()
				.getId() : null;
	}

	// Actions
	public String list() throws Exception {
		User user = getSecurityBean().getUserById(getUserId());
		setPager(getDiscussionBean().getMessagesPager(getTopicId(), null, user,
				getRequestedPage()));
		return "list";
	}

	public String execute() throws Exception {
		return list();
	}

	public String edit() throws Exception {
		Integer messageId = getMessageId();
		if (messageId == null) {
			throw new Exception("Message id requred!");
		}
		Message message = getDiscussionBean().getMessageById(messageId);
		if (message == null) {
			throw new Exception("Topic not found!");
		}
		setModel(message);
		return "edit";
	}

	// TODO: badly done,... transaction scenario required, i.e. should wrap
	// all logic in bean's single transaction.
	public String save() throws Exception {
		Integer messageId = getMessageId();
		User user = getSecurityBean().getUserById(getUserId());
		Message message = null;
		if (messageId == null) {
			Integer topicId = getTopicId();
			if (topicId == null) {
				throw new Exception("Topic id required!");
			}
			Topic topic = getDiscussionBean().getTopicById(topicId);
			if (topic == null) {
				throw new Exception("Topic not found!");
			}
			message = new Message();
			message.setAuthor(user);
			message.setTopic(getDiscussionBean().getTopicById(topicId));
		} else {
			message = getDiscussionBean().getMessageById(messageId);
			if (message == null) {
				throw new Exception("Message not found!");
			}
		}
		message.setText(getModel().getText());
		message.setTitle(getModel().getTitle());
		message.setStatus(getModel().getStatus());
		getDiscussionBean().saveOrUpdate(message, user);
		setModel(message);
		return "edit";
	}

	public String delete() throws Exception {
		Integer messageId = getMessageId();
		if (messageId == null) {
			throw new Exception("Message id requred!");
		}
		Message message = getDiscussionBean().getMessageById(messageId);
		if (message == null) {
			throw new Exception("Message not found!");
		}
		Integer userId = getUserId();
		User user = userId != null ? getSecurityBean().getUserById(userId)
				: null;
		getDiscussionBean().delete(message, user);
		return list();
	}
}