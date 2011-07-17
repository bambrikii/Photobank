package org.bambrikii.photobank.imaging.tests;

import java.util.Map;

public abstract class MetadataManagerTests {
	public void printMetadata(Map<String, Map<String, String>> mm) {
		for (String dirKey : mm.keySet()) {
			for (String tagKey : mm.get(dirKey).keySet()) {
				System.out.printf("dir key: %s, tag key: %s, value: %s\n",
						dirKey, tagKey, mm.get(dirKey).get(tagKey));
			}
		}
	}
}
