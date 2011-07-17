package org.bambrikii.photobank.model.tests;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.bambrikii.photobank.news.dao.NewsDAO;
import org.bambrikii.photobank.news.dao.NewsLocalizedDAO;
import org.bambrikii.photobank.news.model.News;
import org.bambrikii.photobank.news.model.NewsLocalized;
import org.bambrikii.photobank.news.model.NewsStatusEnum;
import org.bambrikii.photobank.tests.core.DAOTestBase;
import org.bambrikii.site.base.core.dao.DAOException;
import org.bambrikii.site.base.dao.LanguageDAO;
import org.bambrikii.site.base.model.Language;
import org.junit.Before;
import org.junit.Test;

public class NewsTests extends DAOTestBase<NewsDAO> {
	private LanguageDAO langDao;
	private NewsLocalizedDAO newsLocalizedDao;

	@Before
	public void before() throws DAOException {
		super.before();
		langDao = new LanguageDAO(cn);
		newsLocalizedDao = new NewsLocalizedDAO(cn);
	}

	@Test
	public void listTest() {
		List<News> news = dao.getList();
		for (News news1 : news) {
			System.out.printf("%s, %s, %s", news1.getId(), news1.getTitle(),
					news1.getContent());
		}
	}

	@Test
	public void crudTest() throws Exception {
		News news = new News();
		Date dt = Calendar.getInstance().getTime();
		news.setTime(dt);
		news.setModificationTime(Calendar.getInstance().getTime());
		news.setTitle("News " + dt);
		news.setContent("News content " + dt);
		news.setStatus(NewsStatusEnum.PENDING);

		cn.beginTransaction();
		try {
			dao.saveOrUpdate(news);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}
		Assert.assertTrue(news.getId() > 0);
		news.setTitle("News updated " + dt);

		cn.beginTransaction();
		try {
			List<Language> langs = langDao.getList();
			for (Language lang : langs) {
				System.out.printf("Localization: %s\n", lang.getName());
				NewsLocalized nl1 = new NewsLocalized();
				nl1.setTitle(news.getTitle() + lang.getName());
				nl1.setContent(news.getContent() + lang.getName());
				// nl1.setNews(news);
				// nl1.setLanguage(lang);
				news.getLocalizations().put(lang.getId(), nl1);
				// newsLocalizedDao.saveOrUpdate(nl1);
			}
			dao.saveOrUpdate(news);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
			throw ex;
		}

		dao.refresh(news);

		for (Integer nlKey : news.getLocalizations().keySet()) {
			NewsLocalized nl2 = news.getLocalizations().get(nlKey);
			System.out.printf("	Localization: %s, %s, %s\n", nlKey,
					nl2.getId(), nl2.getContent());
		}

		cn.beginTransaction();
		try {
			dao.saveOrUpdate(news);
			cn.commitTransaction();
		} catch (Exception ex) {
			cn.rollbackTransaction();
		}

		cn.beginTransaction();
		dao.delete(news);
		cn.commitTransaction();
	}
}
