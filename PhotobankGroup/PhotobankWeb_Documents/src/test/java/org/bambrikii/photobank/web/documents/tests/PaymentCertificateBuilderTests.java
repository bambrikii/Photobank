package org.bambrikii.photobank.web.documents.tests;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.bambrikii.photobank.web.documents.DocumentGenerationException;
import org.bambrikii.photobank.web.documents.PaymentCertificateDataItem;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateBuilder;
import org.bambrikii.photobank.web.documents.paymentcertificates.PaymentCertificateData;
import org.bambrikii.photobank.web.documents.paymentcertificates.impl.PaymentCertificateBuilderRU;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PaymentCertificateBuilderTests {

	private Integer number;
	private Date date;
	private String currency;
	private String licensee;
	private List<PaymentCertificateDataItem> items;
	private Double total;

	private PaymentCertificateData data;

	@Before
	public void before() {
		number = 123;
		date = Calendar.getInstance().getTime();
		currency = "\u0440\u0443\u0431.";
		licensee = "\u0418\u0432\u0430\u043d\u043e\u0432 \u0418.\u0418.";
		total = 0123.456d;
		items = new LinkedList<PaymentCertificateDataItem>() {
			private static final long serialVersionUID = 1L;
			{
				add(new PaymentCertificateDataItem() {
					{
						setFilename("012321313213_123");
						setName("asdasdlkasjdlka asd");
						setPrice(150d);
						setSizeName("web");
					}
				});
				add(new PaymentCertificateDataItem() {
					{
						setFilename("012321313213_123");
						setName("asdasdlkasjdlka asd");
						setPrice(150d);
						setSizeName("web");
					}
				});
				add(new PaymentCertificateDataItem() {
					{
						setFilename("012321313213_123");
						setName("asdasdlkasjdlka asd");
						setPrice(150d);
						setSizeName("web");
					}
				});
				add(new PaymentCertificateDataItem() {
					{
						setFilename("012321313213_123");
						setName("asdasdlkasjdlka asd");
						setPrice(150d);
						setSizeName("web");
					}
				});
				add(new PaymentCertificateDataItem() {
					{
						setFilename("012321313213_123");
						setName("asdasdlkasjdlka asd");
						setPrice(150d);
						setSizeName("web");
					}
				});

			}
		};
		data = new PaymentCertificateData();
		data.setCurrency(currency);
		data.setDate(date);
		data.setLicensee(licensee);
		data.setNumber(number);
		data.setItems(items);
		data.setTotal(total);
	}

	@Test
	@Ignore
	public void localizedMonthNamesTests() {
		DateFormatSymbols symbols = new DateFormatSymbols(new Locale("ru"));
		for (String name : symbols.getMonths()) {
			System.out.printf("%s\n", name);
		}
	}

	@Test
	public void listSystemProperties() {
		Properties props = System.getProperties();
		Enumeration<?> enum1 = props.propertyNames();
		for (; enum1.hasMoreElements();) {
			String propName = (String) enum1.nextElement();
			String propValue = (String) props.get(propName);
			System.out.printf("%s: %s\n", propName, propValue);
		}
	}

	@Test
	public void createTest2() throws DocumentGenerationException, IOException {
		PaymentCertificateBuilder b = new PaymentCertificateBuilderRU();
		b.setData(data);
		String filename = System.getProperty("user.dir")
				+ "/src/test/resources/test2.pdf";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		b.build(bos);

		FileOutputStream fos = new FileOutputStream(filename);
		fos.write(bos.toByteArray());
		fos.flush();
		fos.close();
		bos.close();
	}

	@Test
	public void testDate() {
		Calendar cal = Calendar.getInstance();
		System.out.printf("%s", cal.get(Calendar.YEAR));
		String actNumber = MessageFormat
				.format("\u0410\u043a\u0442 \u2116 {0} \u043e\u0442 \u00ab{1}\u00bb {2} {3} \u0433\u043e\u0434\u0430",
						1, cal.get(Calendar.DAY_OF_MONTH),
						cal.get(Calendar.MONTH),
						String.valueOf(cal.get(Calendar.YEAR)));
		System.out.printf("%s\n", actNumber);
	}
}
