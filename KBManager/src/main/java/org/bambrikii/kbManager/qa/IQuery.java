package org.bambrikii.kbManager.qa;


public interface IQuery {
	IKnowledgeFilter getFilter();

	void addCondition(String subject, String object);
}
