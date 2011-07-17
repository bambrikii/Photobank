package org.bambrikii.photobank.mailing.templates.managers;

import java.util.Map;

public interface TemplateEngine {
	String evaluate(String key, String title, Map<String, Object> params)
			throws TemplateEngineException;
}
