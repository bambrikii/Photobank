package org.bambrikii.kbManager.kb2.managers.query4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class And extends ConditionBase {

	private List<ICondition> conditions;

	public And(ConditionType type, ICondition... conditions) {
		super(type);
		this.setConditions(Arrays.asList(conditions));
	}

	private void setConditions(List<ICondition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String getQueryString() {
		List<String> result = new ArrayList<String>();
		for (ICondition condition : conditions) {
			// String alias = condition.getAlias(parentAlias, type);
			String queryString = condition.getQueryString();
			result.add(queryString);
		}
		return StringUtils.join(result, " \nand ");
	}

}
