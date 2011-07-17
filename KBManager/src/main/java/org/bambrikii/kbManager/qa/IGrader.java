package org.bambrikii.kbManager.qa;


public interface IGrader {

	boolean teach(IKnowledgeContainer knowledge);

	IKnowledgeContainer ask(IQuery query);
}
