package org.bambrikii.web.site.services.discussion;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;
import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.bambrikii.web.site.security.SecurityBean;
import org.bambrikii.web.site.services.discussion.model.Topic;

public class TopicAction extends SiteBasePagerAction<Pager<Topic>> {
	private static final long serialVersionUID = -5441219941881709524L;

	private DiscussionBean discussionBean;
	private SecurityBean securityBean;

	private Topic model;

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

	public void setModel(Topic model) {
		this.model = model;
	}

	public Topic getModel() {
		return model;
	}

	private Integer getUserId() {
		return (Integer) getSession().get(AuthBean.USER_ID_KEY);
	}

	private Integer getTopicId() {
		return getModel() != null && getModel().getId() != null ? getModel()
				.getId() : null;
	}

	// Actions
	public String edit() throws Exception {
		Integer topicId = getTopicId();
		if (topicId == null) {
			throw new Exception("Topic id requred!");
		}
		Topic topic = getDiscussionBean().getTopicById(topicId);
		if (topic == null) {
			throw new Exception("Topic not found!");
		}
		setModel(topic);
		return "edit";
	}

	// TODO: badly done,... transaction scenario required, i.e. should wrap
	// all logic in bean's single transaction.
	public String save() throws Exception {
		Integer topicId = getTopicId();
		Topic topic = null;
		User user = getSecurityBean().getUserById(getUserId());
		if (topicId != null) {
			topic = getDiscussionBean().getTopicById(topicId);
			if (topic == null) {
				throw new Exception("Topic not found!");
			}
		} else {
			topic = new Topic();
			topic.setAuthor(user);
		}
		topic.setTitle(getModel().getTitle());
		topic.setStatus(getModel().getStatus());
		getDiscussionBean().saveOrUpdate(topic, user);
		setModel(topic);
		return "edit";

	}

	public String delete() throws Exception {
		Integer topicId = getTopicId();
		if (topicId == null) {
			throw new Exception("Topic id requred!");
		}
		Topic topic = getDiscussionBean().getTopicById(topicId);
		if (topic == null) {
			throw new Exception("Topic not found!");
		}
		Integer userId = getUserId();
		User user = userId != null ? getSecurityBean().getUserById(userId)
				: null;
		getDiscussionBean().delete(topic, user);
		return list();
	}

	public String list() throws Exception {
		try {
			Integer userId = getUserId();
			User user = userId != null ? getSecurityBean().getUserById(userId)
					: null;
			Integer topicId = getTopicId();
			setPager(getDiscussionBean().getTopicsPager(topicId, user,
					getRequestedPage()));
		} catch (ManagerException ex) {
			throw new Exception(ex);
		}
		return "list";
	}

	public String execute() throws Exception {
		return list();
	}
}
