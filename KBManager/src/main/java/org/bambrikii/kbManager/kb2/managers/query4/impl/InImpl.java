package org.bambrikii.kbManager.kb2.managers.query4.impl;

import org.apache.commons.lang.StringUtils;
import org.bambrikii.kbManager.kb2.managers.query4.ConditionType;
import org.bambrikii.kbManager.kb2.managers.query4.ICondition;
import org.bambrikii.kbManager.kb2.managers.query4.In;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class InImpl extends In {

	public InImpl(ConditionType type, ICondition value) {
		super(type, value);
	}

	public void build(Criteria crit) {
		crit.add(Restrictions.in(getAlias() + ".key",
				StringUtils.split(getValue().getQueryString(), ",")));
	}
}
