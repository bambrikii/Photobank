package org.bambrikii.photobank.business.managers.imageprocessing;

import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class ImageProcessingConfigManager {

	public static final String CFG_IMAGES_PATH = ".ru.psfotos.images.Path";
	public static final String CFG_IMAGES_WATERMARK_FILENAME = ".ru.psfotos.Watermark.FileName";
	public static final String CFG_IMAGES_ORIGINAL = ".ru.psfotos.images.Original.SubPath";
	public static final String CFG_IMAGES_WEB_SIZE = ".ru.psfotos.images.Web.SubPath";
	public static final String CFG_IMAGES_SMALL_PREVIEW = ".ru.psfotos.images.SmallPreview.SubPath";
	public static final String CFG_IMAGES_SMALL_PREVIEW_DIM = ".ru.psfotos.images.SmallPreview.Dim";
	public static final String CFG_IMAGES_LARGE_PREVIEW = ".ru.psfotos.images.LargePreview.SubPath";

	public static final String CFG_IMAGES_TEMP = ".ru.psfotos.images.Temp.SubPath";

	private ConfigurationManager configMgr;

	public ImageProcessingConfigManager(
			ConfigurationManager configurationManager) {
		configMgr = configurationManager;
	}

	public ImageProcessingConfig getConfiguration() throws ManagerException {
		ImageProcessingConfig cfg = new ImageProcessingConfig();
		String destFolderName = configMgr
				.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_PATH);
		cfg.setDestFolderName(destFolderName);

		cfg.setWmFileName(destFolderName
				+ java.io.File.separator
				+ configMgr
						.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_WATERMARK_FILENAME));
		cfg.setWebSubFolderName(destFolderName
				+ java.io.File.separator
				+ configMgr
						.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_WEB_SIZE));

		cfg.setSmallPreviewFolderName(destFolderName
				+ java.io.File.separator
				+ configMgr
						.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_SMALL_PREVIEW));
		cfg.setLargePreviewFolderName(destFolderName
				+ java.io.File.separator
				+ configMgr
						.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_LARGE_PREVIEW));

		cfg.setSmallDim(Integer.parseInt(configMgr
				.getCacheConfigValue(ImageProcessingConfigManager.CFG_IMAGES_SMALL_PREVIEW_DIM)));
		return cfg;
	}
}
