package org.bambrikii.kbManager.kb2.managers.query4;

public class In extends ConditionBase {

	private ICondition value;

	public In(ConditionType type, ICondition value) {
		super(type);
		setValue(value);
	}

	public ICondition getValue() {
		return value;
	}

	public void setValue(ICondition value) {
		this.value = value;
	}

	@Override
	public String getQueryString() {
		return getAlias() + ".key" + " in " + "(" + value.getQueryString()
				+ ")\n";
	}

}
