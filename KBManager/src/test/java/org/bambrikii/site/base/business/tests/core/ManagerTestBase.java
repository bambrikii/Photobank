package org.bambrikii.site.base.business.tests.core;

import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.After;
import org.junit.Before;

public class ManagerTestBase<MgrT> {
	protected ManagerContainer container;
	protected MgrT mgr;

	@SuppressWarnings("unchecked")
	@Before
	public void before() throws ManagerException {
		container = ManagerContainer.getNewInstance();
		container.open();
		Class<?> mgrClass = (Class<?>) ((java.lang.reflect.ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		mgr = (MgrT) container.getManager(mgrClass);
	}

	@After
	public void after() {
		container.close();
	}
}
