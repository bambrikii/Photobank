package org.bambrikii.photobank.web.documents.paymentcertificates.impl;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.bambrikii.photobank.web.documents.DocumentGenerationException;
import org.bambrikii.photobank.web.documents.PaymentCertificateDataItem;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateBuilder;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateData;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PaymentCertificateBuilderRU implements PaymentCertificateBuilder {
	private PaymentCertificateData data;
	private Locale locale;

	private Map<Integer, String> monthsGenitiveCase = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 3932790549625923303L;
		{
			put(0, "\u042f\u043d\u0432\u0430\u0440\u044f");
			put(1, "\u0424\u0435\u0432\u0440\u0430\u043b\u044f");
			put(2, "\u041c\u0430\u0440\u0442\u0430");
			put(3, "\u0410\u043f\u0440\u0435\u043b\u044f");
			put(4, "\u041c\u0430\u044f");
			put(5, "\u0418\u044e\u043d\u044f");
			put(6, "\u0418\u044e\u043b\u044f");
			put(7, "\u0410\u0432\u0433\u0443\u0441\u0442\u0430");
			put(8, "\u0421\u0435\u043d\u0442\u044f\u0431\u0440\u044f");
			put(9, "\u041e\u043a\u0442\u044f\u0431\u0440\u044f");
			put(10, "\u041d\u043e\u044f\u0431\u0440\u044f");
			put(11, "\u0414\u0435\u043a\u0430\u0431\u0440\u044f");
		}
	};

	private String resourcesPath = "src/main/resources/";

	public PaymentCertificateBuilderRU() {
		setLocale(new Locale("ru"));
	}

	public void setResourcesPath(String resourcesPath) {
		this.resourcesPath = resourcesPath;
	}

	public String getResourcesPath() {
		return resourcesPath;
	}

	public void setData(PaymentCertificateData data) {
		this.data = data;
	}

	protected PaymentCertificateData getData() {
		return data;
	}

	public void build(OutputStream outputStream)
			throws DocumentGenerationException {
		Document doc = new Document(PageSize.A4);
		PdfWriter writer;
		BaseFont baseFont = null;
		try {
			writer = PdfWriter.getInstance(doc, outputStream);

			writer.setEncryption(null, "qweasdzxc".getBytes(),
					PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);

			doc.open();

			String baseFontPath = getResourcesPath()
					+ "org/bambrikii/photobank/web/documents/ARIAL.TTF";
			final String stampImagePath = getResourcesPath()
					+ "org/bambrikii/photobank/web/documents/paymentcertificates/PersonaStarsStamp.png";
			baseFont = BaseFont.createFont(baseFontPath, "Cp1251", true);

			Font baseTextStyle = new com.lowagie.text.Font(baseFont, 10,
					com.lowagie.text.Font.NORMAL, new Color(0, 0, 0));
			Font baseBoldTextStyle = new com.lowagie.text.Font(baseFont, 10,
					com.lowagie.text.Font.BOLD, new Color(0, 0, 0));

			Calendar cal = Calendar.getInstance(getLocale());
			cal.setTime(getData().getDate());

			// Act number
			String actNumber = MessageFormat
					.format("\u0410\u043a\u0442 \u2116 {0} \u043e\u0442 \u00ab{1}\u00bb {2} {3} \u0433\u043e\u0434\u0430",
							String.valueOf(getData().getNumber()), cal
									.get(Calendar.DAY_OF_MONTH),
							monthsGenitiveCase.get(cal.get(Calendar.MONTH))
									.toLowerCase(), String.valueOf(cal
									.get(Calendar.YEAR)));
			Paragraph actNumberParagraph = new Paragraph(actNumber,
					new com.lowagie.text.Font(baseFont, 12,
							com.lowagie.text.Font.BOLD, new Color(0, 0, 0)));
			actNumberParagraph.setSpacingAfter(19);

			Paragraph cityParagraph = new Paragraph(
					"\u0433. \u041c\u043e\u0441\u043a\u0432\u0430",
					baseTextStyle);
			cityParagraph.setSpacingAfter(15);

			// Licensor
			Paragraph licensorParagraph = new Paragraph();
			licensorParagraph.add(new Chunk(
					"\u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0440: ",
					baseBoldTextStyle));
			licensorParagraph
					.add(new Chunk(
							MessageFormat
									.format("{0}",
											"\u0418\u043d\u0434\u0438\u0432\u0438\u0434\u0443\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0435\u0434\u043f\u0440\u0438\u043d\u0438\u043c\u0430\u0442\u0435\u043b\u044c \u041b\u0438\u043f\u0430\u0442\u043d\u0438\u043a\u043e\u0432 \u0415\u0432\u0433\u0435\u043d\u0438\u0439 \u0410\u0440\u043a\u0430\u0434\u044c\u0435\u0432\u0438\u0447, \u0434\u0435\u0439\u0441\u0442\u0432\u0443\u044e\u0449\u0438\u0439 \u043d\u0430 \u043e\u0441\u043d\u043e\u0432\u0430\u043d\u0438\u0438 \u0421\u0432\u0438\u0434\u0435\u0442\u0435\u043b\u044c\u0441\u0442\u0432\u0430 \u041e\u0413\u0420\u041d \u2116 305501025600011 \u043e\u0442 13.09.2005\u0433."),
							baseTextStyle));
			licensorParagraph.setSpacingAfter(15);

			// Licensee
			Paragraph licenseeParagraph = new Paragraph();
			licenseeParagraph.add(new Chunk(
					"\u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0442: ",
					baseBoldTextStyle));
			licenseeParagraph.add(new Chunk(getData().getLicensee(),
					baseTextStyle));
			licenseeParagraph.setSpacingAfter(15);

			// Pre text
			Paragraph pretextParagraph = new Paragraph();
			pretextParagraph
					.add(new Chunk(
							"\u0412 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0438\u0438 \u0441 \u0414\u043e\u0433\u043e\u0432\u043e\u0440\u043e\u043c \u041e\u0444\u0435\u0440\u0442\u044b \u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0440 \u043f\u0435\u0440\u0435\u0434\u0430\u043b \u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0442\u0443 \u0441\u043b\u0435\u0434\u0443\u044e\u0449\u0438\u0435 \u0424\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f (\u0446\u0438\u0444\u0440\u043e\u0432\u044b\u0435 \u043a\u043e\u043f\u0438\u0438) \u0438 \u043d\u0435\u0438\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0435 \u0438\u043c\u0443\u0449\u0435\u0441\u0442\u0432\u0435\u043d\u043d\u044b\u0435 \u043f\u0440\u0430\u0432\u0430 \u043d\u0430 \u0438\u0445 \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u043d\u0438\u0435 (\u0434\u0430\u043b\u0435\u0435 \u043f\u0440\u0430\u0432\u0430 \u043d\u0430 \u0424\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f): ",
							baseTextStyle));
			pretextParagraph.setSpacingAfter(15);

			int defaultLeading = 9;
			// Files table
			Table filesTbl = new Table(5);
			filesTbl.setWidths(new int[] { 5, 35, 35, 10, 15 });
			filesTbl.setBorder(Table.RECTANGLE);
			filesTbl.setBorderWidth(1);
			filesTbl.setSpacing(0);
			filesTbl.setPadding(2);
			filesTbl.setCellsFitPage(false);
			filesTbl.setUseVariableBorders(true);
			filesTbl.setAlignment(Element.ALIGN_LEFT);
			filesTbl.setWidth(100);

			Cell cellheader1 = new Cell(new Phrase(new Chunk("\u2116",
					baseBoldTextStyle)));
			cellheader1.setHeader(true);
			cellheader1.setLeading(defaultLeading);
			cellheader1.setHorizontalAlignment(Cell.ALIGN_CENTER);
			filesTbl.addCell(cellheader1);

			Cell cellheader2 = new Cell(new Phrase(new Chunk(
					"\u041d\u043e\u043c\u0435\u0440 \u0444\u043e\u0442\u043e",
					baseBoldTextStyle)));
			cellheader2.setHeader(true);
			cellheader2.setLeading(defaultLeading);
			cellheader2.setHorizontalAlignment(Cell.ALIGN_CENTER);
			filesTbl.addCell(cellheader2);

			Cell cellheader3 = new Cell(new Phrase(new Chunk(
					"\u041f\u0435\u0440\u0441\u043e\u043d\u0430",
					baseBoldTextStyle)));
			cellheader3.setHeader(true);
			cellheader3.setLeading(defaultLeading);
			cellheader3.setHorizontalAlignment(Cell.ALIGN_CENTER);
			filesTbl.addCell(cellheader3);

			Cell cellheader4 = new Cell(new Phrase(new Chunk(
					"\u0420\u0430\u0437\u043c\u0435\u0440", baseBoldTextStyle)));
			cellheader4.setHeader(true);
			cellheader4.setLeading(defaultLeading);
			cellheader4.setHorizontalAlignment(Cell.ALIGN_CENTER);
			filesTbl.addCell(cellheader4);

			Cell cellheader5 = new Cell(new Phrase(new Chunk(
					"\u0426\u0435\u043d\u0430 \u0440\u0443\u0431.",
					baseBoldTextStyle)));
			cellheader5.setHeader(true);
			cellheader5.setLeading(defaultLeading);
			cellheader5.setHorizontalAlignment(Cell.ALIGN_CENTER);
			filesTbl.addCell(cellheader5);
			filesTbl.endHeaders();

			Integer i = 0;
			for (PaymentCertificateDataItem item : getData().getItems()) {
				i++;
				Cell cell1 = new Cell(new Phrase(new Chunk(Integer.toString(i),
						baseTextStyle)));
				cell1.setLeading(defaultLeading);
				cell1.setHorizontalAlignment(Cell.ALIGN_CENTER);
				cell1.setBorder(Cell.NO_BORDER);
				filesTbl.addCell(cell1);

				Cell cell2 = new Cell(new Phrase(new Chunk(item.getFilename(),
						baseTextStyle)));
				cell2.setLeading(defaultLeading);
				cell2.setHorizontalAlignment(Cell.ALIGN_LEFT);
				cell2.setBorder(Cell.NO_BORDER);
				filesTbl.addCell(cell2);

				Cell cell3 = new Cell(new Phrase(new Chunk(item.getName(),
						baseTextStyle)));
				cell3.setLeading(defaultLeading);
				cell3.setHorizontalAlignment(Cell.ALIGN_LEFT);
				cell3.setBorder(Cell.NO_BORDER);
				filesTbl.addCell(cell3);

				Cell cell4 = new Cell(new Phrase(new Chunk(item.getSizeName(),
						baseTextStyle)));
				cell4.setLeading(defaultLeading);
				cell4.setHorizontalAlignment(Cell.ALIGN_CENTER);
				cell4.setBorder(Cell.NO_BORDER);
				filesTbl.addCell(cell4);

				Cell cell5 = new Cell(new Phrase(new Chunk(Double.toString(item
						.getPrice()), baseTextStyle)));
				cell5.setLeading(defaultLeading);
				cell5.setHorizontalAlignment(Cell.ALIGN_CENTER);
				cell5.setBorder(Cell.NO_BORDER);
				filesTbl.addCell(cell5);
			}
			filesTbl.complete();

			// filesTbl.normalize();

			String totalPrice = MessageFormat.format("{0} {1}", String
					.valueOf(getData().getTotal()), getData().getCurrency());

			Paragraph totalParagraph = new Paragraph();
			totalParagraph.setAlignment(Paragraph.ALIGN_RIGHT);

			totalParagraph.add(new Chunk("\u0418\u0442\u043e\u0433\u043e: ",
					baseTextStyle));
			totalParagraph.add(new Chunk(totalPrice, baseBoldTextStyle));
			totalParagraph.setSpacingAfter(25);

			Paragraph posttext1Paragraph = new Paragraph();
			posttext1Paragraph
					.add(new Chunk(
							"\u0412\u043e\u0437\u043d\u0430\u0433\u0440\u0430\u0436\u0434\u0435\u043d\u0438\u0435 \u0437\u0430 \u043f\u0440\u0430\u0432\u0430 \u043d\u0430 \u0424\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f \u0441\u043e\u0441\u0442\u0430\u0432\u043b\u044f\u0435\u0442: ",
							baseTextStyle));
			posttext1Paragraph.add(new Chunk(totalPrice, baseBoldTextStyle));
			// posttext1Paragraph.setSpacingAfter(15);

			Paragraph posttext2Paragraph = new Paragraph(
					"\u041d\u0414\u0421 \u043d\u0435 \u043e\u0431\u043b\u0430\u0433\u0430\u0435\u0442\u0441\u044f, \u0432 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0438\u0438 \u0441 \u043f\u0443\u043d\u043a\u0442\u0430\u043c\u0438 2, 3 \u0438 5 \u0441\u0442\u0430\u0442\u044c\u0438 346.11 \u041d\u0430\u043b\u043e\u0433\u043e\u0432\u043e\u0433\u043e \u043a\u043e\u0434\u0435\u043a\u0441\u0430 \u0420\u043e\u0441\u0441\u0438\u0439\u0441\u043a\u043e\u0439 \u0424\u0435\u0434\u0435\u0440\u0430\u0446\u0438\u0438.",
					baseTextStyle);
			posttext2Paragraph.setSpacingAfter(15);

			Paragraph posttext3Paragraph = new Paragraph(
					"\u041f\u0440\u0430\u0432\u0430 \u043d\u0430 \u0424\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f \u043f\u0435\u0440\u0435\u0434\u0430\u044e\u0442\u0441\u044f \u0441\u0440\u043e\u043a\u043e\u043c \u043d\u0430 1 (\u043e\u0434\u0438\u043d) \u0433\u043e\u0434 \u0441 \u0434\u0430\u0442\u044b \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u043e\u0439 \u0432 \u0410\u043a\u0442\u0435.",
					baseTextStyle);
			posttext3Paragraph.setSpacingAfter(15);

			Paragraph posttext4Paragraph = new Paragraph();
			posttext4Paragraph
					.add(new Chunk(
							"\u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0442 \u043d\u0435 \u0432\u043f\u0440\u0430\u0432\u0435 ",
							baseTextStyle));
			posttext4Paragraph
					.add(new Chunk(
							"(\u0437\u0430\u043f\u0440\u0435\u0449\u0430\u0435\u0442\u0441\u044f)",
							baseBoldTextStyle));
			posttext4Paragraph
					.add(new Chunk(
							": \u0440\u0430\u0441\u043f\u0440\u043e\u0441\u0442\u0440\u0430\u043d\u044f\u0442\u044c \u0438 \u0434\u0435\u043b\u0430\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u043c\u0438 \u043a\u043e\u043f\u0438\u0438 \u0444\u0430\u0439\u043b\u043e\u0432 \u0441 \u0444\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f\u043c\u0438; \u043f\u0440\u043e\u0434\u0430\u0432\u0430\u0442\u044c, \u0441\u0434\u0430\u0432\u0430\u0442\u044c \u0432 \u043f\u0440\u043e\u043a\u0430\u0442, \u0430\u0440\u0435\u043d\u0434\u0443, \u043b\u0438\u0437\u0438\u043d\u0433, \u043a\u0430\u043a \u0441\u0430\u043c\u0438 \u0444\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f, \u0442\u0430\u043a \u0438 \u0444\u0430\u0439\u043b\u044b \u0441 \u0444\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f\u043c\u0438; \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u044c \u0444\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f \u0432 \u0434\u0438\u0437\u0430\u0439\u043d\u0435 \u043a\u0430\u043b\u0435\u043d\u0434\u0430\u0440\u0435\u0439, \u043f\u043e\u0447\u0442\u043e\u0432\u044b\u0445 \u043a\u0430\u0440\u0442\u043e\u0447\u0435\u043a \u0438 \u043e\u0442\u043a\u0440\u044b\u0442\u043e\u043a, \u043f\u043e\u0441\u0442\u0435\u0440\u043e\u0432 \u0438 \u043e\u0431\u0440\u0430\u043c\u043b\u0435\u043d\u043d\u044b\u0445 \u0440\u0435\u043f\u0440\u043e\u0434\u0443\u043a\u0446\u0438\u0439 \u0432 \u0446\u0435\u043b\u044f\u0445 \u043f\u0440\u043e\u0434\u0430\u0436\u0438; \u043f\u043e\u043c\u0435\u0449\u0430\u0442\u044c \u0444\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f \u0432 \u0441\u0435\u0442\u044c \u0418\u043d\u0442\u0435\u0440\u043d\u0435\u0442 \u0432 \u0444\u043e\u0440\u043c\u0430\u0442\u0435, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u043c \u0434\u043b\u044f \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438 \u0442\u0440\u0435\u0442\u044c\u0438\u043c\u0438 \u043b\u0438\u0446\u0430\u043c\u0438, \u0442\u0435\u043c \u0441\u0430\u043c\u044b\u043c, \u0434\u0435\u043b\u0430\u044f \u0438\u0445 \u043e\u0431\u0449\u0435\u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u043c\u0438.",
							baseTextStyle));
			posttext4Paragraph.setSpacingAfter(15);

			Paragraph posttext5Paragraph = new Paragraph(
					"\u0421\u0442\u043e\u0440\u043e\u043d\u044b \u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0430\u044e\u0442, \u0447\u0442\u043e \u0443\u0441\u043b\u0443\u0433\u0438 \u043f\u043e \u043f\u0435\u0440\u0435\u0434\u0430\u0447\u0435 \u043f\u0440\u0430\u0432 \u043d\u0430 \u0424\u043e\u0442\u043e\u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u044f \u0432\u044b\u043f\u043e\u043b\u043d\u0435\u043d\u044b \u043d\u0430\u0434\u043b\u0435\u0436\u0430\u0449\u0438\u043c \u043e\u0431\u0440\u0430\u0437\u043e\u043c \u0438 \u0432 \u043f\u043e\u043b\u043d\u043e\u043c \u043e\u0431\u044a\u0435\u043c\u0435. \u0421\u0442\u043e\u0440\u043e\u043d\u044b \u043f\u0440\u0435\u0442\u0435\u043d\u0437\u0438\u0439 \u0434\u0440\u0443\u0433 \u043a \u0434\u0440\u0443\u0433\u0443 \u043d\u0435 \u0438\u043c\u0435\u044e\u0442.",
					baseTextStyle);
			posttext5Paragraph.setSpacingAfter(15);

			// Signatures
			Table signaturesTable = new Table(4);
			signaturesTable.setWidths(new int[] { 10, 40, 10, 40 });
			signaturesTable.setWidth(100);
			signaturesTable.setSpacing(0);
			signaturesTable.setPadding(5);
			signaturesTable.setBorder(Table.NO_BORDER);

			Cell licensorSignature1Cell = new Cell(new Phrase(new Chunk(
					"\u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0440:",
					baseBoldTextStyle)));
			licensorSignature1Cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			licensorSignature1Cell.setBorder(Cell.NO_BORDER);

			Cell licensorSignature2Cell = new Cell(
					new Phrase(
							new Chunk(
									"______________/ \u041b\u0438\u043f\u0430\u0442\u043d\u0438\u043a\u043e\u0432 \u0415.\u0410. /",
									baseTextStyle)));
			licensorSignature2Cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			licensorSignature2Cell.setBorder(Cell.NO_BORDER);
			licensorSignature2Cell.addElement(new Paragraph("\n\n\n\n"));
			licensorSignature2Cell.add(
			// Stamp
					Image.getInstance(stampImagePath));

			Cell licenseeSignature1Cell = new Cell(new Phrase(new Chunk(
					"\u041b\u0438\u0446\u0435\u043d\u0437\u0438\u0430\u0442:",
					baseBoldTextStyle)));
			licenseeSignature1Cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			licenseeSignature1Cell.setBorder(Cell.NO_BORDER);

			Cell licenseeSignature2Cell = new Cell(new Phrase(new Chunk(
					MessageFormat.format("______________/ {0} /", getData()
							.getLicensee()), baseTextStyle)));
			licenseeSignature2Cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			licenseeSignature2Cell.setBorder(Cell.NO_BORDER);

			signaturesTable.addCell(new Cell() {
				{
					setBorder(Cell.NO_BORDER);
				}
			});
			signaturesTable.addCell(licensorSignature1Cell);
			signaturesTable.addCell(new Cell(true) {
				{
					setBorder(Cell.NO_BORDER);
				}
			});
			signaturesTable.addCell(licenseeSignature1Cell);
			signaturesTable.addCell(new Cell(true) {
				{
					setBorder(Cell.NO_BORDER);
				}
			});
			signaturesTable.addCell(licensorSignature2Cell);
			signaturesTable.addCell(new Cell(true) {
				{
					setBorder(Cell.NO_BORDER);
				}
			});
			signaturesTable.addCell(licenseeSignature2Cell);

			signaturesTable.addCell(new Cell(true) {
				{
					setBorder(Cell.NO_BORDER);
				}
			});
			signaturesTable.addCell(new Cell(true) {
				{
					setBorder(Cell.NO_BORDER);
				}
			});

			signaturesTable.complete();
			// PdfPTable signaturePdPfTable = signaturesTable.createPdfPTable();

			// Document items
			doc.add(actNumberParagraph);
			doc.add(cityParagraph);
			doc.add(licensorParagraph);
			doc.add(licenseeParagraph);
			doc.add(pretextParagraph);
			doc.add(filesTbl);
			doc.add(totalParagraph);
			doc.add(posttext1Paragraph);
			doc.add(posttext2Paragraph);
			doc.add(posttext3Paragraph);
			doc.add(posttext4Paragraph);
			doc.add(posttext5Paragraph);
			doc.add(signaturesTable);

			doc.close();
		} catch (DocumentException ex) {
			throw new DocumentGenerationException(
					"Exception creating document.", ex);
		} catch (IOException ex) {
			throw new DocumentGenerationException(
					"Exception creating document, required font file may not be found.",
					ex);
		}
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}
}
