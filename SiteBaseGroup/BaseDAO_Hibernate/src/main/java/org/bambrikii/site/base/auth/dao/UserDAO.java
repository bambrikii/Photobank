package org.bambrikii.site.base.auth.dao;

import java.util.List;

import org.bambrikii.site.base.auth.model.User;
import org.bambrikii.site.base.auth.model.UserStatusEnum;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserDAO extends DAOBase<User> implements IUserDAO {

	public UserDAO(PersistenceConnector connector) {
		super(connector);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.auth.dao.IUserDAO#getByLogin(java.lang.String)
	 */
	@Override
	public User getByLogin(String login) {
		Criteria criteria = this.getConnector().getSession()
				.createCriteria(persistentClass);
		criteria.add(Restrictions.eq("login", login));
		return (User) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.auth.dao.IUserDAO#getUsersCount()
	 */
	@Override
	public Integer getUsersCount() {
		return getCount(getCriteria());
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.auth.dao.IUserDAO#getUsersCount(java.util.List)
	 */
	@Override
	public Integer getUsersCount(List<UserStatusEnum> statuses) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.in("status", statuses));
		return getCount(criteria);
	}

	/* (non-Javadoc)
	 * @see org.bambrikii.site.base.auth.dao.IUserDAO#getUsersList(java.util.List, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<User> getUsersList(List<UserStatusEnum> statuses, String order,
			Integer start, Integer length) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.in("status", statuses));
		return getList(criteria, order, start, length);
	}
}
