package org.bambrikii.photobank.mailing;

import org.bambrikii.photobank.mailing.core.managers.MailManager;
import org.bambrikii.photobank.mailing.core.model.Configuration;
import org.junit.Test;

public class MailManagerTests {
	@Test
	public void sendTest() throws Exception {
		MailManager mgr = new MailManager(new Configuration() {
			{
				setMailHost(Constants.DEFAULT_MAIL_HOST);
				setFrom(Constants.DEFAULT_MAIL_FROM);
				setRequiresAuthentication(true);
				setUsername("bambrikii@personastars.com");
				setPassword("qweasdzxc");
			}
		});
		mgr.send(Constants.DEFAULT_TEMPLATE_SUBJECT,
				Constants.DEFAULT_TEMPLATE_BODY,
				Constants.DEFAULT_CONTENT_TYPE, Constants.DEFAULT_MAIL_TO,
				Constants.DEFAULT_TEMPLATE_PARAMETERS,
				Constants.DEFAULT_TEMPLATE_KEY);
	}
}
