package org.bambrikii.photobank.mailing.core.model;

public class Configuration {

	private String mailHost;
	private String from;
	private Boolean requiresAuthentication = false;
	private String username;
	private String password;
	private String mailTransportProtocol = "smtp";

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getMailHost() {
		return mailHost;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getFrom() {
		return from;
	}

	public void setRequiresAuthentication(Boolean requiresAuthentication) {
		this.requiresAuthentication = requiresAuthentication;
	}

	public Boolean getRequiresAuthentication() {
		return requiresAuthentication;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setMailTransportProtocol(String mailTransportProtocol) {
		this.mailTransportProtocol = mailTransportProtocol;
	}

	public String getMailTransportProtocol() {
		return mailTransportProtocol;
	}
}
