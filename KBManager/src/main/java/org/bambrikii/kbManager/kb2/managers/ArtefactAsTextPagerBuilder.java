package org.bambrikii.kbManager.kb2.managers;

import org.bambrikii.kbManager.kb2.model.ArtefactAsText;
import org.bambrikii.site.base.business.pagers.PagerBuilder;
import org.bambrikii.site.base.core.dao.DAOBase;

class ArtefactAsTextPagerBuilder extends PagerBuilder<ArtefactAsText> {

	ArtefactAsTextPagerBuilder(DAOBase<ArtefactAsText> dao) {
		super(dao);
		setCriteria(dao.getCriteria());
	}

	private boolean destinationRelationIsSet = false;

	private void setDestinationRelation() {
		if (!destinationRelationIsSet) {
			setCriteria(getCriteria().createAlias("dstParents", "dstRel")
					.createAlias("dstParents.source", "dstSrc")
					.createAlias("dstParents.destination", "dstDst")
					.createAlias("dstParents.kind", "dstKnd"));
			destinationRelationIsSet = true;
		}
	}

	ArtefactAsTextPagerBuilder srcLike(String key) {
		setDestinationRelation();
		this.addRestrictionLike("dstSrc.key", key);
		return this;
	}

	ArtefactAsTextPagerBuilder kndLike(String key) {
		setDestinationRelation();
		this.addRestrictionLike("dstKnd.key", key);
		return this;
	}
}
