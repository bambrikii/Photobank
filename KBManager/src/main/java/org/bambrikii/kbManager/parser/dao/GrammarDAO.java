package org.bambrikii.kbManager.parser.dao;

import org.bambrikii.kbManager.parser.model.Grammar;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

public class GrammarDAO extends DAOBase<Grammar> {

	public GrammarDAO(PersistenceConnector connector) {
		super(connector);
		// TODO Auto-generated constructor stub
	}

	public Grammar getByName(String name) {
		Criteria crit = getCriteria().add(
				Expression.eq("name", name));
		return (Grammar) crit.uniqueResult();
	}
}
