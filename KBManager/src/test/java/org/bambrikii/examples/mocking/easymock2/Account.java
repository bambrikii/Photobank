package org.bambrikii.examples.mocking.easymock2;

public class Account {
	private String login = null;
	private String pin = null;
	private boolean isLoggedIn = false;

	public Account(String login, String pin) {
		this.login = login;
		this.pin = pin;
	}

	public void login(Atm mockAtm) {
		isLoggedIn = mockAtm.enterAccount(login);
		isLoggedIn &= mockAtm.enterPin(pin);
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

}
