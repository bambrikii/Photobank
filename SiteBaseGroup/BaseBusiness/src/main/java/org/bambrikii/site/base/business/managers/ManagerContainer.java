package org.bambrikii.site.base.business.managers;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bambrikii.site.base.business.managers.core.ManagerException;

public class ManagerContainer {

	private ConnectionManager _cnMgr;
	private HashMap<Class<?>, ManagerBase<?, ?>> _managers;

	public ManagerContainer() {
		_cnMgr = new ConnectionManager();
		_managers = new HashMap<Class<?>, ManagerBase<?, ?>>();
	}

	public static ManagerContainer getNewInstance() {
		ManagerContainer mgr = new ManagerContainer();
		return mgr;
	}

	public void open() {
		_cnMgr.open();
	}

	public void close() {
		_cnMgr.close();
		_cnMgr = null;
		// _inst = null;
	}

	public void begin() throws ManagerException {
		_cnMgr.begin();
	}

	public void commit() {
		_cnMgr.commit();
	}

	public void rollback() {
		_cnMgr.rollback();
	}

	public <T extends ManagerBase<?, ?>> T getManager(Class<?> klz)
			throws ManagerException {
		if (!_managers.containsKey(klz)) {
			ManagerBase<?, ?> mgr;
			try {
				Constructor<?> constructor = klz
						.getConstructor(new Class<?>[] { ConnectionManager.class });
				mgr = (ManagerBase<?, ?>) constructor
						.newInstance(new Object[] { _cnMgr });
			} catch (InstantiationException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			} catch (IllegalAccessException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			} catch (SecurityException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			} catch (NoSuchMethodException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			} catch (IllegalArgumentException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			} catch (InvocationTargetException ex) {
				throw new ManagerException(
						"Cannnot instantiate Manager of type "
								+ klz.getCanonicalName(), ex);
			}
			_managers.put(klz, (ManagerBase<?, ?>) mgr);
		}
		return (T) _managers.get(klz);
	}
}
