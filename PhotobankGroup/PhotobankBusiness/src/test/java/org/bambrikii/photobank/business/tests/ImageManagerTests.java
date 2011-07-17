package org.bambrikii.photobank.business.tests;

import java.io.File;

import junit.framework.Assert;

import org.apache.commons.io.FilenameUtils;
import org.bambrikii.photobank.business.managers.CategoryManager;
import org.bambrikii.photobank.business.managers.LegalOwnerManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfig;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfigManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ParsedFileName;
import org.bambrikii.photobank.business.managers.imageprocessing.ParsedFileNameException;
import org.bambrikii.photobank.business.managers.imageprocessing.handlers.MassImageUploadManagerHandler;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.ManagerContainer;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.junit.Test;

public class ImageManagerTests {
	public static final String LEGAL_OWNER_PICTUREPERFECT = "PicturePerfect";
	public static final String DEST_FOLDER = "D:\\Temporary Files\\psfotos.ru\\";
	public static final String fileNamePP = "src/test/resources/000067_R_220309_PP.jpg";

	/*
	 * @Test public void �onvertTest() throws IOException { String fileName =
	 * "src/test/resources/300626_R_220710_044.JPG"; String watermarkFile =
	 * "src/test/resources/watermark1.png";
	 *
	 * PhotoOp op = new PhotoOp(); op.setSourceFile(fileName);
	 * op.setDstFileName(fileName + ".temp.jpg"); op.setMaxDim(300);
	 * op.setWatermark(watermarkFile); mgr.save(op);
	 *
	 * File f2 = new File(op.getDstFileName()); boolean fileExists =
	 * f2.exists(); if (fileExists) { f2.delete(); }
	 * Assert.assertTrue("File could not be created.", fileExists); }
	 */
	@Test
	public void parseFileNameTest() throws ParsedFileNameException {
		String fileName = "000067_R_220300_PP.jpg";
		ParsedFileName p = new ParsedFileName(fileName);
		System.out.printf("%s, %s, %s, %s, %s, %s\n", p.getSeqNumber(),
				p.getType(), p.getDay(), p.getMonth(), p.getYear(),
				p.getAuthor());
		Assert.assertEquals("getYear invalid.", p.getYear(), "00");
		Assert.assertEquals("getMonth invalid.", p.getMonth(), "03");
		Assert.assertEquals("getDay invalid.", p.getDay(), "22");
		Assert.assertEquals(
				"GeneratedName invalid.",
				p.getYear() + "/" + p.getMonth() + "/" + p.getDay() + "/"
						+ p.getSourceFileName(), p.getGeneratedName());
		System.out.printf("%s\n", p.getGeneratedName());
		System.out.printf("%s\n", p);
	}

	@Test
	public void parseFileNameTest2() {
		String fullFileName = "D:\\Temporary Files\\psfotos.ru\\images\\000067_R_220309_PP.jpg";
		System.out.printf("%s, %s",
				FilenameUtils.getFullPathNoEndSeparator(fullFileName),
				FilenameUtils.getName(fullFileName));
	}

	@Test
	public void savePhotoTest() throws ManagerException {
		ImageManager mgr = new ImageManager();
		ManagerContainer container = new ManagerContainer();
		container.open();
		ConfigurationManager configMgr = (ConfigurationManager) container
				.getManager(ConfigurationManager.class);
		File file = new File(fileNamePP);
		// File fileWm = new File(Constants.fileNameWatermark1png);
		System.out.printf("file.getAbsolutePath(): %s\n",
				file.getAbsolutePath());

		ImageProcessingConfigManager imgCfgMgr = new ImageProcessingConfigManager(
				configMgr);
		ImageProcessingConfig cfg = imgCfgMgr.getConfiguration();

		mgr.saveImage(file.getAbsolutePath(), file.getName(), cfg);
		container.close();
	}

	@Test
	public void iptcTest() throws ManagerException {
		ManagerContainer container = new ManagerContainer();
		container.open();

		ConfigurationManager configMgr = (ConfigurationManager) container
				.getManager(ConfigurationManager.class);
		ImageProcessingConfigManager imgCfgMgr = new ImageProcessingConfigManager(
				configMgr);
		ImageProcessingConfig cfg = imgCfgMgr.getConfiguration();

		CategoryManager categMgr = (CategoryManager) container
				.getManager(CategoryManager.class);
		Category categ = categMgr
				.getById(EventManagerTests.TEST_EVENT_PARENT_CATEGORY_ID);

		LegalOwnerManager loMgr = (LegalOwnerManager) container
				.getManager(LegalOwnerManager.class);
		LegalOwner lo = loMgr.getByName(LEGAL_OWNER_PICTUREPERFECT);

		String fileName = fileNamePP;

		ImageManager mgr = new ImageManager();
		MassImageUploadManagerHandler listener = new MassImageUploadManagerHandler(
				container);
		mgr.addImageManagerListener(listener);

		mgr.saveImage(fileName, FilenameUtils.getName(fileName), cfg);
		container.close();
	}

	@Test
	public void stringSplitTest() {
		String[] str = "Iptc.Caption/Abstract".split("\\.");
		Assert.assertTrue(str.length == 2);
	}
}
