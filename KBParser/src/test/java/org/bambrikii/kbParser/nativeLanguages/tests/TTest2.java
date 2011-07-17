package org.bambrikii.kbParser.nativeLanguages.tests;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.bambrikii.kbParser.nativeLanguages.grammars.TLexer;
import org.bambrikii.kbParser.nativeLanguages.grammars.TParser;
import org.junit.Test;

public class TTest2 {
	@Test
	public void mainTest1() {
		TLexer lex = new TLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);

		TParser parser = new TParser(tokens); // created from T.g
		TParser.startRule_return r = parser.startRule(); // launch parsing
		if (r != null)
			System.out.println(((CommonTree) r.tree).toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree) r.tree);
		nodes.setTokenStream(tokens);
		TP walker = new TP(nodes); // created from TP.g
		TP.startRule_return r2 = walker.startRule();
		CommonTree rt = ((CommonTree) r2.tree);
		// if tree parser constructs trees
		if (rt != null)
			System.out.println(((CommonTree) r2.tree).toStringTree());
	}
}
