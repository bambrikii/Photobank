package org.bambrikii.photobank.web.security.beans;

public class SortOfActivity {
	private String key;
	private String value;

	public SortOfActivity(String key, String value) {
		setKey(key);
		setValue(value);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
