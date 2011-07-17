package org.bambrikii.photobank.web.dtutils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.FileImageInputStream;

import org.junit.Test;
import org.w3c.dom.Node;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.iptc.IptcReader;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGDecodeParam;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

public class IptcTests {

	public static String TEST_FILE_NAME = System.getProperty("user.dir")
			+ "/src/test/resources/316337_R_021010_033.jpg";

	@Test
	public void readMetadataTest1() throws MetadataException,
			JpegProcessingException, ImageFormatException, IOException {
		File file = new File(TEST_FILE_NAME);

		JPEGImageDecoder jpegDecoder = JPEGCodec
				.createJPEGDecoder(new FileInputStream(file));
		@SuppressWarnings("unused")
		BufferedImage image = jpegDecoder.decodeAsBufferedImage();
		JPEGDecodeParam decodeParam = jpegDecoder.getJPEGDecodeParam();
		Metadata metadata = JpegMetadataReader.readMetadata(decodeParam);
		Iterator<?> directories = metadata.getDirectoryIterator();
		while (directories.hasNext()) {
			Directory directory = (Directory) directories.next();
			System.out.printf("%s\n", directory.getName());
			Iterator<?> tags = directory.getTagIterator();
			while (tags.hasNext()) {
				Tag tag = (Tag) tags.next();
				System.out.printf("	%s, %s\n", tag.getTagName(),
						tag.getDescription());
			}
		}
	}

	public static byte[] switchBytes(byte[] b) {
		for (int i = 0; i < b.length - 1; i += 2) {
			byte b2 = b[i];
			b[i] = b[i + 1];
			b[i + 1] = b2;
		}
		return b;
	}

	@Test
	public void headlineTest() throws IOException, JpegProcessingException,
			MetadataException {
		File file = new File(TEST_FILE_NAME);
		Metadata metadata = JpegMetadataReader.readMetadata(file);
		Iterator<?> directories = metadata.getDirectoryIterator();
		while (directories.hasNext()) {
			Directory directory = (Directory) directories.next();
			if (directory.getName().equals("Iptc")) {
				System.out.printf("%s\n", directory.getName());
				Iterator<?> tags = directory.getTagIterator();
				while (tags.hasNext()) {
					Tag tag = (Tag) tags.next();
					if (tag.getTagName().equals("Headline")
							|| tag.getTagName().equals("Caption/Abstract")) {
						System.out.printf("%s\n", tag.getDescription());

						/*
						 * byte[] bytes1 = switchBytes(tag.getDescription()
						 * .getBytes("UTF-8")); String string1 = new
						 * String(bytes1, "UTF-8");
						 */

						System.out.printf("	%s\n", new String(tag
								.getDescription().getBytes("ISO-8859-1"),
								"cp1251"));

						System.out.printf("	string1 : %s\n",
								tag.getDescription());
					}
				}
			}
		}

	}

	@Test
	public void print() {
		byte[] bytes1 = "МУЗ ТВ. Мы умеем зажигать. Все хиты осени 2010. Крокус Сити Холл"
				.getBytes();
		printBinary(bytes1);
		System.out.printf("	%s\n", IptcTests.bytesToString(bytes1));
	}

	public static String bytesToString(byte[] b) {
		StringWriter sw = new StringWriter();
		for (int i = 0; i < b.length; i++) {
			sw.append(new Integer(b[i]).toString() + " ");
		}
		return sw.toString();
	}

	@Test
	public void jaiTest() throws IOException {
		System.out.printf("%s\n", TEST_FILE_NAME);

		FileImageInputStream imageStream = new FileImageInputStream(new File(
				TEST_FILE_NAME));

		ImageReader reader = ImageIO.getImageReadersByFormatName("jpeg").next();

		reader.setInput(imageStream, true, false);
		// /

		// here's the metadata
		IIOMetadata meta = reader.getImageMetadata(0);

		Node root = meta.getAsTree(meta.getNativeMetadataFormatName());

		Node jpegVariety = root.getFirstChild(); // JPEGvariety node
		Node markerSeq = jpegVariety.getNextSibling(); // markerSequence node

		// search for IPTC data
		@SuppressWarnings("unused")
		Node iptc = null;

		Node child = markerSeq.getFirstChild();
		while (child != null) {
			System.out.printf(" %s\n", child.getNodeName());
			if ("unkown".equals(child.getNodeName())) {
				Node marker = child.getAttributes().getNamedItem("MarkerTag");
				if ("237".equals(marker.getNodeValue())) {
					iptc = child;
					break;
				}
			}
			child = child.getNextSibling();
		}

		// /
		reader.dispose();
		imageStream.close();

	}

