package org.bambrikii.photobank.web.security;

import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.junit.Assert;
import org.junit.Test;

public class AnnotationsTests {
	@Test
	public void authorizationAwareTest() {
		Assert.assertTrue("Annotation not found!", TestClass1.class
				.isAnnotationPresent(SiteBaseSecurityAware.class));
		SiteBaseSecurityAware ann = TestClass1.class
				.getAnnotation(SiteBaseSecurityAware.class);
		for (String role : ann.allowedRoles()) {
			System.out.printf(" %s", role);
		}
	}
}
