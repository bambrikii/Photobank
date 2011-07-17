package org.bambrikii.kbManager.kb2.managers.query4;

public interface ICondition {

	void setParent(ICondition condition);

	String getAlias();

	String getQueryString();
}
