package org.bambrikii.photobank.mailing.templates.managers;


public class TemplateEngineException extends Exception {
	private static final long serialVersionUID = 8427672206013313881L;

	public TemplateEngineException(String message, Exception ex) {
		super(message, ex);
	}
}
