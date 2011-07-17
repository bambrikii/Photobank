package org.bambrikii.kbManager.kb2.managers;

import org.bambrikii.kbManager.kb2.dao.ArtefactAsImageDAO;
import org.bambrikii.kbManager.kb2.dao.ArtefactAsTextDAO;
import org.bambrikii.kbManager.kb2.dao.ArtefactDAO;
import org.bambrikii.kbManager.kb2.model.Artefact;
import org.bambrikii.kbManager.kb2.model.ArtefactAsImage;
import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.business.pagers.PagerBuilder;

public class ArtefactManager extends ManagerBase<Artefact, ArtefactDAO> {
	private ArtefactAsTextDAO txtDao;
	private ArtefactAsImageDAO imgDao;

	public ArtefactManager(ConnectionManager connector) throws ManagerException {
		super(connector);
		txtDao = new ArtefactAsTextDAO(connector.getPersistenceConnector());
		imgDao = new ArtefactAsImageDAO(connector.getPersistenceConnector());
	}

	public void saveText(ArtefactAsText txt) {
		txtDao.saveOrUpdate(txt);
	}

	public void deleteText(ArtefactAsText txt) {
		txtDao.delete(txt);
	}

	public void saveImage(ArtefactAsImage img) {
		imgDao.saveOrUpdate(img);
	}

	public void deleteImage(ArtefactAsImage img) {
		imgDao.delete(img);
	}

	public Pager<ArtefactAsText> getArtefacts(String title, Integer currPage,
			Integer txtPagerCols, Integer txtPagerRows) {
		PagerBuilder<ArtefactAsText> b = new PagerBuilder<ArtefactAsText>(
				txtDao);
		if (title != null) {
			b.addRestrictionLike("key", title);
		}
		return b.getPager(txtPagerCols, txtPagerRows, "title", currPage);
	}

	public Pager<ArtefactAsText> getDstArtefacts(String src, String knd,
			Integer currPage, Integer txtPagerCols, Integer txtPagerRows) {
		ArtefactAsTextPagerBuilder b = new ArtefactAsTextPagerBuilder(txtDao);
		if (src != null) {
			b.srcLike(src);
		}
		if (knd != null) {
			b.kndLike(knd);
		}
		return b.getPager(txtPagerCols, txtPagerRows, "title", currPage);
	}
}
