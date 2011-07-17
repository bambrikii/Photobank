package org.bambrikii.examples.mocking.easymock2;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class EasymockTests2 {
	@Test
	public void test1() {
		Interface1 mock1 = createMock(Interface1.class);

		expect(mock1.method1("someStr1")).andReturn("method1");
		replay();

		Class2 class2 = new Class2(mock1);
		class2.method1("someStr1");
		//Assert.assertEquals("method1", class2.getStr1());

		verify();

	}

	@Test
	public void testAtmLogin() {
		Atm mockAtm = createMock(Atm.class);

		EasyMock.expect(mockAtm.enterAccount("MyAccount")).andReturn(true);
		EasyMock.expect(mockAtm.enterPin("1234")).andReturn(true);
		EasyMock.replay(mockAtm);

		Account account = new Account("MyAccount", "1234");
		account.login(mockAtm);
		Assert.assertTrue(account.isLoggedIn());
		EasyMock.verify(mockAtm);
	}
}
