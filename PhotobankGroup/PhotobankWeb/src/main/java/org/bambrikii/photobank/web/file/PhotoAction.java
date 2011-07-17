package org.bambrikii.photobank.web.file;

import java.util.List;

import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.news.model.News;
import org.bambrikii.photobank.web.file.beans.PhotoBean;
import org.bambrikii.photobank.web.news.beans.NewsBean;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.struts2.core.SiteBasePagerAction;
import org.bambrikii.site.base.struts2.core.SiteBaseSecurityAware;
import org.bambrikii.site.base.struts2.core.WebException;

@SiteBaseSecurityAware
public class PhotoAction extends SiteBasePagerAction<Pager<File>> {
	private static final long serialVersionUID = 6038557955382661071L;
	private PhotoBean photoBean;
	private NewsBean newsBean;
	private String searchString;
	private List<News> topNews;

	public PhotoBean getPhotoBean() {
		return photoBean;
	}

	public void setPhotoBean(PhotoBean photoBean) {
		this.photoBean = photoBean;
	}

	public void setNewsBean(NewsBean newsBean) {
		this.newsBean = newsBean;
	}

	public NewsBean getNewsBean() {
		return newsBean;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public void setTopNews(List<News> topNews) {
		this.topNews = topNews;
	}

	public List<News> getTopNews() {
		return topNews;
	}

	public String preview() {
		return SUCCESS;
	}

	public String input() {
		return SUCCESS;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String find() throws WebException {
		try {
			setPager(getPhotoBean().getPhotos(searchString,
					"weight DESC, modificationTime DESC", getRequestedPage(),
					null));
			return SUCCESS;
		} catch (Exception ex) {
			throw new WebException("search failed", ex);
		}
	}

	public String latest() throws Exception {
		Pager<File> pager = new Pager<File>(4, 5);
		pager.setCurrPage(getRequestedPage());
		setPager(getPhotoBean().getLatest(pager, "modificationTime DESC", 75));
		setTopNews(getNewsBean().getTopNews());
		return "latest";
	}

	public void validate() {
		// TODO: validation should be avoided for latest action method
		/*
		 * if (getSearchString() == null || "".equals(getSearchString())) {
		 * addFieldError("searchString", "photos.searchString.invalid"); }
		 */
	}
}
