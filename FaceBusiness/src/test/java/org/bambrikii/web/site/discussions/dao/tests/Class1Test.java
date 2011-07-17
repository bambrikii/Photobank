package org.bambrikii.web.site.discussions.dao.tests;

import org.junit.Test;

public class Class1Test {
	@Test
	public void test1() throws Exception {
		try {
			throw new Exception("ex1");
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Test
	public void test2() throws Exception {
		try {
			throw new Exception("ex1");
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
}
