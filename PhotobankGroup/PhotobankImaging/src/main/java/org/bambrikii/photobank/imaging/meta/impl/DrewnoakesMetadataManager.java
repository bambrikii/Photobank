package org.bambrikii.photobank.imaging.meta.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bambrikii.photobank.imaging.meta.MetadataManager;
import org.bambrikii.photobank.imaging.meta.MetadataManagerException;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.iptc.IptcDirectory;

public class DrewnoakesMetadataManager implements MetadataManager {
	public static MetadataDirectory getMetadata(String fileName)
			throws IOException, JpegProcessingException {
		File jpegFile = new File(fileName);
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		Directory iptcDirectory = metadata.getDirectory(IptcDirectory.class);
		MetadataDirectory metadataDir = new MetadataDirectory(iptcDirectory);
		return metadataDir;
	}

	public Map<String, Map<String, String>> getMetadataMap(File file)
			throws MetadataManagerException {
		try {
			Map<String, Map<String, String>> mm = new HashMap<String, Map<String, String>>();

			Metadata metadata = JpegMetadataReader.readMetadata(file);
			Iterator directories = metadata.getDirectoryIterator();
			while (directories.hasNext()) {
				Directory directory = (Directory) directories.next();
				Map<String, String> mmd = new HashMap<String, String>();
				mm.put(directory.getName(), mmd);
				Iterator tags = directory.getTagIterator();
				while (tags.hasNext()) {
					Tag tag = (Tag) tags.next();
					mmd.put(tag.getTagName(), tag.getDescription());
				}
			}
			return mm;
		} catch (Exception ex) {
			throw new MetadataManagerException("Metadata reading failed.", ex);
		}
	}
}
