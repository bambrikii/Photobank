package org.bambrikii.kbParser.nativeLanguages.tests;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.bambrikii.kbParser.nativeLanguages.grammars.TLexer;
import org.bambrikii.kbParser.nativeLanguages.grammars.TParser;

public class TTest {
	public static void main(String args[]) throws Exception {
		TLexer lex = new TLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		TParser parser = new TParser(tokens);
		TParser.startRule_return r = parser.startRule(); // launch parsing
		// print tree if building trees
		if (r != null)
			System.out.println(((CommonTree) r.tree).toStringTree());
	}
}