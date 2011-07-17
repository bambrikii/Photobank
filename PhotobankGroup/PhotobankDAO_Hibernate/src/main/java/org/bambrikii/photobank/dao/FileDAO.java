package org.bambrikii.photobank.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.site.base.core.dao.DAOBase;
import org.bambrikii.site.base.persistence.GroupResultTransformClassAliasSets;
import org.bambrikii.site.base.persistence.GroupResultTransformer;
import org.bambrikii.site.base.persistence.MySQLMatchAgainstCriterion;
import org.bambrikii.site.base.persistence.MySQLMatchAgainstCriterion.Mode;
import org.bambrikii.site.base.persistence.MySQLMatchAgainstProjection;
import org.bambrikii.site.base.persistence.PersistenceConnector;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class FileDAO extends DAOBase<File> implements IFileDAO {

	public FileDAO(PersistenceConnector connector) {
		super(connector);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getList(org.bambrikii.photobank.
	 * model.Category)
	 */
	@Override
	public List<File> getList(Category parent) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("category", parent));
		criteria.addOrder(Order.desc("modificationTime"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFromSubCategories(org.bambrikii
	 * .photobank.model.Category, java.util.Date, java.util.Date)
	 */
	@Override
	public List<File> getFromSubCategories(Category category, Date from,
			Date till) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.and(Restrictions.eq("category", category),
				Restrictions.and(Restrictions.gt("modificationTime", from),
						Restrictions.lt("modificationTime", till))));
		criteria.addOrder(Order.desc("modificationTime"));
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getList(org.bambrikii.photobank.
	 * model.Category, java.lang.String)
	 */
	@Override
	public List<File> getList(Category parent, String fileName) {
		Criteria criteria = getConnector().getSession().createCriteria(
				persistentClass);
		criteria.add(Restrictions.eq("category", parent));
		if (fileName != null && !"".equals(fileName)) {
			criteria.add(Restrictions.like("fileName", fileName));
		}
		return getList(criteria, "modificationTime DESC", 0, 0);
	}

	// Pager for Events
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFilesCount(org.bambrikii.photobank
	 * .model.Event)
	 */
	@Override
	public int getFilesCount(Event event) {
		Criteria criteria = getFilesCriteria(event);
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	protected Criteria getFilesCriteria(Event event) {
		Criteria criteria = getConnector().getSession().createCriteria(
				File.class);
		criteria.createAlias("category", "categ1");
		criteria.add(Restrictions.eq("categ1.parent", event));
		criteria.add(Restrictions.eq("categ1.active", true));
		criteria.add(Restrictions.eq("active", true));
		return criteria;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFiles(org.bambrikii.photobank
	 * .model.Event, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<File> getFiles(Event event, String order, Integer start,
			Integer length) {
		Criteria criteria = getFilesCriteria(event);
		return getList(criteria, order, start, length);
	}

	// Pager for Categories
	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFilesCount(org.bambrikii.photobank
	 * .model.Category)
	 */
	@Override
	public int getFilesCount(Category category) {
		Criteria criteria = getFilesCriteria(category);
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	protected Criteria getFilesCriteria(Category category) {
		Criteria criteria = getConnector().getSession().createCriteria(
				File.class);
		criteria.add(Restrictions.eq("category", category));
		criteria.add(Restrictions.eq("active", true));
		return criteria;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFiles(org.bambrikii.photobank
	 * .model.Category, java.lang.String, int, int)
	 */
	@Override
	public List<File> getFiles(Category category, String order, int start,
			int length) {
		Criteria criteria = getFilesCriteria(category);
		return getList(criteria, order, start, length);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getFindFullTextCriteria(java.lang
	 * .String)
	 */
	public Criteria getFindFullTextCriteria(String searchString) {
		Criteria criteria = getConnector().getSession().createCriteria(
				File.class, "file1");
		criteria.createAlias("category", "categ1");
		if (searchString != null) {
			criteria.add(new MySQLMatchAgainstCriterion("categ1.description",
					searchString, Mode.BOOLEAN));
		}
		criteria.add(Restrictions.eq("categ1.active", true));
		criteria.add(Restrictions.eq("file1.active", true));

		return criteria;
	}

	// FullText search
	/*
	 * (non-Javadoc)
	 *
	 * @see org.bambrikii.photobank.dao.IFileDAO#find(java.lang.String,
	 * java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<File> find(String searchString, String sortOrder,
			Integer start, Integer length) {

		Criteria criteria = getFindFullTextCriteria(searchString);

		Projection fulltextPrj = new MySQLMatchAgainstProjection(
				"categ1.description", searchString, Mode.QUERY_EXPANSION);

		ProjectionList prjs = Projections.projectionList();

		prjs.add(Projections.id().as("id"));
		prjs.add(Projections.property("file1.description").as("description"));
		prjs.add(Projections.property("file1.category").as("category"));
		prjs.add(Projections.property("file1.fileName").as("fileName"));
		prjs.add(Projections.property("file1.modificationTime").as(
				"modificationTime"));
		prjs.add(Projections.property("file1.active").as("active"));
		prjs.add(Projections.property("file1.order").as("order"));

		prjs.add(fulltextPrj, "weight");

		criteria.setProjection(prjs);
		criteria.setResultTransformer(new GroupResultTransformer(
				new LinkedList<GroupResultTransformClassAliasSets>() {
					private static final long serialVersionUID = 1L;
					{
						add(new GroupResultTransformClassAliasSets(
								FileFullTextWeight.class,
								new HashSet<String>() {
									private static final long serialVersionUID = 7698098532795698004L;
									{
										add("id");
										add("description");
										add("category");
										add("fileName");
										add("modificationTime");
										add("active");
										add("order");
										add("weight");
									}
								}));
					}
				}));

		setOrder(criteria, sortOrder/* "weight DESC, modificationTime DESC" */);

		// criteria.addOrder(Order.desc("weight"));
		// criteria.addOrder(Order.desc("modificationTime"));
		// return criteria.list();
		setLimit(criteria, start, length);
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bambrikii.photobank.dao.IFileDAO#findCount(java.lang.String)
	 */
	@Override
	public Integer findCount(String searchString) {
		Criteria criteria = getFindFullTextCriteria(searchString);
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bambrikii.photobank.dao.IFileDAO#findCount()
	 */
	@Override
	public Integer findCount() {
		Criteria criteria = getFindFullTextCriteria(null);
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bambrikii.photobank.dao.IFileDAO#find(java.lang.String,
	 * java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<File> find(String order, Integer start, Integer length) {
		Criteria criteria = getFindFullTextCriteria(null);
		return getList(criteria, order, start, length);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.bambrikii.photobank.dao.IFileDAO#getTopNFiles(java.lang.Integer)
	 */
	@Override
	public List<File> getTopNFiles(Integer n) {
		// TODO: Avoid explicit table names in code!
		/*
		 * Query q =
		 * getConnector().getSession().createQuery("select  f1.id, count(oi1.id)"
		 * + " from Order o1" + " join OrderItem oi1" + " join File f1" +
		 * " group by f1.id," + " order by count(tf1.id) desc"); q.list();
		 */
		SQLQuery q = (SQLQuery) getConnector()
				.getSession()
				.createSQLQuery(
						" select f1.id "
								+ " from site_order so1 "
								+ " inner join _photobank_order o1 on so1.id = o1.order_id "
								+ " inner join site_order_item soi1 on so1.id = soi1.order_id "
								+ " inner join _photobank_order_item oi1 on soi1.id = oi1.order_item_id "
								+ " inner join _photobank_files f1 on f1.id = oi1.file_id "
								+ " group by f1.id "
								+ " order by count(oi1.id) desc" + " limit :n ")
				.setParameter("n", n);
		List l = q.list();
		l.add(null);
		Criteria crit = getCriteria().add(Restrictions.in("id", l));
		return crit.list();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.bambrikii.photobank.dao.IFileDAO#getTopNFilesByCounter(java.lang.
	 * Integer)
	 */
	@Override
	public List<File> getTopNFilesByCounter(Integer n) {
		Query q = getConnector()
				.getSession()
				.createQuery(
						" select f1 as n1 "
								+ " from FilePreviewCounter fpc join fpc.file f1 "
								+ " group by f1 " + " order by count(fpc) desc")
				.setMaxResults(n);
		return q.list();
	}
}
