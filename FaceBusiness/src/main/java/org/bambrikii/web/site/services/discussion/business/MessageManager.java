package org.bambrikii.web.site.services.discussion.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.business.pagers.PagerBuilder;
import org.bambrikii.web.site.services.discussion.dao.MessageDAO;
import org.bambrikii.web.site.services.discussion.model.Message;
import org.bambrikii.web.site.services.discussion.model.MessageStatusEnum;
import org.bambrikii.web.site.services.discussion.model.Topic;

public class MessageManager extends ManagerBase<Message, MessageDAO> {

	private List<MessageStatusEnum> activeStatuses = new ArrayList<MessageStatusEnum>() {
		private static final long serialVersionUID = -5908460365197142018L;
		{
			add(MessageStatusEnum.PUBLISHED);
		}
	};
	private Integer pagerCols = 1;
	private Integer pagerRows = 150;

	public MessageManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public void saveOrUpdate(Message message) throws ManagerException {
		message.setModificationTime(Calendar.getInstance().getTime());
		super.saveOrUpdate(message);
	}

	public Pager<Message> getPager(Topic topic, Message parentMessage,
			String sortOrder, int currPage) {
		PagerBuilder<Message> pb = new PagerBuilder<Message>(dao).eq("topic",
				topic).in("status", activeStatuses);
		if (parentMessage != null) {
			pb.eq("parent", parentMessage);
		}
		return pb.getPager(pagerCols, pagerRows, sortOrder, currPage);
	}
}
