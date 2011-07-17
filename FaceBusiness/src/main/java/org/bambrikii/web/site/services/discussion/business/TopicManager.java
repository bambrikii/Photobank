package org.bambrikii.web.site.services.discussion.business;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.business.pagers.PagerBuilder;
import org.bambrikii.web.site.services.discussion.dao.TopicDAO;
import org.bambrikii.web.site.services.discussion.model.Topic;
import org.bambrikii.web.site.services.discussion.model.TopicStatusEnum;

public class TopicManager extends ManagerBase<Topic, TopicDAO> {

	private Integer pagerCols = 1;
	private Integer pagerRows = 150;
	private List<TopicStatusEnum> activeStatuses;

	public TopicManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		activeStatuses = new ArrayList<TopicStatusEnum>() {
			private static final long serialVersionUID = 4885416264553985297L;
			{
				add(TopicStatusEnum.OPEN);
				add(TopicStatusEnum.READONLY);
				add(TopicStatusEnum.CLOSED);
			}
		};
	}

	public void saveOrUpdate(Topic topic) throws ManagerException {
		topic.setModificationTime(Calendar.getInstance().getTime());
		super.saveOrUpdate(topic);
	}

	public Pager<Topic> getPager(Topic parent, String sortOrder,
			Integer currPage) {
		return new PagerBuilder<Topic>(dao).eq("parent", parent)
				.in("status", activeStatuses)
				.getPager(pagerCols, pagerRows, sortOrder, currPage);
	}
}
