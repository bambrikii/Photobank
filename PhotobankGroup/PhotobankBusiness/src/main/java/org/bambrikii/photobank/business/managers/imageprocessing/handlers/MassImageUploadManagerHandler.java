package org.bambrikii.photobank.business.managers.imageprocessing.handlers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.LegalOwnerManager;
import org.bambrikii.photobank.business.managers.imageprocessing.AbstractImageManagerHandler;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageManagerEvent;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class MassImageUploadManagerHandler extends AbstractImageManagerHandler {

	public static String RUSSIAN_EVENTS__CATEGORY_ID = ".ru.psfotos.categories.Russian.Id";// 17596;
	public static String FOREIGN_EVENTS__CATEGORY_ID = ".ru.psfotos.categories.Foreign.Id";// 16845;
	public static String ARCHIVE__CATEGORY_ID = ".ru.psfotos.categories.Archive.Id";// 268;

	private Map<String, LegalOwner> legalOwners = new HashMap<String, LegalOwner>();
	private Map<Integer, Category> categories = new HashMap<Integer, Category>();

	private LegalOwnerManager legalOwnerMgr = null;
	private CategoryManager categMgr = null;
	private EventManager eventMgr = null;
	private EventManager2 eventMgr2 = null;
	private ConfigurationManager cfgMgr = null;

	private Integer russianCategId = null;
	private Integer foreignCategId = null;
	private Integer archiveCategId = null;

	public MassImageUploadManagerHandler(ManagerContainer container)
			throws ManagerException {
		setContainer(container);

		legalOwnerMgr = (LegalOwnerManager) getContainer().getManager(
				LegalOwnerManager.class);
		categMgr = (CategoryManager) getContainer().getManager(
				CategoryManager.class);
		eventMgr = (EventManager) getContainer().getManager(EventManager.class);
		eventMgr2 = (EventManager2) getContainer().getManager(
				EventManager2.class);

		cfgMgr = (ConfigurationManager) getContainer().getManager(
				ConfigurationManager.class);

		russianCategId = Integer.parseInt(cfgMgr
				.getCacheConfigValue(RUSSIAN_EVENTS__CATEGORY_ID));
		foreignCategId = Integer.parseInt(cfgMgr
				.getCacheConfigValue(FOREIGN_EVENTS__CATEGORY_ID));
		archiveCategId = Integer.parseInt(cfgMgr
				.getCacheConfigValue(ARCHIVE__CATEGORY_ID));
	}

	protected Category getBaseCateg(Integer parentCategId)
			throws ManagerException {
		Category parentCateg = null;
		if (categories.containsKey(parentCategId)) {
			parentCateg = categories.get(parentCategId);
		} else {
			parentCateg = categMgr.getById(parentCategId);
			categories.put(parentCategId, parentCateg);
		}
		return parentCateg;
	}

	protected LegalOwner getLegalOwner(String legalOwnerName) {
		if (legalOwners.containsKey(legalOwnerName)) {
			return legalOwners.get(legalOwnerName);
		} else {
			LegalOwner legalOwner = legalOwnerMgr.getByName(legalOwnerName);
			legalOwners.put(legalOwnerName, legalOwner);
			return legalOwner;
		}
	}

	protected ProcessedEventInfo getEventInfo(ImageManagerEvent evt)
			throws ManagerException {
		String author = evt.getParsedFileName().getAuthor();
		String headline = evt.getMetadataMap().get("Iptc").get("Headline");
		String caption = evt.getMetadataMap().get("Iptc")
				.get("Caption/Abstract");

		LegalOwner legalOwner = null;
		Integer parentCategId = null;
		if ("PP".equals(author)) {
			legalOwner = getLegalOwner("PicturePerfect");
			if (!(headline == null || "".equals(headline))) {
				parentCategId = foreignCategId;
			}
		} else if ("PRP".equals(author)) {
			legalOwner = getLegalOwner("PR Photos");
			if (!(headline == null || "".equals(headline))) {
				parentCategId = foreignCategId;
			}
		} else {
			legalOwner = getLegalOwner("PersonaStars");
			if (!(headline == null || "".equals(headline))) {
				parentCategId = russianCategId;
			}
		}

		if (parentCategId == null) {
			parentCategId = archiveCategId;
		}

		ProcessedEventInfo pei = new ProcessedEventInfo();
		pei.setHeadline(headline);
		pei.setCaption(caption);
		pei.setLegalOwner(legalOwner);
		if (!(headline == null || "".equals(headline))) {
			Date date;
			try {
				date = getCategoryDate(evt);
			} catch (ParseException ex) {
				throw new ManagerException(
						"Failed to parse date from filename.", ex);
			}
			pei.setParentCategory(checkEvent(headline, "", date,
					getBaseCateg(parentCategId)));
		} else {
			pei.setParentCategory(getBaseCateg(parentCategId));
		}

		return pei;
	}

	protected Event checkEvent(String headline, String caption, Date date,
			Category baseCateg) {
		List<Event> list = eventMgr2.getList(headline, caption, date,
				baseCateg, "insertionTime DESC", null);
		if (list.size() > 0) {
			return list.get(0);
		}

		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		Event event = new Event();
		event.setParent(baseCateg);
		event.setActive(true);
		event.setDescription(headline);
		event.setText(caption);
		event.setInsertionTime(date);
		event.setCategoryType(CategoryTypeEnum.SEARCH_RESTRICTED);
		event.setOrder(Integer.parseInt(df.format(date)));
		eventMgr.saveOrUpdate(event);
		return event;
	}

	public Object saveImageComplete(ImageManagerEvent evt)
			throws ManagerException {
		ProcessedEventInfo pei = getEventInfo(evt);
		String keyStr = getCategoryTitle(pei.getLegalOwner(), evt);

		Category parentCateg = pei.getParentCategory();

		Category categ = checkCategory(keyStr, parentCateg);
		File file = checkFile(keyStr, evt.getParsedFileName()
				.getGeneratedName(), categ);
		if (parentCateg.getCoverFile() == null) {
			parentCateg.setCoverFile(file);
			categMgr.saveOrUpdate(parentCateg);
		}
		try {
			checkIptc(file, evt.getMetadataMap());
		} catch (Exception ex) {
			// TODO: logging here required...
		}
		return file;
	}
}
