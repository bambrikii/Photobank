package org.bambrikii.kbManager.kb2.dao;

import org.bambrikii.kbManager.kb2.model.Artefact;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;

public class ArtefactDAO extends DAOBase<Artefact> {

	public ArtefactDAO(PersistenceConnector connector) {
		super(connector);
	}
}
