package org.bambrikii.photobank.imaging.tests;

import java.io.File;
import java.util.Map;

import junit.framework.Assert;

import org.bambrikii.photobank.imaging.meta.MetadataManagerException;
import org.bambrikii.photobank.imaging.meta.impl.SanselanMetadataManager;
import org.junit.Test;

public class SanselanMetadataManagerTests extends MetadataManagerTests {

	@Test
	public void listMetaTest2() throws MetadataManagerException {
		SanselanMetadataManager mm = new SanselanMetadataManager();
		Map<String, Map<String, String>> metadata = mm.getMetadataMap(new File(
				Constants.fileNamePS));
		printMetadata(metadata);
	}

	@Test
	public void listMetaTest() throws MetadataManagerException {
		SanselanMetadataManager mm = new SanselanMetadataManager();
		Map<String, Map<String, String>> metadata = mm.getMetadataMap(new File(
				Constants.fileNamePS));
		printMetadata(metadata);
		Assert.assertEquals(
				"Мисс Россия 2010 Ирина Антоненко представит Россию на Мисс Вселенная.",
				metadata.get(
						/* "org.apache.sanselan.common.ImageMetadata$Item" */"Iptc")
						.get("Headline"));
	}
}
