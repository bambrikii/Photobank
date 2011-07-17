package org.bambrikii.photobank.mailing;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Assert;
import org.junit.Test;

public class BasicMailingTests {

	public static String host = "psfotos.ru";
	public static String from = "bambrikii@psfotos.ru";
	public static String to = "shurik-a3-2@yandex.ru";
	public static String fileAttachment = System.getProperty("user.dir")
			+ "/src/main/java/org/bambrikii/photobank/mailing/core/managers/MailManager.java";

	public static String smtpUsername = "bambrikii@psfotos.ru";
	public static String smtpPassword = "qweasdzxc";

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(smtpUsername, smtpPassword);
		}
	}

	protected Session getDefaultSmtpSession() {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "psfotos.ru");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);
		return session;
	}

	@Test
	public void sendTest1() throws AddressException, MessagingException {

		Session session = getDefaultSmtpSession();

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("bambrikii@psfotos.ru"));
		message.setRecipients(Message.RecipientType.TO,
				new InternetAddress[] { new InternetAddress(
						"shurik-a3-2@yandex.ru") });
		message.setSubject("Subject 1");
		message.setContent("Mail body ... ", "text/plain");

		Transport.send(message);

	}

	@Test
	public void contentTypeTest1() {
		System.out.printf("%s\n", Constants.DEFAULT_CONTENT_TYPE);
		Assert.assertEquals("Value is wrong.", "text/plain",
				Constants.DEFAULT_CONTENT_TYPE);
	}

	@Test
	public void setMailWithAttachmentTest() throws AddressException,
			MessagingException {

		// Get session
		Session session = getDefaultSmtpSession();

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Hello JavaMail Attachment");

		// create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();

		// fill message
		messageBodyPart.setText("Hi");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(fileAttachment);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(fileAttachment);
		multipart.addBodyPart(messageBodyPart);

		// Put parts in message
		message.setContent(multipart);

		// Send the message
		Transport.send(message);

	}

	@Test
	public void setMailWithAttachmentTest2() throws AddressException,
			MessagingException {

		// Get session
		Session session = getDefaultSmtpSession();

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Hello JavaMail Attachment");

		// create the message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();

		// fill message
		messageBodyPart.setText("Hi");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(fileAttachment);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(fileAttachment);
		multipart.addBodyPart(messageBodyPart);

		// Put parts in message
		message.setContent(multipart);

		// Send the message
		Transport.send(message);

	}
}
