package org.bambrikii.photobank.imaging.meta.impl;

import com.drew.metadata.Directory;
import com.drew.metadata.exif.ExifDirectory;
import com.drew.metadata.iptc.IptcDirectory;

public class MetadataDirectory {

	private Directory _directory;

	protected MetadataDirectory(Directory directory) {
		_directory = directory;
	}

	protected int getTagType(String tagName) throws IllegalArgumentException,
			SecurityException, IllegalAccessException, NoSuchFieldException {
		if (_directory instanceof IptcDirectory) {
			return (Integer) IptcDirectory.class.getDeclaredField(
					"TAG_" + tagName).get(null);
		} else if (_directory instanceof ExifDirectory) {
			return (Integer) ExifDirectory.class.getDeclaredField(
					"TAG_" + tagName).get(null);
		}
		return 0;
	}

	protected String getTagValue(int tagType) {
		return _directory.getString(tagType);
	}

	public String getTagValue(String tagType) throws IllegalArgumentException,
			SecurityException, IllegalAccessException, NoSuchFieldException {
		return _directory.getString(getTagType(tagType));
	}

}
