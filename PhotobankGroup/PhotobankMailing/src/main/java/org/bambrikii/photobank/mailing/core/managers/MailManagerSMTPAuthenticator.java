package org.bambrikii.photobank.mailing.core.managers;

import javax.mail.PasswordAuthentication;

class MailManagerSMTPAuthenticator extends javax.mail.Authenticator {
	private String username;
	private String password;

	public MailManagerSMTPAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
}
