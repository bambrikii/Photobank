package org.bambrikii.site.base.auth.dao;

import java.util.List;

import org.bambrikii.site.base.auth.model.Privilege;
import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PrivilegeDAO extends DAOBase<Privilege> implements IPrivilegeDAO {

	public PrivilegeDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.auth.dao.IPrivilegeDAO#getRolesList(org.bambrikii.site.base.auth.model.User)
	 */
	@Override
	public List<String> getRolesList(User user) {
		Criteria crit = getConnector()
				.getSession()
				.createCriteria(persistentClass)
				.createAlias("groups", "grp1")
				.createAlias("grp1.users", "usr1")
				.add(Restrictions.eq("usr1.id", user.getId()))
				.setProjection(
						Projections.distinct(Projections.projectionList().add(
								Projections.property("name"))));
		return crit.list();
	}
}
