package org.bambrikii.kbManager.kb2.managers.query4;

public abstract class ConditionBase implements ICondition {
	private ConditionType type;
	private ICondition parent;

	public ConditionBase(ConditionType type) {
		setType(type);
	}

	protected String getTableAlias() {
		switch (getType()) {
		case SOURCE:
			return "src";
		case DESTINATION:
			return "dst";
		case KIND:
			return "kind";
		default:
			return null;
		}
	}

	@Override
	public String getAlias() {
		return (parent != null ? parent.getAlias() + "_" : "")
				+ getTableAlias();
	}

	public ConditionType getType() {
		return type;
	}

	protected void setType(ConditionType type) {
		this.type = type;
	}

	public void setParent(ICondition parent) {
		this.parent = parent;
	}

	protected ICondition getParent() {
		return parent;
	}
}
