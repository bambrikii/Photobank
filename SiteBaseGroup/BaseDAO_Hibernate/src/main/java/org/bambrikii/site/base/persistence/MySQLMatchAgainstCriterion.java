package org.bambrikii.site.base.persistence;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.engine.TypedValue;

// TODO: Underdone yet
public class MySQLMatchAgainstCriterion implements Criterion {
	private static final long serialVersionUID = 3419716742003013757L;

	private String fieldToMatch;
	private String stringToMatchAgainst;
	private Mode mode;

	// private final String sql;
	private final TypedValue[] typedValues = new TypedValue[] {};

	public enum Mode {
		BOOLEAN, NATURAL_LANGUAGE, NATURAL_LANGUAGE_WITH_QUERY_EXPANSION, QUERY_EXPANSION
	}

	public MySQLMatchAgainstCriterion(String fieldToMatch,
			String stringToMatchAgainst, Mode mode) {
		this.fieldToMatch = fieldToMatch;
		this.stringToMatchAgainst = stringToMatchAgainst;
		this.mode = mode;
	}

	public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery)
			throws HibernateException {
		String sqlField = criteriaQuery.getColumn(criteria, fieldToMatch);
		StringBuilder res = new StringBuilder();
		res.append(" MATCH (");
		res.append(sqlField);
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
		return res.toString();
	}

	public TypedValue[] getTypedValues(Criteria criteria,
			CriteriaQuery criteriaQuery) throws HibernateException {
		return typedValues;
	}
}
