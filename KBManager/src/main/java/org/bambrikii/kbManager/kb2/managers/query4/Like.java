package org.bambrikii.kbManager.kb2.managers.query4;

public class Like extends ConditionBase {

	private String value;

	public Like(ConditionType type, String value) {
		super(type);
		setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getQueryString() {
		return getAlias() + ".key" + " like " + value;
	}

}
