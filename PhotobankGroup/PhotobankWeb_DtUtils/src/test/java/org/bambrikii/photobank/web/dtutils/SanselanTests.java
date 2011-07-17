package org.bambrikii.photobank.web.dtutils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.common.IImageMetadata.IImageMetadataItem;
import org.apache.sanselan.common.ImageMetadata;
import org.junit.Test;

public class SanselanTests {
	@Test
	public void readIptcTest() throws ImageReadException, IOException {
		IImageMetadata metadata = Sanselan.getMetadata(new File(
				IptcTests.TEST_FILE_NAME));
		for (Object item : metadata.getItems()) {
			IImageMetadataItem metadataItem = (IImageMetadataItem) item;
			// /if (!(item instanceof TiffImageMetadata.Item))
			{
				ImageMetadata.Item imgMetadataItem = (ImageMetadata.Item) item;

				String str2 = new String(imgMetadataItem.getText().getBytes(
						"ISO-8859-1"), "cp1251");

				if (imgMetadataItem.getKeyword().equals("Headline")) {
					System.out.printf("item:\n\t%s\n\t%s\n\t%s\n\t%s\n\n",
							metadataItem.getClass(),
							imgMetadataItem.getKeyword(),
							imgMetadataItem.getText(), str2);
				}
				// IptcTests.printBinary(metadataItem.toString().getBytes("UTF8"));
				/*
				 * System.out.printf("item: %s\n", new String(item.toString()
				 * .getBytes("ascii")));
				 */

			}
		}
	}

	@Test
	public void encodingTest2() {
		OutputStreamWriter out = new OutputStreamWriter(
				new ByteArrayOutputStream());
		System.out.println(out.getEncoding());
	}

	@Test
	public void decodeStringTest() throws CharacterCodingException {
		System.out
				.print(decodeString(
						"МУЗ ТВ. Мы умеем зажигать. Все хиты осени 2010. Крокус Сити Холл",
						"cp1251"));
	}

	public static String decodeString(String string, String sourceEncoding)
			throws CharacterCodingException {
		Charset charset = Charset.forName(sourceEncoding);
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();
		ByteBuffer bbuf = encoder.encode(CharBuffer.wrap(string));
		CharBuffer cbuf = decoder.decode(bbuf);
		String s = cbuf.toString();
		return s;
	}
}
