package org.bambrikii.photobank.web.dtutils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.bambrikii.photobank.imaging.meta.MetadataManagerException;
import org.bambrikii.photobank.imaging.meta.impl.DrewnoakesMetadataManager;
import org.junit.Test;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.MetadataException;

public class InSiteImportTests {

	@Test
	public void import1Test() throws Exception {
		InSiteImport imp = new InSiteImport();
		imp.import1(System.getProperty("user.dir") + "\\src\\test\\resources");
	}

	@Test
	public void encondingTest2() throws UnsupportedEncodingException {
		byte[] b1 = "Таша Строгая".getBytes();
		System.out.printf("	%s\n", new String(b1, "utf-8"));
	}

	@Test
	public void listSystemPropertiesTest() {
		Properties props = System.getProperties();
		props.list(System.out);

	}

	@Test
	public void listFilesTest() {
		String userDir = System.getProperty("user.dir");
		File dir = new File(userDir + "/src/test/resources");
		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isFile()
						&& Pattern.matches("^.*\\.jpg$", file.getName());
			}
		};
		files = dir.listFiles(fileFilter);
		for (File file : files) {
			System.out.printf("	%s\n", file.getName());
		}
	}

	@Test
	public void metadataTest() throws JpegProcessingException,
			MetadataException, IOException, MetadataManagerException {
		String userDir = System.getProperty("user.dir");
		File dir = new File(userDir + "/src/test/resources");

		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isFile()
						&& Pattern
								.matches("^316.*0\\d+\\.jpg$", file.getName());
			}
		};
		files = dir.listFiles(fileFilter);

		DrewnoakesMetadataManager metadataManager = new DrewnoakesMetadataManager();

		for (File file : files) {
			System.out.printf("%s\n", file.getName());
			Map<String, Map<String, String>> metadata = metadataManager
					.getMetadataMap(file);

			System.out.printf(
					"Exif.Image Description, b2: %s\n",
					IptcTests.bytesToString(metadata.get("Exif")
							.get("Image Description").getBytes("utf-8")));

			for (String key1 : metadata.keySet()) {
				System.out.printf("	%s\n", key1);
				if (key1.equals("Iptc"))
					for (String key : metadata.get(key1).keySet()) {

						byte[] b1 = metadata.get(key1).get(key)
								.getBytes();

						if (key.equals("Caption/Abstract")) {
							System.out.printf("%s.%s, b1: %s\n", key1, key,
									IptcTests.bytesToString(b1));
						}
						/*
						 * for (int i = 0; i < b1.length; i++) { b1[i] = (byte)
						 * (b1[i] +126); }
						 */
						String value = new String(b1, "cp1251");
						System.out.printf("		%s:\t\t%s\n", key, value);
					}
			}
		}
	}
}
