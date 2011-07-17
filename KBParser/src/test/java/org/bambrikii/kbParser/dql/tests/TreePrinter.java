package org.bambrikii.kbParser.dql.tests;

import org.antlr.runtime.tree.Tree;

public class TreePrinter {
	StringBuilder sb = new StringBuilder();

	public StringBuilder print(Tree tree, int offset) {
		for (int i = 0; i < tree.getChildCount(); i++) {
			Tree childTree = (Tree) tree.getChild(i);
			for (int j = 0; j < offset; j++) {
				sb.append("\t");
			}
			sb.append(childTree.getText() + " (" + childTree.getType() + ")");
			sb.append("\n");
			print(childTree, offset + 1);
		}
		return sb;
	}
}
