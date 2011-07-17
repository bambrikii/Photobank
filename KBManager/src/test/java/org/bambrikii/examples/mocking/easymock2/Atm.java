package org.bambrikii.examples.mocking.easymock2;

public interface Atm {
	boolean enterAccount(String accountNumber);

	boolean enterPin(String pin);

	boolean enterWithdrawalAmount(int dollars);
}