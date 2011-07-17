package org.bambrikii.photobank.web.file.beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bambrikii.photobank.business.managers.EventManager;
import org.bambrikii.photobank.business.managers.FileDimensionManager;
import org.bambrikii.photobank.business.managers.FileManager;
import org.bambrikii.photobank.business.managers.LegalOwnerManager;
import org.bambrikii.photobank.business.managers.PhotoOrderManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfig;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfigManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ParsedFileName;
import org.bambrikii.photobank.business.managers.imageprocessing.handlers.MassImageUploadManagerHandler;
import org.bambrikii.photobank.model.Category;
import org.bambrikii.photobank.model.Event;
import org.bambrikii.photobank.model.File;
import org.bambrikii.photobank.model.FileDimension;
import org.bambrikii.photobank.model.LegalOwner;
import org.bambrikii.photobank.payment.model.PhotoOrderItem;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.business.pagers.Pager;
import org.bambrikii.site.base.payment.model.OrderItem;
import org.bambrikii.site.base.struts2.core.SiteBaseBean;
import org.bambrikii.site.base.struts2.core.WebException;

public class PhotoBean extends SiteBaseBean {
	private static final String TOP_ORDERED_FILES_COUNT = ".ru.psfotos.orders.topFilesCount";

	public Pager<File> getLatest(Pager<File> pager, String order,
			Integer topRecords) throws WebException {
		try {
			FileManager mgr = (FileManager) getContainer().getManager(
					FileManager.class);
			Pager<File> filePager = mgr.find(pager, order, topRecords);
			return filePager;
		} catch (ManagerException ex) {
			throw new WebException("PhotosBean.getPhotos failed!", ex);
		}
	}

	public Pager<File> getPhotos(String searchString, String order,
			Integer currentPage, Integer topRecords) throws WebException {
		try {
			FileManager mgr = (FileManager) getContainer().getManager(
					FileManager.class);
			Pager<File> filePager = mgr.find(searchString, order, currentPage,
					topRecords);
			return filePager;
		} catch (ManagerException ex) {
			throw new WebException("PhotosBean.getPhotos failed!", ex);
		}
	}

	public File getById(Integer id) throws WebException {
		try {
			FileManager mgr = (FileManager) getContainer().getManager(
					FileManager.class);
			File file = mgr.getById(id);
			return file;
		} catch (ManagerException ex) {
			throw new WebException("PhotosBean.getById failed!", ex);
		}
	}

	public List<FileDimension> getFileDimensions() throws WebException {
		try {
			FileDimensionManager mgr = (FileDimensionManager) getContainer()
					.getManager(FileDimensionManager.class);
			List<FileDimension> dimensions = mgr.getDimensions();
			return dimensions;
		} catch (ManagerException ex) {
			throw new WebException("PhotosBean.getFileDimensions failed!", ex);
		}
	}

	public File saveFile(java.io.File sourceFile, String name)
			throws ManagerException {
		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);

		ImageProcessingConfigManager imgConfigMgr = new ImageProcessingConfigManager(
				configMgr);

		MassImageUploadManagerHandler mgrHandler = new MassImageUploadManagerHandler(
				getContainer());
		ImageManager mgr = new ImageManager();
		mgr.addImageManagerListener(mgrHandler);

		ImageProcessingConfig cfg = imgConfigMgr.getConfiguration();

