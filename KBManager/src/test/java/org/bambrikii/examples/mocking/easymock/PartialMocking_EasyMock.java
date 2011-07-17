package org.bambrikii.examples.mocking.easymock;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

import java.lang.reflect.Method;
import java.util.Map;

// http://jeantessier.com/SoftwareEngineering/Mocking.html#EasyMock
public class PartialMocking_EasyMock extends TestCase {
	public void testPartialMocking() throws Exception {
		Map mockStorage = createMock(Map.class);
		mockStorage.clear();
		expect(mockStorage.size()).andStubReturn(42);

		Cache sut = createMock(Cache.class,
				new Method[] { Cache.class.getMethod("log", String.class) });
		sut.log(isA(String.class));

		replay(mockStorage, sut);

		sut.setUnderlyingStorage(mockStorage);
		sut.logAndClear();

		verify(mockStorage);
	}

	private Map createMock(Class<Map> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	private Cache createMock(Class<Cache> class1, Method[] methods) {
		// TODO Auto-generated method stub
		return null;
	}
}
