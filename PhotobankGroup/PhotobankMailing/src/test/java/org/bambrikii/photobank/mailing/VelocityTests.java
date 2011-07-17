package org.bambrikii.photobank.mailing;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.bambrikii.photobank.mailing.templates.managers.TemplateEngine;
import org.bambrikii.photobank.mailing.templates.managers.VelocityTemplateEngine;
import org.junit.Assert;
import org.junit.Test;

public class VelocityTests {
	@Test
	public void velocityTest1() throws Exception {
		String currentdir = System.getProperty("user.dir");
		System.out.printf("%s\n", currentdir);
		VelocityEngine ve = new VelocityEngine();
		ve.init();
		Template template = ve
				.getTemplate("target\\test-classes\\org\\bambrikii\\photobank\\mailing\\helloworld.vm");
		VelocityContext context = new VelocityContext();
		context.put("name", "World");
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		System.out.println(writer.toString());
	}

	@Test
	public void velocrityTemplateFromStringTest() throws Exception {
		VelocityEngine engine = new VelocityEngine();
		engine.init();

		VelocityContext context = new VelocityContext();
		context.put("name", "World");
		Writer writer = new StringWriter();
		Velocity.evaluate(context, writer, "template1",
				"message $name\n some more a string...\n and line");
		Assert.assertEquals(writer.toString(),
				"message World\n some more a string...\n and line");
	}

	@Test
	public void templateEngineTest() throws Exception {
		TemplateEngine mgr = new VelocityTemplateEngine();
		String str = mgr.evaluate(Constants.DEFAULT_TEMPLATE_KEY,
				Constants.DEFAULT_TEMPLATE_BODY,
				Constants.DEFAULT_TEMPLATE_PARAMETERS);
		System.out.printf("%s\n", str);
	}
}
