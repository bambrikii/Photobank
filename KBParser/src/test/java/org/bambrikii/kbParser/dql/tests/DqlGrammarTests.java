package org.bambrikii.kbParser.dql.tests;

import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.tool.GrammarAST;
import org.apache.commons.io.IOUtils;
import org.bambrikii.kbParser.dql.grammar.DqlGrammarLexer;
import org.bambrikii.kbParser.dql.grammar.DqlGrammarParser;
import org.junit.Test;

public class DqlGrammarTests {
	private String dqlString = "select Afdf, qwe, qwe12 from sfaasgasd , qweqwe23 where ( aa1 = 123 and ( aa2 like 'sf') ) group by fgsd,wer,sdfxcv";

	private class Result {
		CommonTokenStream tokens;
		DqlGrammarParser.query_return r;
	}

	private Result getReturn() throws IOException, RecognitionException {
		CharStream input = new ANTLRInputStream(
				IOUtils.toInputStream(dqlString));

		DqlGrammarLexer lex = new DqlGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		DqlGrammarParser parser = new DqlGrammarParser(tokens);
		DqlGrammarParser.query_return r = parser.query();
		Result result = new Result();
		result.r = r;
		result.tokens = tokens;
		return result;
	}

	@Test
	public void test1() throws RecognitionException, IOException {
		Result r = getReturn();
		System.out.println("tree=" + ((Tree) r.r.getTree()).toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(
				(Tree) r.r.getTree());
		nodes.setTokenStream(r.tokens);

		//
		Tree tree2 = (Tree) r.r.getTree();
		for (int i = 0; i < tree2.getChildCount(); i++) {
			String nodeText = tree2.getChild(i).getText();
			System.out.print("*" + nodeText);
		}

	}

	@Test
	public void test1recursiveTree() throws RecognitionException, IOException {
		Result r = getReturn();
		System.out.println("tree=" + ((Tree) r.r.getTree()).toStringTree());

	}

	@Test
	public void test2() throws IOException, RecognitionException {
		Result r = getReturn();
		CommonTree ast = (CommonTree) r.r.getTree();
		Convert cvt = new Convert();
		cvt.print(ast);

	}

	@Test
	public void testSelect() throws IOException, RecognitionException {
		CharStream input = new ANTLRInputStream(
				IOUtils.toInputStream("select wsdf2342341rd, sdfa5456sdfsf, A1 from"));
		DqlGrammarLexer lex = new DqlGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		DqlGrammarParser parser = new DqlGrammarParser(tokens);
		DqlGrammarParser.select_return r = parser.select();
		Convert cvt = new Convert();
		cvt.print((CommonTree) r.getTree());

		// TreeParser walker =
		GrammarAST ast = new GrammarAST();
		ast.getFirstChild();

	}

	@Test
	public void testTreePrinter() throws IOException, RecognitionException {
		Result r = getReturn();
		TreePrinter tp = new TreePrinter();
		System.out.print(tp.print((Tree) r.r.getTree(), 0));
	}
}
