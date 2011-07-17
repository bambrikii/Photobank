package org.bambrikii.photobank.imaging.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

import org.bambrikii.photobank.imaging.meta.MetadataManagerException;
import org.bambrikii.photobank.imaging.meta.impl.DrewnoakesMetadataManager;
import org.bambrikii.photobank.imaging.meta.impl.MetadataDirectory;
import org.junit.Test;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.iptc.IptcDirectory;

public class DrewnoakesMetadataManagerTests extends MetadataManagerTests {

	@Test
	public void getIptcDataTest() throws IOException, JpegProcessingException,
			IllegalArgumentException, SecurityException,
			IllegalAccessException, NoSuchFieldException {
		DrewnoakesMetadataManager mgr = new DrewnoakesMetadataManager();
		MetadataDirectory metadata = mgr.getMetadata(Constants.fileNamePP);
		System.out.printf("CAPTION: %s\n", metadata.getTagValue("CAPTION"));

		metadata = mgr.getMetadata(Constants.fileNamePRP);
		System.out.printf("OBJECT_NAME: %s\n",
				metadata.getTagValue("OBJECT_NAME"));
	}

	protected void printMetadataDirectory(Directory directory)
			throws MetadataException {
		Iterator tags = directory.getTagIterator();
		while (tags.hasNext()) {
			Tag tag = (Tag) tags.next();
			// use Tag.toString()
			System.out.printf("TagName:	%s\n" + "TagType:	%s\n"
					+ "TagTypeHex:	%s\n" + "DirectoryName:	%s\n"
					+ "Description:	%s\n" + "toString():	%s\n" + "\n",
					tag.getTagName(), tag.getTagType(), tag.getTagTypeHex(),
					tag.getDirectoryName(), tag.getDescription(),
					tag.toString());
			// System.out.println(tag);
		}
	}

	@Test
	public void getIptcDataTest4() throws JpegProcessingException,
			MetadataException {
		File jpegFile = new File(Constants.fileNamePP);
		Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);
		// iterate through metadata directories
		Iterator directories = metadata.getDirectoryIterator();
		while (directories.hasNext()) {
			Directory directory = (Directory) directories.next();
			// iterate through tags and print to System.out
			printMetadataDirectory(directory);
		}
	}

	protected void printIptcDirectory(Directory directory) {
		System.out.printf("TAG_HEADLINE: %s\n",
				directory.getString(IptcDirectory.TAG_HEADLINE));
		System.out.printf("TAG_CATEGORY: %s\n",
				directory.getString(IptcDirectory.TAG_CATEGORY));
		System.out.printf("TAG_KEYWORDS: %s\n",
				directory.getString(IptcDirectory.TAG_KEYWORDS));
		System.out.printf("TAG_OBJECT_NAME: %s\n",
				directory.getString(IptcDirectory.TAG_OBJECT_NAME));
		System.out.printf("TAG_BY_LINE_TITLE: %s\n",
				directory.getString(IptcDirectory.TAG_BY_LINE_TITLE));
		System.out.printf("TAG_CITY: %s\n",
				directory.getString(IptcDirectory.TAG_HEADLINE));
		System.out.printf("TAG_COPYRIGHT_NOTICE: %s\n",
				directory.getString(IptcDirectory.TAG_COPYRIGHT_NOTICE));
		System.out.printf("TAG_COUNTRY_OR_PRIMARY_LOCATION: %s\n", directory
				.getString(IptcDirectory.TAG_COUNTRY_OR_PRIMARY_LOCATION));
		System.out.printf("TAG_CAPTION: %s\n",
				directory.getString(IptcDirectory.TAG_CAPTION));
		System.out.print("\n");

	}

	@Test
	public void getIptcDataTest5() throws JpegProcessingException,
			MetadataException {
		Directory iptcDirectory = JpegMetadataReader.readMetadata(
				new File(Constants.fileNamePP)).getDirectory(
				IptcDirectory.class);
		printIptcDirectory(iptcDirectory);

		iptcDirectory = JpegMetadataReader.readMetadata(
				new File(Constants.fileNamePS)).getDirectory(
				IptcDirectory.class);
		printIptcDirectory(iptcDirectory);

		iptcDirectory = JpegMetadataReader.readMetadata(
				new File(Constants.fileNamePRP)).getDirectory(
				IptcDirectory.class);
		printIptcDirectory(iptcDirectory);
		// printMetadataDirectory(iptcDirectory);
	}

	@Test
	public void getStaticFieldsTest() throws IllegalArgumentException,
			IllegalAccessException {
		for (Field f : IptcDirectory.class.getDeclaredFields()) {
			f.setAccessible(true);
			System.out.println(f.getName() + ": " + f.get(null));
		}
	}

	@Test
	public void getDrewnoakesMetadataManagerMetadataMapTest()
			throws MetadataException, MetadataManagerException {
		DrewnoakesMetadataManager metadataMgr = new DrewnoakesMetadataManager();
		Map<String, Map<String, String>> mm = metadataMgr
				.getMetadataMap(new File(Constants.fileNamePRP));
		printMetadata(mm);
	}
}
