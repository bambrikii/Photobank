package org.bambrikii.kbManager.kb2.managers.query4.impl;

import org.bambrikii.kbManager.kb2.managers.query4.ConditionType;
import org.bambrikii.kbManager.kb2.managers.query4.Like;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class LikeImpl extends Like {
	public LikeImpl(ConditionType type, String value) {
		super(type, value);
	}

	public void build(Criteria crit) {
		crit.add(Restrictions.like(getAlias() + ".key", getValue()));
	}
}
