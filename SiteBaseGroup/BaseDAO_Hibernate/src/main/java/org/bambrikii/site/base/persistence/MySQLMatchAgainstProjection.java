package org.bambrikii.site.base.persistence;

import org.bambrikii.site.base.persistence.MySQLMatchAgainstCriterion.Mode;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.SimpleProjection;
import org.hibernate.type.Type;

public class MySQLMatchAgainstProjection extends SimpleProjection {
	private static final long serialVersionUID = -4191375731759442737L;

	private String prop;
	private String stringToMatchAgainst;

	private Mode mode;

	public String toSqlString(Criteria criteria, int position,
			CriteriaQuery criteriaQuery) throws HibernateException {
		StringBuilder res = new StringBuilder();
		res.append(" MATCH (");
		res.append(criteriaQuery.getColumn(criteria, prop));
		res.append(") AGAINST ('");
		res.append(stringToMatchAgainst);
		switch (mode) {
		case BOOLEAN:
			res.append("' IN BOOLEAN MODE ");
			break;
		case NATURAL_LANGUAGE:
			res.append("' IN NATURAL LANGUAGE MODE ");
			break;
		case NATURAL_LANGUAGE_WITH_QUERY_EXPANSION:
			res.append("' IN NATURAL LANGUAGE MODE WITH QUERY EXPANSION ");
			break;
		case QUERY_EXPANSION:
			res.append("' WITH QUERY EXPANSION");
			break;
		}
		res.append(") ");
		res.append(" as y").append(position).append("_");
		return res.toString();
	}

	public Type[] getTypes(Criteria criteria, CriteriaQuery criteriaQuery)
			throws HibernateException {
		return new Type[] { Hibernate.FLOAT };
	}

	public MySQLMatchAgainstProjection(String prop,
			String stringToMatchAgainst, Mode mode) {
		this.prop = prop;
		this.stringToMatchAgainst = stringToMatchAgainst;
		this.mode = mode;
	}
}
