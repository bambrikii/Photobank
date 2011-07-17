package org.bambrikii.photobank.imaging.tests;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.bambrikii.photobank.imaging.ImageStreamParser;
import org.junit.Test;

public class ImageStreamParserTests {
	@Test
	public void fileFormatTest() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				Constants.fileNamePS));
		String format = ImageStreamParser.getFormat(is);
		Assert.assertTrue(format == "JPEG");
		System.out.print(format);
	}

	@Test
	public void watermarkTest() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				Constants.fileNamePS));
		InputStream wmIs = new BufferedInputStream(new FileInputStream(
				Constants.fileNameWatermark1png));
		FileOutputStream fos = new FileOutputStream(new File(
				Constants.fileNameTemp));
		ImageStreamParser.watermark(is, wmIs, fos);
		fos.flush();
		fos.close();
	}

	@Test
	public void resize() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(
				Constants.fileNamePS));
		InputStream wmIs = new BufferedInputStream(new FileInputStream(
				Constants.fileNameWatermark1png));
		FileOutputStream fos = new FileOutputStream(new File(
				Constants.fileNameTemp));
		ImageStreamParser.resize(is, 100, fos);
		fos.flush();
		fos.close();
	}
}
