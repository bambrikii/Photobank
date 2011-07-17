package org.bambrikii.kbParser.nativeLanguages.impl;

import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.RecognitionException;
import org.bambrikii.kbParser.nativeLanguages.base.NativeLanguageManagerBase;
import org.bambrikii.kbParser.nativeLanguages.grammars.EnglishLexer;
import org.bambrikii.kbParser.nativeLanguages.grammars.EnglishParser;

public class EnglishManager extends
		NativeLanguageManagerBase<EnglishLexer, EnglishParser> {

	public EnglishParser.article_return parseArticle(String text)
			throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException,
			RecognitionException {
		EnglishParser p = parseText(text);
		EnglishParser.article_return a = p.article();
		return a;
	}
}
