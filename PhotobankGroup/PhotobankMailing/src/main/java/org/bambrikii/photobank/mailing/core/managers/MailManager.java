package org.bambrikii.photobank.mailing.core.managers;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.bambrikii.photobank.mailing.core.exceptions.PhotobankMailingException;
import org.bambrikii.photobank.mailing.core.model.Configuration;
import org.bambrikii.photobank.mailing.templates.managers.TemplateEngine;
import org.bambrikii.photobank.mailing.templates.managers.VelocityTemplateEngine;

public class MailManager {
	private Configuration cfg;
	private TemplateEngine templateEngine;

	private final String defaultCharset = "UTF-8";

	public MailManager(Configuration cfg) {
		this.cfg = cfg;
		this.templateEngine = new VelocityTemplateEngine();
	}

	public void send(String subject, String body, String contentType,
			String to, Map<String, Object> params, String key)
			throws PhotobankMailingException {

		send(subject, body, contentType, to, null, params, key);
	}

	public void send(String subject, String body, String contentType,
			String to, List<DataSource> attachments,
			Map<String, Object> params, String key)
			throws PhotobankMailingException {

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", cfg.getMailHost());

			Authenticator auth = null;

			if (cfg.getRequiresAuthentication()) {
				props.put("mail.transport.protocol",
						cfg.getMailTransportProtocol());
				props.put("mail.smtp.auth", "true");
				auth = new MailManagerSMTPAuthenticator(cfg.getUsername(),
						cfg.getPassword());
			}

			Session session = Session.getInstance(props, auth);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(cfg.getFrom()));
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(to) });
			message.setSubject(templateEngine.evaluate(key, subject, params),
					defaultCharset);
			String messageContent = templateEngine.evaluate(key, body, params);
			String contentType3 = "plain";
			if (contentType != null) {
				String[] contentType2 = contentType.split("/");
				contentType3 = contentType2.length > 1 ? contentType2[1]
						: contentType2[0];
			}

			if (attachments != null && attachments.size() > 0) {
				MimeBodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(messageContent, defaultCharset,
						contentType3);
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				for (DataSource datasource : attachments) {
					messageBodyPart = new MimeBodyPart();
					messageBodyPart.setDataHandler(new DataHandler(datasource));
					messageBodyPart.setFileName(datasource.getName());
					multipart.addBodyPart(messageBodyPart);
				}
				message.setContent(multipart);
			} else {
				message.setText(messageContent, defaultCharset, contentType3);
			}

			Transport.send(message);

		} catch (Exception ex) {
			throw new PhotobankMailingException("Failed to send e-mail", ex);
		}
	}
}
