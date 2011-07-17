package org.bambrikii.kbManager.kbfeeds.managers;

import java.util.List;

import org.bambrikii.kbManager.kbfeeds.dao.KnowledgeDAO;
import org.bambrikii.kbManager.parser.model.Knowledge;
import org.bambrikii.kbManager.qa.IGrader;
import org.bambrikii.kbManager.qa.IKnowledgeContainer;
import org.bambrikii.kbManager.qa.IQuery;
import org.bambrikii.kbManager.qa.Query;
import org.bambrikii.kbManager.qa.impl.Grader;
import org.bambrikii.kbManager.qa.impl.KnowledgeQuery;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class KbFeedsManager extends ManagerBase<Knowledge, KnowledgeDAO> {
	public KbFeedsManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	public List<Knowledge> loadUrls() {
		List<Knowledge> urls = null;
		// 1. Query knowledge
		// 2. Receive the answer
		IQuery query = new KnowledgeQuery();
		Knowledge rssUrls = new Knowledge();
		query.addCondition("is", "rss url");
		IGrader grader = new Grader();
		IKnowledgeContainer kn1 = grader.ask(query);
		return urls;

	}

	public List<Knowledge> loadUrls2() {
		Query qb = new Query();
		return qb.condition("is", "rss feed").list();
	}

	public void loadNews(List<Knowledge> feedSources) {
	}
}
