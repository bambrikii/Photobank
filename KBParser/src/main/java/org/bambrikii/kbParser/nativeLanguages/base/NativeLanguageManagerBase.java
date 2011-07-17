package org.bambrikii.kbParser.nativeLanguages.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.Parser;
import org.antlr.runtime.TokenStream;

public abstract class NativeLanguageManagerBase<L, P> implements
		NativeLanguageManager<P> {

	protected Class<L> lexerClass;
	protected Class<P> parserClass;

	@SuppressWarnings("unchecked")
	public NativeLanguageManagerBase() {
		this.lexerClass = ((Class<L>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
		this.parserClass = ((Class<P>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1]);
	}

	@SuppressWarnings("unchecked")
	public P parseText(String text) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		CharStream charStream = new ANTLRStringStream(text);
		Constructor<CharStream> l = (Constructor<CharStream>) lexerClass
				.getConstructor(new Class[] { CharStream.class });
		Lexer lexer = (Lexer) l.newInstance(new Object[] { charStream });
		TokenStream tokenStream = new CommonTokenStream(lexer);
		Constructor<TokenStream> c = (Constructor<TokenStream>) parserClass
				.getConstructor(new Class[] { TokenStream.class });
		Parser parser = (Parser) c.newInstance(new Object[] { tokenStream });
		return (P) parser;
	}
}
