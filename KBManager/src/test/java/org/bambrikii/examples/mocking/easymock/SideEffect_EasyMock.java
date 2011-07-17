package org.bambrikii.examples.mocking.easymock;

import junit.framework.TestCase;
import static org.easymock.EasyMock.*;
import org.easymock.IAnswer;

import java.util.List;

public class SideEffect_EasyMock extends TestCase {
	public void testSideEffect() {
		Populator mockPopulator = createMock(Populator.class);
		mockPopulator.populate(isA(List.class));
		expectLastCall().andAnswer(new IAnswer() {
			public Object answer() throws Throwable {
				((List) getCurrentArguments()[0]).add(new Object());
				return null;
			}
		});
		replay(mockPopulator);

		Client sut = new Client(mockPopulator);
		int actualValue = sut.callPopulateAndReturnSize();
		assertTrue(actualValue > 0);

		verify(mockPopulator);
	}
}
