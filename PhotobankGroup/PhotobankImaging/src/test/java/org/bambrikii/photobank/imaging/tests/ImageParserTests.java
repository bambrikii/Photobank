package org.bambrikii.photobank.imaging.tests;

import java.awt.image.RenderedImage;
import java.io.IOException;

import javax.media.jai.JAI;

import junit.framework.Assert;

import org.bambrikii.photobank.imaging.ImageParser;
import org.junit.Ignore;
import org.junit.Test;

public class ImageParserTests {
	public static String baseImFile = "src/test/resources/300626_R_220710_044.JPG";// Constants.fileNamePS;
	public static String waterImFile = "src/test/resources/watermark1.png";
	public static String dstFileName = "src/test/resources/300626_R_220710_044.2.JPG";

	@Test
	public void resizeTest() throws IOException {
		ImageParser.resize(Constants.fileNamePP, Constants.fileNameTemp, 150);
	}

	@Test
	public void fileFormatTest() throws IOException {
		String format = ImageParser.getFormat(Constants.fileNamePP);
		Assert.assertTrue(format == "JPEG");
		System.out.print(format);
	}

	@Test
	@Ignore
	public void watermarkImageTest() {
		RenderedImage im1;
		RenderedImage im2;
		RenderedImage im3;

		im1 = JAI.create("fileload", baseImFile);
		im2 = JAI.create("fileload", waterImFile);
		im3 = JAI.create("overlay", im1, im2);
		JAI.create("filestore", im3, dstFileName);
	}

	@Test
	public void watermarkImageTest2() throws IOException {
		ImageParser.watermark(Constants.fileNamePS,
				Constants.fileNameWatermark1png, Constants.fileNameTemp);
	}
}
