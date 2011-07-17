package org.bambrikii.photobank.imaging;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import javax.media.jai.Interpolation;
import javax.media.jai.JAI;
import javax.media.jai.PlanarImage;
import javax.media.jai.RenderedOp;
import javax.media.jai.operator.ScaleDescriptor;

import com.sun.media.jai.codec.SeekableStream;

public class ImageStreamParser {

	public static void resize(InputStream srcStream, int destMaxDim,
			OutputStream outputStream) throws IOException {
		SeekableStream srcSeakableStream = SeekableStream.wrapInputStream(
				srcStream, true);
		String dstFormat = getFormat(srcStream);
		PlanarImage image = JAI.create("stream", srcSeakableStream);
		int currWidth = image.getWidth();
		int currHeight = image.getHeight();
		float ratio = destMaxDim
				/ (float) (currWidth > currHeight ? currWidth : currHeight);
		RenderedOp renderedOp = ScaleDescriptor.create(image, new Float(ratio),
				new Float(ratio), new Float(0.0f), new Float(0.0f),
				Interpolation.getInstance(Interpolation.INTERP_BICUBIC), null);
		write(renderedOp.getAsBufferedImage(), dstFormat, outputStream);
	}

	private static void write(BufferedImage input, String dstFormat,
			OutputStream outputStream) throws IOException {
		Iterator<ImageWriter> iter = ImageIO
				.getImageWritersByFormatName(dstFormat);
		if (iter.hasNext()) {
			ImageWriter writer = (ImageWriter) iter.next();
			ImageWriteParam iwp = writer.getDefaultWriteParam();
			iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			iwp.setCompressionQuality(1.00f);
			OutputStream os = new ByteArrayOutputStream();
			writer.setOutput(os);
			IIOImage image = new IIOImage(input, null, null);
			writer.write(null, image, iwp);
			os.close();
		}
	}

	public static String getFormat(InputStream srcStream) throws IOException {
		String format = null;
		ImageInputStream iis = ImageIO.createImageInputStream(srcStream);
		Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
		while (readers.hasNext()) {
			ImageReader read = readers.next();
			format = read.getFormatName();
		}
		return format;
	}

	public static void watermark(InputStream srcStream, InputStream wmStream,
			OutputStream outputStream) throws IOException {

		BufferedImage waterMark = ImageIO.read(wmStream);

		BufferedImage image = ImageIO.read(srcStream);
		Graphics2D g = image.createGraphics();
		try {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					0.5f));
			g.drawImage(waterMark, image.getWidth() - waterMark.getWidth(),
					image.getHeight() - waterMark.getHeight(), null);
		} finally {
			g.dispose();
		}
		ImageIO.write(image, "JPEG", outputStream);
	}
}
