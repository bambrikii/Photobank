package org.bambrikii.photobank.business.managers.imageprocessing;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.managers.ImageMetadataManager;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.CategoryTypeEnum;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.IptcField;
import org.bambrikii.photobank.model.IptcGroup;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public abstract class AbstractImageManagerHandler implements
		ImageManagerListener {
	public static final String ZERO_TIME = "00";
	public static final Integer YEAR_LIMIT = 100;

	private ManagerContainer container;

	protected void setContainer(ManagerContainer container) {
		this.container = container;
	}

	public ManagerContainer getContainer() {
		return container;
	}

	protected String getCategoryTitle(LegalOwner legalOwner,
			ImageManagerEvent evt) throws ManagerException {
		String keyStr = null;
		String[] keys = legalOwner.getIptcMarker2Name().split("\\.");
		if (evt.getMetadataMap().containsKey(keys[0])
				&& evt.getMetadataMap().get(keys[0]).containsKey(keys[1])) {
			keyStr = evt.getMetadataMap().get(keys[0]).get(keys[1]);
		}
		if (keyStr == null || "".equals(keyStr)) {
			throw new ManagerException("No caption found.");
		}
		int n = keyStr.indexOf(" - Keywords:");
		if (n > 0) {
			keyStr = keyStr.substring(0, n);
		}
		return keyStr;
	}

	// Protected methods
	protected Category checkCategory(String keyStr, Category parentCategory)
			throws ManagerException {
		Category newCateg = null;

		CategoryManager categMgr = (CategoryManager) getContainer().getManager(
				CategoryManager.class);
		List<Category> newCategs = categMgr.getList(parentCategory, keyStr,
				null);
		switch (newCategs.size()) {
		// Creating new category when none found
		case 0:
			newCateg = new Category();
			newCateg.setParent(parentCategory);
			break;
		// Updating category in case only one is found
		case 1:
			newCateg = newCategs.get(0);
			break;
		// Throwing exception if more than one found
		default:
			throw new ManagerException(
					"There is more than one category of name " + keyStr);
		}

		newCateg.setParent(parentCategory);
		newCateg.setDescription(keyStr);
		newCateg.setActive(true);
		newCateg.setCategoryType(CategoryTypeEnum.DEFAULT);
		newCateg.setOrder(0); // TODO: order should be evaluated for sorting in
								// search

		getContainer().begin();
		try {
			categMgr.saveOrUpdate(newCateg);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new ManagerException("Failed to save Category data.", ex);
		}
		return newCateg;
	}

	protected File checkFile(String keyStr, String generatedFileName,
			Category newCateg) throws ManagerException {
		FileManager fileMgr = (FileManager) getContainer().getManager(
				FileManager.class);
		List<File> files = fileMgr.getList(newCateg, generatedFileName);
		File file = null;
		switch (files.size()) {
		// Creating new file if none found
		case 0:
			file = new File();
			file.setCategory(newCateg);
			break;
		// Updating file if only one is found
		case 1:
			file = files.get(0);
			break;
		// Throwing exception if more than one found
		default:
			throw new ManagerException("There are more than one files of name "
					+ keyStr + " in category " + newCateg.getId() + " ("
					+ newCateg.getDescription() + ")");
		}

		file.setActive(true);
		file.setDescription(keyStr);
		file.setFileName(generatedFileName);
		file.setOrder(0); // TODO: order should be evaluated
		getContainer().begin();
		try {
			fileMgr.saveOrUpdate(file);
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new ManagerException("Failed to save File data.", ex);
		}

		return file;
	}

	protected void checkIptc(File file,
			Map<String, Map<String, String>> mapGroups) throws ManagerException {
		ImageMetadataManager mgr = (ImageMetadataManager) getContainer()
				.getManager(ImageMetadataManager.class);
		getContainer().begin();
		try {
			file.getIptcGroups().clear();
			for (String dKey : mapGroups.keySet()) {
				IptcGroup g = new IptcGroup();
				g.setFile(file);
				g.setName(dKey);
				mgr.saveOrUpdateIptcGroup(g);
				Map<String, String> mapTags = mapGroups.get(dKey);
				for (String tKey : mapTags.keySet()) {
					IptcField f = new IptcField();
					f.setGroup(g);
					f.setName(tKey);
					f.setValue(mapTags.get(tKey));
					mgr.saveOrUpdateIptcField(f);
				}
			}
			getContainer().commit();
		} catch (Exception ex) {
			getContainer().rollback();
			throw new ManagerException("Failed to save IPTC data.", ex);
		}
	}

	protected Date getCategoryDate(ImageManagerEvent evt) throws ParseException {
		try {
			return parseDate(evt.getParsedFileName().getYear(), evt
					.getParsedFileName().getMonth(), evt.getParsedFileName()
					.getDay());
		} catch (ParseException ex) {
			throw ex;
		}
	}

	public static Date parseDate(String year, String month, String day)
			throws ParseException {
		Calendar cal1 = Calendar.getInstance();

		Integer currYear = cal1.get(Calendar.YEAR);
		Integer currentYearMajor = currYear / YEAR_LIMIT * YEAR_LIMIT;
		Integer currYearMinor = currYear - currentYearMajor;

		Integer year2 = 1;
		Integer month2 = 0;
		Integer date2 = 1;

		if (!(ZERO_TIME.equals(year) && ZERO_TIME.equals(month) && ZERO_TIME
				.equals(day))) {
			Integer yearInt = Integer.parseInt(year);

			year2 = currYearMinor >= yearInt ? currentYearMajor + yearInt
					: currentYearMajor - YEAR_LIMIT + yearInt;

			month2 = month.equals(ZERO_TIME) ? 0 : Integer.parseInt(month) - 1;
			date2 = day.equals(ZERO_TIME) ? 1 : Integer.parseInt(day);
		}

		Calendar cal2 = Calendar.getInstance();
		cal2.set(year2, month2, date2, 0, 0, 0);

		return cal2.getTime();
	}
}
