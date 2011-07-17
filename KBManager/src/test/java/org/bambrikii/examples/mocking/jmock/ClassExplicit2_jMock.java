package org.bambrikii.examples.mocking.jmock;

import junit.framework.TestCase;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

public class ClassExplicit2_jMock extends TestCase {
	private Mockery context;

	protected void setUp() throws Exception {
		super.setUp();

		context = new Mockery();
		context.setImposteriser(ClassImposteriser.INSTANCE);
	}

	protected void runTest() throws Throwable {
		super.runTest();
		context.assertIsSatisfied();
	}

	public void testSome() {
		SomeClass mockSome = context.mock(SomeClass.class);
		// Program the mocks here

		// Setup SUT with mocks and exercise here
	}
}
