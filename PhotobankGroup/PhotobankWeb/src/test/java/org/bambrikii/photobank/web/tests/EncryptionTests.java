package org.bambrikii.photobank.web.tests;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class EncryptionTests {
	@Test
	public void sha1Test() throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		String str = "f81k37";
		MessageDigest mdEnc = MessageDigest.getInstance("SHA-1");
		mdEnc.update(str.getBytes("UTF-8"));
		String bigInt = new BigInteger(1, mdEnc.digest()).toString(16);
		System.out.printf("%s", bigInt);
	}
}
