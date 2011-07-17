package org.bambrikii.examples.mocking.easymock;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

import java.util.Map;

import org.easymock.IMocksControl;

public class CacheTest_EasyMock extends TestCase {

	public void testMethodWithReturnValue() {
		int expectedValue = 42;

		Map mockStorage = createMock(Map.class);
		expect(mockStorage.size()).andReturn(expectedValue);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		Object actualValue = sut.size();
		assertSame(expectedValue, actualValue);

		verify(mockStorage);
	}

	public void testMethodWithReturnValueThrowsAnException() {
		Exception expectedException = new RuntimeException();

		Map mockStorage = createMock(Map.class);
		expect(mockStorage.size()).andThrow(expectedException);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		try {
			sut.size();
			fail("Should have thrown the exception");
		} catch (RuntimeException actualException) {
			assertSame(expectedException, actualException);
		}

		verify(mockStorage);
	}

	public void testVoidMethod() {
		Map mockStorage = createMock(Map.class);
		mockStorage.clear();
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.clear();

		verify(mockStorage);
	}

	public void testVoidMethodThrowsAnException() {
		Exception expectedException = new RuntimeException();

		Map mockStorage = createMock(Map.class);
		mockStorage.clear();
		expectLastCall().andThrow(expectedException);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		try {
			sut.clear();
			fail("Should have thrown the exception");
		} catch (RuntimeException actualException) {
			assertSame(expectedException, actualException);
		}

		verify(mockStorage);
	}

	public void testExactParams() {
		int expectedKey = 42;
		String expectedValue = "forty-two";

		Map mockStorage = createMock(Map.class);
		expect(mockStorage.put(expectedKey, expectedValue)).andReturn(true);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.add(expectedKey, expectedValue);

		verify(mockStorage);
	}

	public void testFuzzyParams() {
		int expectedKey = 42;
		String expectedValue = "forty-two";

		Map mockStorage = createMock(Map.class);
		expect(mockStorage.put(gt(40), find("two"))).andReturn(true);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.add(expectedKey, expectedValue);

		verify(mockStorage);
	}

	public void testIgnoreMethodCall_withStub() {
		Map mockStorage = createMock(Map.class);
		mockStorage.clear();
		expect(mockStorage.size()).andStubReturn(42);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.logAndClear();

		verify(mockStorage);
	}

	public void testIgnoreObject() {
		Map mockStorage = createNiceMock(Map.class);
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.logAndClear();

		verify(mockStorage);
	}

	public void testInnocuousValue() {
		int expectedKey = 42;

		Storage mockStorage = createNiceMock(Storage.class);
		Logger mockLogger = createMock(Logger.class);
		mockLogger.log(isA(String.class));
		replay(mockStorage, mockLogger);

		UserCache sut = new UserCache(mockStorage, mockLogger);
		sut.getAndLog(expectedKey);

		verify(mockStorage, mockLogger);
	}

	public void testMultipleCalls() {
		Map mockStorage = createMock(Map.class);
		expect(mockStorage.size()).andReturn(42).times(2);
		mockStorage.clear();
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.conditionalLogAndClear();

		verify(mockStorage);
	}

	public void testSequenceOnOneMock() {
		Map mockStorage = createStrictMock(Map.class);
		expect(mockStorage.size()).andReturn(42);
		mockStorage.clear();
		replay(mockStorage);

		Cache sut = new Cache(mockStorage);
		sut.logAndClear();

		verify(mockStorage);
	}

	public void testSequenceOnTwoMocks() {
		int expectedKey = 42;

		IMocksControl control = createStrictControl();

		Storage mockStorage = control.createMock(Storage.class);
		Logger mockLogger = control.createMock(Logger.class);
		UserRecord mockUser = control.createMock(UserRecord.class);
		expect(mockStorage.get(expectedKey)).andReturn(mockUser);
		mockLogger.log(isA(String.class));
		control.replay();

		UserCache sut = new UserCache(mockStorage, mockLogger);
		sut.getAndLog(expectedKey);

		control.verify();
	}
}
