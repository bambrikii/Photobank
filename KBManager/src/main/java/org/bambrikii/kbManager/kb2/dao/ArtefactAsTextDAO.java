package org.bambrikii.kbManager.kb2.dao;

import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;

public class ArtefactAsTextDAO extends DAOBase<ArtefactAsText> {

	public ArtefactAsTextDAO(PersistenceConnector connector) {
		super(connector);
	}

	protected Criteria getCriteriaSource() {
		Criteria crit = getConnector().getSession().createCriteria(
				ArtefactAsText.class);
		crit.createAlias("srcParent.source", "srcRel");
		crit.createAlias("dstParent", "dstRel");
		crit.createAlias("kndParent", "kindRel");
		return crit;
	}
}
