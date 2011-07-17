package org.bambrikii.kbManager.kb2.managers.query4;

public class Query4<T> {

	private ICondition where;

	public void where(ICondition condition) {
		condition.setParent(null);
		this.where = condition;
	}

	public ICondition and(ConditionType type, ICondition... conditions) {
		ICondition condition = new And(type, conditions);
		for (ICondition condition1 : conditions) {
			condition1.setParent(condition);
		}
		return condition;
	}

	public ICondition or(ConditionType type, ICondition... conditions) {
		ICondition condition = new Or(type, conditions);
		for (ICondition condition1 : conditions) {
			condition1.setParent(condition);
		}
		return condition;
	}

	public ICondition like(ConditionType type, String value) {
		return new Like(type, "'" + value + "'");
	}

	public ICondition in(ConditionType type, ICondition condition1) {
		ICondition condition = new In(type, condition1);
		condition1.setParent(condition);
		return condition;
	}

	public String toQueryString() {
		return "from " + where.getAlias() + " \nwhere "
				+ where.getQueryString();
	}

	public T build(T obj) {
		return obj;
	}
}
