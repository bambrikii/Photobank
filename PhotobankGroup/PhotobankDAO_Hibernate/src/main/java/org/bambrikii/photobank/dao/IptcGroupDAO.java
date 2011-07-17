package org.bambrikii.photobank.dao;

import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.IptcGroup;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Query;

public class IptcGroupDAO extends DAOBase<IptcGroup> implements IIpticGroupDAO {

	public IptcGroupDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.photobank.dao.IIpticGroupDAO#listCategoriesWithIptcFiles()
	 */
	@Override
	public List<Category> listCategoriesWithIptcFiles() {
		return getConnector()
				.getSession()
				.createQuery(
						"select distinct c from Category c inner join c.files f inner join f.iptcGroups g inner join g.fields f where f is not null and f.id <> 0)")
				.list();
	}
}
