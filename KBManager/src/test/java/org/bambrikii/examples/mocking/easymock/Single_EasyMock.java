package org.bambrikii.examples.mocking.easymock;

import org.bambrikii.examples.mocking.jmock.SomeInterface;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

public class Single_EasyMock extends TestCase {
	public void testSome() {
		SomeInterface mockSome = createMock(SomeInterface.class);
		// Program the mock here
		replay(mockSome);

		// Setup SUT with mock and exercise here

		verify(mockSome);
	}
}
