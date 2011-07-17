package org.bambrikii.kbManager.parser.managers;

import org.bambrikii.kbManager.parser.dao.GrammarDAO;
import org.bambrikii.kbManager.parser.model.Grammar;
import org.bambrikii.kbManager.parser.model.Knowledge;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class KBParserManager extends ManagerBase<Grammar, GrammarDAO> {
	public KBParserManager(ConnectionManager connector) throws ManagerException {
		super(connector);
	}

	private GrammarDAO _grammarDao;

	public Grammar getGrammar(String name) {
		return _grammarDao.getByName(name);
	}

	public void saveGrammar(Grammar grammar) {
		_grammarDao.saveOrUpdate(grammar);
	}

	public Knowledge parse(Grammar grammar, String text) {
		// TODO: Implement parsing to Knowledge entity
		return null;
	}
}
