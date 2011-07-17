package org.bambrikii.kbManager.kb2;

import java.text.MessageFormat;
import java.util.List;

import org.bambrikii.kbManager.kb2.managers.query4.ConditionType;
import org.bambrikii.kbManager.kb2.managers.query4.Query4;
import org.bambrikii.kbManager.kb2.managers.query4.impl.Query4Impl;
import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.persistence.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Query4Tests {
	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	@Test
	public void test1() {
		Query4 q = new Query4();
		q.where(q.and(
				ConditionType.SOURCE,
				q.like(ConditionType.SOURCE, "%"),
				q.like(ConditionType.DESTINATION, "%"),
				q.like(ConditionType.KIND, "%"),
				q.in(ConditionType.SOURCE,
						q.or(ConditionType.DESTINATION,
								q.like(ConditionType.SOURCE, "%"),
								q.like(ConditionType.KIND, "%")))));

		System.out.println(q.toQueryString());

	}

	@Test
	public void test2() {
		Query4<Criteria> q = new Query4<Criteria>();
		q.where(q.and(
				ConditionType.SOURCE,
				q.like(ConditionType.SOURCE, "%"),
				q.like(ConditionType.DESTINATION, "%"),
				q.like(ConditionType.KIND, "%"),
				q.in(ConditionType.SOURCE,
						q.or(ConditionType.DESTINATION,
								q.like(ConditionType.SOURCE, "%"),
								q.like(ConditionType.KIND, "%")))));

		System.out.println(q.toQueryString());

		Session sess = HibernateUtil.getSession();
		Criteria crit = sess.createCriteria(ArtefactAsText.class);

		Query4Impl q4impl = new Query4Impl();
		q4impl.setCrit(crit);

		crit = q.build(crit);

		@SuppressWarnings("unchecked")
		List<ArtefactAsText> artefacts1 = crit.list();
		for (ArtefactAsText artefact1 : artefacts1) {
			System.out.println(MessageFormat.format("{0} {1} {2} {4}",
					artefact1.getId(), artefact1.getKey(),
					artefact1.getTitle(), artefact1.getText()));
		}

	}
}
