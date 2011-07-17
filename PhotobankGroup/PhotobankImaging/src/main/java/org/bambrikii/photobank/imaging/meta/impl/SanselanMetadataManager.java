package org.bambrikii.photobank.imaging.meta.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.common.ImageMetadata;
import org.apache.sanselan.formats.tiff.TiffImageMetadata;
import org.bambrikii.photobank.imaging.meta.MetadataManager;
import org.bambrikii.photobank.imaging.meta.MetadataManagerException;

public class SanselanMetadataManager implements MetadataManager {

	private String charsetFrom = null;
	private String charsetTo = null;

	public SanselanMetadataManager() {
		charsetFrom = "ISO-8859-1";
		charsetTo = "cp1251";
	}

	public SanselanMetadataManager(String charsetFrom, String charsetTo) {
		this.charsetFrom = charsetFrom;
		this.charsetTo = charsetTo;
	}

	private String convertText(String text) throws UnsupportedEncodingException {
		if (charsetFrom != null && charsetTo != null) {
			return new String(text.getBytes(charsetFrom), charsetTo);
		} else {
			return text;
		}
	}

	@Override
	public Map<String, Map<String, String>> getMetadataMap(File file)
			throws MetadataManagerException {
		try {
			Map<String, Map<String, String>> mm = new HashMap<String, Map<String, String>>();
			IImageMetadata metadata = Sanselan.getMetadata(file);
			for (Object item : metadata.getItems()) {
				if (item instanceof TiffImageMetadata.Item) {

				} else if (item instanceof ImageMetadata.Item) {
					ImageMetadata.Item iitem = (ImageMetadata.Item) item;
					String className = "Iptc";// iitem.getClass().getName();
					Map<String, String> mmd = null;
					if (mm.containsKey(className)) {
						mmd = mm.get(className);
					} else {
						mmd = new HashMap<String, String>();
						mm.put(className, mmd);
					}
					mmd.put(iitem.getKeyword(), convertText(iitem.getText()));
				}
			}
			return mm;
		} catch (Exception ex) {
			throw new MetadataManagerException("Metadata reading failed.", ex);
		}
	}
}