	@Test
	public void jaiToolsTest() throws JpegProcessingException,
			UnsupportedEncodingException, MetadataException {
		@SuppressWarnings("deprecation")
		IptcReader reader = new IptcReader(new File(TEST_FILE_NAME));
		Metadata meta = reader.extract();
		Directory directory = meta.getDirectory(IptcDirectory.class);
		@SuppressWarnings("unused")
		Iterator<?> tags = directory.getTagIterator();
		byte[] b1 = (byte[]) directory.getByteArray(IptcDirectory.TAG_HEADLINE);
		String str1 = new String(b1, "UTF-8");
		System.out.printf("	string1 : %s\n", str1);

	}

	protected String getHeadline(Metadata meta) throws MetadataException,
			UnsupportedEncodingException {
		Directory directory = meta.getDirectory(IptcDirectory.class);
		@SuppressWarnings("unused")
		Iterator<?> tags = directory.getTagIterator();
		byte[] b1 = (byte[]) directory.getByteArray(IptcDirectory.TAG_HEADLINE);
		String str1 = new String(b1, "UTF-8");
		System.out.printf("	string1 : %s\n", str1);
		return str1;
	}

	@Test
	public void readIptcSegmentTest() throws JpegProcessingException,
			MetadataException, UnsupportedEncodingException {
		JpegSegmentReader r = new JpegSegmentReader(new File(TEST_FILE_NAME));
		byte[] seg1 = r.readSegment((byte) -19);
		IptcReader2 r2 = new IptcReader2(seg1);

		/*
		 * byte[] b2 = new byte[64]; for (int i = 0; i < 64; i++) { b2[i] =
		 * r2._data[i + 103]; } String str2 = new String( b2, "UTF-8");
		 * System.out.printf("%s\n%s\n", bytesToString(b2), str2);
		 */
		Metadata meta = r2.extract();
		Directory directory = meta.getDirectory(IptcDirectory.class);
		@SuppressWarnings("unused")
		Iterator<?> tags = directory.getTagIterator();
		byte[] b1 = (byte[]) directory.getByteArray(IptcDirectory.TAG_HEADLINE);
		// invertBytes(b1);
		// printBinary(b1);
		String str1 = new String(
				new String(b1, "windows-1251").getBytes("utf-8"));
		System.out.printf("	string1 : %s\n", str1);
	}

	@Test
	public void invertByteTest() {
		byte[] b = new byte[] { (byte) 145 };
		printBinary(b);
		invertBytes(b);
		printBinary(b);
	}

	private byte[] invertBytes(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) ~b[i];
			// b[i] = (byte) (b[i] >> 8);
		}
		return b;
	}

	public static byte[] shiftBytes(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] - 32);
		}
		return b;
	}

	public static void printBinary(byte[] b) {
		StringWriter sw = new StringWriter();
		for (int i = 0; i < b.length; i++) {
			sw.append(Integer.toBinaryString(b[i]));
			sw.append("\n");
		}
		System.out.printf("%s\n", sw.toString());
	}

	@Test
	public void listCharsetsTest() {
		SortedMap<String, Charset> charsetsMap = Charset.availableCharsets();
		System.out.println("Charsets available: " + charsetsMap.size());
		for (String name : charsetsMap.keySet()) {
			Charset charset = charsetsMap.get(name);
			StringBuffer sb = new StringBuffer();
			sb.append(name);
			sb.append(" (");
			for (Iterator<String> aliases = charset.aliases().iterator(); aliases
					.hasNext();) {
				sb.append(aliases.next());
				if (aliases.hasNext())
					sb.append(",");
			}
			sb.append(")");
			System.out.println(sb.toString());
		}

	}
}
