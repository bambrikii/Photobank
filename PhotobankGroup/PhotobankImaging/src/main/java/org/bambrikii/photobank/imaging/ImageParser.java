package org.bambrikii.photobank.imaging;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.Interpolation;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.ScaleDescriptor;

public class ImageParser {

	public static void resize(String srcFileName, String dstFileName,
			int destMaxDim) throws IOException {
		PlanarImage image = JAI.create("fileload", srcFileName);
		int currWidth = image.getWidth();
		int currHeight = image.getHeight();
		float ratio = destMaxDim
				/ (float) (currWidth > currHeight ? currWidth : currHeight);
		RenderedOp renderedOp = ScaleDescriptor.create(image, new Float(ratio),
				new Float(ratio), new Float(0.0f), new Float(0.0f),
				Interpolation.getInstance(Interpolation.INTERP_BICUBIC), null);
		// TODO: Should implement various image formats!
		String dstFormat = getFormat(srcFileName);
		write(renderedOp.getAsBufferedImage(), dstFormat, dstFileName);
	}

	private static void write(BufferedImage input, String dstFormat, String name)
			throws IOException {
		Iterator<ImageWriter> iter = ImageIO
				.getImageWritersByFormatName(dstFormat);
		if (iter.hasNext()) {
			ImageWriter writer = (ImageWriter) iter.next();
			ImageWriteParam iwp = writer.getDefaultWriteParam();
			iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			iwp.setCompressionQuality(1.00f);
			File outFile = new File(name);
			FileImageOutputStream output = new FileImageOutputStream(outFile);
			writer.setOutput(output);
			IIOImage image = new IIOImage(input, null, null);
			writer.write(null, image, iwp);
			output.close();
		}
	}

	public static String getFormat(String fileName) throws IOException {
		String format = null;
		File file = new File(fileName);
		ImageInputStream iis = ImageIO.createImageInputStream(file);
		Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);

		while (readers.hasNext()) {
			ImageReader read = readers.next();
			format = read.getFormatName();
		}
		return format;
	}

	public static String watermark(String srcFileName, String wmFileName,
			String dstFileName) throws IOException {
		File waterMarkFile = new File(wmFileName);
		File inputFile = new File(srcFileName);
		File outputFile = new File(dstFileName);

		BufferedImage waterMark = ImageIO.read(waterMarkFile);

		// You probably want to loop the rest if you have many images
		BufferedImage image = ImageIO.read(inputFile);
		Graphics2D g = image.createGraphics();
		try {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					0.5f));// 50% transp
			g.drawImage(waterMark, image.getWidth() - waterMark.getWidth(),
					image.getHeight() - waterMark.getHeight(), null); // draw in
																		// lower
																		// right
																		// corner
		} finally {
			g.dispose();
		}
		ImageIO.write(image, "JPEG", outputFile);
		return dstFileName;
	}
}
