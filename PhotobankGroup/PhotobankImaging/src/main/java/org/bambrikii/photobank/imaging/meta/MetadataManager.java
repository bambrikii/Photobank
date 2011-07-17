package org.bambrikii.photobank.imaging.meta;

import java.io.File;
import java.util.Map;

public interface MetadataManager {
	public Map<String, Map<String, String>> getMetadataMap(File file)
			throws MetadataManagerException;
}
