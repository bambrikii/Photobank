package org.bambrikii.kbParser.dql.tests;

import org.antlr.runtime.tree.CommonTree;

public class Convert {
	private static String body;

	public void print1(CommonTree ast, int depth) {
		String txt = ast.getToken().getText();
		if ("select".equals(txt)) {
			// body += header;
			// printChildren(ast, txt, false);
			// body += footer;
			body += "select:" + depth;
			printChildren(ast, txt, depth + 1);
		} else if ("from".equals(txt)) {
			body += "from:" + depth;
			printChildren(ast, txt, depth + 1);
		} else if ("where".equals(txt)) {
			body += "where:" + depth;
			printChildren(ast, txt, depth + 1);
			// body += ";\r\n";
		} else {
			body += " [" + txt + ":" + depth + "] ";
		}
	}

	public void print(CommonTree ast) {
		printChildren(ast, " ", 0);
		System.out.println(body);
	}

	public void printChildren(CommonTree ast, String delim, int depth) {
		if (ast.getChildren() == null) {
			return;
		}

		int num = ast.getChildren().size();

		for (int i = 0; i < num; ++i) {
			CommonTree d = (CommonTree) (ast.getChildren().get(i));
			print1(d, depth);
			if (i < num - 1) {
				// body += delim;
			}
		}

	}
}
