package org.bambrikii.photobank.web.tests;

import org.bambrikii.site.base.struts2.security.beans.AuthBean;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTests {
	@Test
	public void checkEMail() {
		String email = "asd@asd.ru";
		Assert.assertTrue("email should match the template",
				email.matches(AuthBean.EMAIL_VALIDATION_PATTERN));
	}

	@Test
	public void test1() throws Exception {
		try {
			test2();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void test2() throws Exception {
		try {
			test3();
		} catch (Exception ex) {
			throw ex;
		}
	}

	public void test3() throws Exception {
		throw new Exception("asd");
	}
}
