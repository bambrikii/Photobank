package org.bambrikii.kbParser.nativeLanguages.tests;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.TokenRewriteStream;
import org.bambrikii.kbParser.nativeLanguages.grammars.T2Lexer;
import org.junit.Test;

public class T2Tests {
	@Test
	public void test1() throws IOException {
		System.out.printf("%s", System.getProperties().getProperty("user.dir"));
		ANTLRFileStream fs = new ANTLRFileStream("target\\classes\\"
				+ "T2TestFile.txt");

		T2Lexer lex = new T2Lexer(fs);

		@SuppressWarnings("unused")
		TokenRewriteStream tokens = new TokenRewriteStream(lex);

	}
}
