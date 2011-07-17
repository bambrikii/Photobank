package org.bambrikii.kbManager.parser.tests;

import java.util.List;

import org.bambrikii.kbManager.parser.dao.GrammarDAO;
import org.bambrikii.kbManager.parser.managers.KBParserManager;
import org.bambrikii.kbManager.parser.model.Grammar;
import org.bambrikii.site.base.business.tests.core.ManagerTestBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.junit.Test;

public class ModelTests1 extends ManagerTestBase<KBParserManager> {
	@Test
	public void testGrammarObject() throws Exception {
		PersistenceConnector cn = new PersistenceConnector();
		cn.openSession();
		GrammarDAO grammarDao = new GrammarDAO(cn);
		List<Grammar> grammars = grammarDao.getList();
		for (Grammar g : grammars) {
			System.out.printf("\n%d\n%s\n%s\n\n", g.getId(), g.getName(),
					g.getRules());
		}
		cn.closeSession();
		cn = null;
	}

	@Test
	public void testSetSampleGRules() throws Exception {
		container.begin();
		String grammarName = "Test.g";
		try {
			Grammar g = mgr.getGrammar(grammarName);
			if (g == null) {
				g = new Grammar();
				g.setName(grammarName);
			}
			g.setRules("					grammar Sample;\n" + "\n" + "					options {\n"
					+ "					  language = Java;\n" + "					}\n" + "\n" + "\n"
					+ "					@header {\n" + "						package a.b.c;\n"
					+ "					}\n" + "\n" + "					@lexer::header {\n"
					+ "						package a.b.c;\n" + "					}\n" + "\n"
					+ "					rule: IDENT+ ;\n" + "\n"
					+ "					IDENT : 'a'..'z'+ ;\n"
					+ "					WS : ' '+ { $channel = HIDDEN; };\n"

			);
			mgr.saveGrammar(g);
			container.commit();
		} catch (Exception ex) {
			container.rollback();
			throw ex;
		}
	}

	@Test
	public void genericTest1() throws SecurityException, NoSuchFieldException,
			InstantiationException, IllegalAccessException {
		/*
		 * Field field = this.getClass().getField("type");
		 * System.out.println(field.getGenericType()); // T
		 * System.out.println(field.getType()); // class java.lang.Object
		 * System.out.println(field.getDeclaringClass());
		 */

		Generic<Grammar> gs = new Generic<Grammar>();

		System.out.printf("%s\n", gs.classToString());
		System.out.printf("%s\n", gs.toString());

		// Grammar str = gs.getInstance();
		// System.out.printf(str.toString());
	}

	@Test
	public void genericTest2() {
		Generic1 gs = new Generic1();
		gs.info();
	}

	@Test
	public void testGenericsErasure() {
		Class1<String> obj1 = new Class1<String>("obj1");
		Class1<Integer> obj2 = new Class1<Integer>("obj2");
		// in Java obj1.property1, obj2.property1 are equal because of generic
		// erasure, in .NET they differ
		System.out.printf("%s %s", obj1.getProperty1(), obj2.getProperty1());
	}
}
