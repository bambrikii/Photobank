package org.bambrikii.examples.mocking.easymock;

public class Inherited_EasyMock extends EasyMockTestCase {
	public void testSome() {
		SimpleInterface mockSome = createMock(SimpleInterface.class);
		// Program the mocks here
		replay();

		// Setup SUT with mocks and exercise here
	}
}
