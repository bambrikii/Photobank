package org.bambrikii.photobank.business.managers.imageprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bambrikii.photobank.imaging.ImageParser;
import org.bambrikii.photobank.imaging.meta.MetadataManagerException;
import org.bambrikii.photobank.imaging.meta.impl.SanselanMetadataManager;
import org.bambrikii.site.base.business.managers.core.ManagerException;

public class ImageManager {

	public static void resize(String src, String dst, int maxDim)
			throws ManagerException {
		try {
			ImageParser.resize(src, dst, maxDim);
		} catch (IOException ex) {
			throw new ManagerException("Resize failed!", ex);
		}
	}

	public List<?> saveImage(String srcFileName, String destFileName,
			ImageProcessingConfig cfg) throws ManagerException {
		try {
			ParsedFileName pfn = new ParsedFileName(
					FilenameUtils.getName(destFileName));
			String generatedFileName = pfn.getGeneratedName();
			java.io.File srcFile = new java.io.File(srcFileName);

			// 1. Saving small preview
			String dstFileName = cfg.getSmallPreviewFolderName()
					+ java.io.File.separator + generatedFileName;
			FileUtils.forceMkdir(new java.io.File(FilenameUtils
					.getFullPath(dstFileName)));
			ImageParser.resize(srcFileName, dstFileName, cfg.getSmallDim());

			// 2. Saving large preview
			dstFileName = cfg.getLargePreviewFolderName()
					+ java.io.File.separator + generatedFileName;
			FileUtils.forceMkdir(new java.io.File(FilenameUtils
					.getFullPath(dstFileName)));

			FileUtils.copyFile(srcFile, new java.io.File(dstFileName));

			// 3. Saving category data or firing saveImageComplete event.
			ImageManagerEvent evt = new ImageManagerEvent();
			evt.setParsedFileName(pfn);
			// Set IPTC data
			try {
				SanselanMetadataManager metadataMgr = new SanselanMetadataManager();
				Map<String, Map<String, String>> metadata = metadataMgr
						.getMetadataMap(srcFile);
				evt.setMetadataMap(metadata);
			} catch (MetadataManagerException ex) {
				throw new ManagerException("Cannot get metadata.", ex);
			}

			List<Object> results = new ArrayList<Object>();
			for (ImageManagerListener listener : listenerList) {
				results.add(listener.saveImageComplete(evt));
			}
			return results;
		} catch (IOException ex) {
			throw new ManagerException("Cannot save image.", ex);
		}
	}

	private List<ImageManagerListener> listenerList = new ArrayList<ImageManagerListener>();

	public void addImageManagerListener(ImageManagerListener listener) {
		listenerList.add(listener);
	}

	public void removeImageManagerListener(ImageManagerListener listener) {
		listenerList.remove(listener);
	}
}
