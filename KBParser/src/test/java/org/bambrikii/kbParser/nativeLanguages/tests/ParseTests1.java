package org.bambrikii.kbParser.nativeLanguages.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.bambrikii.kbParser.nativeLanguages.grammars.EnglishLexer;
import org.bambrikii.kbParser.nativeLanguages.grammars.EnglishParser;
import org.bambrikii.kbParser.nativeLanguages.impl.EnglishManager;
import org.junit.Test;

public class ParseTests1 {
	@Test
	public void parseEnglish() throws SecurityException,
			IllegalArgumentException, NoSuchMethodException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, RecognitionException {
		String text = "lr  specification meta language "
				+ "as such, the semantic and syntactic context lookahead could be hoisted into other rules. in antlr, predicates are not hoisted outside of their enclosing.";
		EnglishManager em = new EnglishManager();
		EnglishParser.article_return a = em.parseArticle(text);

		System.out.println(a);
		System.out.println("ok!");
		EnglishParser val = em.parseText(text);

		EnglishLexer lex = new EnglishLexer(new ANTLRStringStream(text));

		TokenRewriteStream tokens = new TokenRewriteStream(lex);
		printTokens(tokens.getTokens());

	}

	public void printTokens(List<Token> tokens) {
		for (Token token : tokens) {
			System.out
					.printf("%s %s\n", token.getTokenIndex(), token.getText());
		}
	}
}
