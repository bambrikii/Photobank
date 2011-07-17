package org.bambrikii.kbManager.kb2.managers.query4.impl;

import org.bambrikii.kbManager.kb2.managers.query4.ConditionType;
import org.bambrikii.kbManager.kb2.managers.query4.ICondition;
import org.bambrikii.kbManager.kb2.managers.query4.Or;

public class OrImpl extends Or {
	public OrImpl(ConditionType type, ICondition[] conditions) {
		super(type, conditions);
	}

	
}
