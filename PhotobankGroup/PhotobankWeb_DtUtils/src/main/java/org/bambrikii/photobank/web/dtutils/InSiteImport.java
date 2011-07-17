package org.bambrikii.photobank.web.dtutils;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

import org.bambrikii.photobank.business.managers.imageprocessing.ImageManager;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfig;
import org.bambrikii.photobank.business.managers.imageprocessing.ImageProcessingConfigManager;
import org.bambrikii.photobank.business.managers.imageprocessing.handlers.MassImageUploadManagerHandler;
import org.bambrikii.site.base.business.managers.ConfigurationManager;
import org.bambrikii.site.base.business.managers.ManagerContainer;

public class InSiteImport {

	public static void main(String[] args) throws Exception {
		InSiteImport imp = new InSiteImport();
		if (args.length < 1) {
			throw new Exception("Argument 'Source path' required!");
		}
		imp.import1(args[0]);
	}

	public void import1(String srcDir) throws Exception {

		ManagerContainer container = new ManagerContainer();
		container.open();
		try {
			ConfigurationManager configMgr = (ConfigurationManager) container
					.getManager(ConfigurationManager.class);

			ImageProcessingConfigManager imgConfigMgr = new ImageProcessingConfigManager(
					configMgr);

			ImageProcessingConfig cfg = imgConfigMgr.getConfiguration();

			ImageManager mgr = new ImageManager();

			MassImageUploadManagerHandler handler = new MassImageUploadManagerHandler(
					container);
			mgr.addImageManagerListener(handler);

			File dir = new File(srcDir);
			File[] files = dir.listFiles();
			FileFilter fileFilter = new FileFilter() {
				public boolean accept(File file) {
					return file.isFile()
							&& Pattern.matches("^.*\\.jpg$", file.getName());
				}
			};
			files = dir.listFiles(fileFilter);
			for (File file : files) {
				System.out.printf(" Processing %s ...\n", file.getName());
				mgr.saveImage(file.getAbsolutePath(), file.getName(), cfg);
			}
		} catch (Exception ex) {
			container.close();
			throw ex;
		}
	}
}
