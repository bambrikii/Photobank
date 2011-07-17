package org.bambrikii.photobank.mailing.templates.managers;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocityTemplateEngine implements TemplateEngine {

	private static VelocityEngine engine;

	protected VelocityEngine getEngine() throws Exception {
		if (engine == null) {
			engine = new VelocityEngine();
			engine.init();
		}
		return engine;
	}

	@Override
	public String evaluate(String key, String text, Map<String, Object> params)
			throws TemplateEngineException {
		VelocityContext context = new VelocityContext();
		for (String paramKey : params.keySet()) {
			context.put(paramKey, params.get(paramKey));
		}
		Writer writer = new StringWriter();
		try {
			Velocity.evaluate(context, writer, key, text);
		} catch (ParseErrorException ex) {
			throw new TemplateEngineException("Failed to evaluate string", ex);
		} catch (MethodInvocationException ex2) {
			throw new TemplateEngineException("Failed to evaluate string", ex2);
		} catch (ResourceNotFoundException ex3) {
			throw new TemplateEngineException("Failed to evaluate string", ex3);
		} catch (IOException ex4) {
			throw new TemplateEngineException("Failed to evaluate string", ex4);
		}
		return writer.toString();
	}

}