		List<?> files = mgr.saveImage(sourceFile.getAbsolutePath(), name, cfg);
		if (files != null && files.size() == 1) {
			return (File) files.get(0);
		}
		throw new ManagerException("File " + name + " has not been saved.");
	}

	public List<LegalOwner> getLegalOwners() throws WebException {
		try {
			LegalOwnerManager loMgr = (LegalOwnerManager) getContainer()
					.getManager(LegalOwnerManager.class);
			return loMgr.getList();
		} catch (ManagerException ex) {
			throw new WebException("Cannot get LegalOwners list.", ex);
		}
	}

	public InputStream getPhotoStream(Integer id, PreviewTypeEnum previewType)
			throws WebException {
		try {
			FileManager fileMgr = (FileManager) getContainer().getManager(
					FileManager.class);
			File file = fileMgr.getById(id);
			if (file == null) {
				throw new WebException("File with id " + id + " does not exist");
			}
			ConfigurationManager configMgr = (ConfigurationManager) getContainer()
					.getManager(ConfigurationManager.class);
			String destFolderName = configMgr
					.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_PATH);

			String fileName = null;
			switch (previewType) {
			case SMALL_PREVIEW:
				fileName = destFolderName
						+ java.io.File.separator
						+ configMgr
								.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_SMALL_PREVIEW)
						+ java.io.File.separator + file.getFileName();
				break;
			case LARGE_PREVIEW:
				fileName = destFolderName
						+ java.io.File.separator
						+ configMgr
								.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_LARGE_PREVIEW)
						+ java.io.File.separator + file.getFileName();
				break;
			case ORIGINAL:
				fileName = destFolderName
						+ java.io.File.separator
						+ configMgr
								.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_ORIGINAL)
						+ java.io.File.separator + file.getFileName();
				break;
			}
			FileInputStream fis = new FileInputStream(fileName);
			return fis;
		} catch (ManagerException ex) {
			throw new WebException("Failed to get image stream.", ex);
		} catch (FileNotFoundException ex) {
			throw new WebException("Could not find image file.", ex);
		}
	}

	public void deleteFile(Integer id) throws WebException {
		try {
			FileManager fileMgr = (FileManager) getContainer().getManager(
					FileManager.class);
			File file = getById(id);
			getContainer().begin();
			try {
				fileMgr.delete(file);
				getContainer().commit();
			} catch (ManagerException ex) {
				getContainer().rollback();
				throw new ManagerException("failed to delete file.", ex);
			}
		} catch (ManagerException ex) {
			throw new WebException("Failed to manage transaction.", ex);
		}
	}

	public List<File> getTopOrderedFiles() throws ManagerException {

		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);

		FileManager mgr = (FileManager) getContainer().getManager(
				FileManager.class);

		return mgr.getTopNFiles(Integer.parseInt(configMgr
				.getCacheConfigValue(TOP_ORDERED_FILES_COUNT)));
	}

	public InputStream getPhotoStream(Integer orderItemId, Integer sessionUserId)
			throws ManagerException, IOException {
		PhotoOrderManager orderMgr = (PhotoOrderManager) getContainer()
				.getManager(PhotoOrderManager.class);
		OrderItem item = orderMgr.getOrderItem(orderItemId, sessionUserId);

		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);

		String destFolderName = configMgr
				.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_PATH);

		String fileName = destFolderName
				+ java.io.File.separator
				+ configMgr
						.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_WEB_SIZE)
				+ java.io.File.separator
				+ ((PhotoOrderItem) item).getFile().getFileName();

		String tmp1 = configMgr
				.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_TEMP);
		/*
		 * String tmpFileName = destFolderName + java.io.File.separator + tmp1 +
		 * java.io.File.separator + UUID.randomUUID() + "." + tmp1;
		 */
		java.io.File f1 = java.io.File.createTempFile(tmp1, "." + tmp1);
		FileDimension dim2 = ((PhotoOrderItem) item).getDimension();
		if (dim2.getMaxDim() != null && dim2.getMaxDim() > 0) {
			ImageManager.resize(fileName, f1.getAbsolutePath(),
					dim2.getMaxDim());
		} else {
			copy(new java.io.File(fileName), f1);
		}
		f1.deleteOnExit();
		FileInputStream fis = new FileInputStream(f1);
		return fis;
	}

	void copy(java.io.File src, java.io.File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst);
		// Transfer bytes from in to out
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	public Category getParent(File file) throws ManagerException {
		EventManager eventMgr = (EventManager) getContainer().getManager(
				EventManager.class);
		Category categ = file.getCategory().getParent();
		Event event = eventMgr.getById(file.getCategory().getParent().getId());
		if (event != null) {
			return event;
		}
		return categ;
	}

	public String saveFile10x15(java.io.File srcFile, String srcFileName)
			throws ManagerException, IOException {
		ParsedFileName pfn = new ParsedFileName(
				FilenameUtils.getName(srcFileName));
		String generatedFileName = pfn.getGeneratedName();
		ConfigurationManager configMgr = (ConfigurationManager) getContainer()
				.getManager(ConfigurationManager.class);
		ImageProcessingConfigManager imgConfigMgr = new ImageProcessingConfigManager(
				configMgr);
		ImageProcessingConfig cfg = imgConfigMgr.getConfiguration();

		// 1. Saving source web
		FileUtils.copyFile(srcFile, new java.io.File(cfg.getWebSubFolderName()
				+ java.io.File.separator + generatedFileName));
		return "0";
	}

	public static String getReadableFileName(String name) {
		return name.substring(name.lastIndexOf("/") + 1, name.indexOf("."));
	}
}
