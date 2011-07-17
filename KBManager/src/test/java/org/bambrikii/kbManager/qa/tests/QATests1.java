package org.bambrikii.kbManager.qa.tests;

import junit.framework.Assert;

import org.bambrikii.kbManager.qa.IGrader;
import org.bambrikii.kbManager.qa.IKnowledgeContainer;
import org.bambrikii.kbManager.qa.IQuery;
import org.bambrikii.kbManager.qa.Query;
import org.bambrikii.kbManager.qa.impl.Grader;
import org.bambrikii.kbManager.qa.impl.KnowledgeQuery;
import org.junit.Test;

public class QATests1 {
	@Test
	public void test1() {
		// Build query
		IQuery query = new KnowledgeQuery();
		query.addCondition("CONTAINS", "knowledge1");

		// Instantiate grader
		IGrader grader = new Grader();

		// Get the knowledge
		IKnowledgeContainer knowledge2 = grader.ask(query);
		Assert.assertNotNull(knowledge2);
	}

	@Test
	public void test2() {
		Query q = new Query();
		q.condition("is", "rss feed");
	}
}
