package org.bambrikii.photobank.business.managers.imageprocessing;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsedFileName {
	protected static final String CFG_IMAGE_FILENAME_MATCH = "^(\\d+)\\_(\\w+)\\_(\\d{2,2})(\\d{2,2})(\\d{2,2})\\_((\\w|\\d)+)\\.\\w+$";

	private String sourceFileName;
	private String seqNumber;
	private String type;
	private String day;
	private String month;
	private String year;
	private String author;

	public ParsedFileName() {

	}

	public ParsedFileName(String fileName) {
		parse(fileName);
	}

	protected void setSeqNumber(String seqNumber) {
		this.seqNumber = seqNumber;
	}

	public String getSeqNumber() {
		return seqNumber;
	}

	protected void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	protected void setMonth(String month) {
		this.month = month;
	}

	public String getMonth() {
		return month;
	}

	protected void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	protected void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	protected void setSourceFileName(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}

	public String getSourceFileName() {
		return sourceFileName;
	}

	public void parse(String fileName) {
		Pattern pattern = Pattern
				.compile(ParsedFileName.CFG_IMAGE_FILENAME_MATCH);
		Matcher matcher = pattern.matcher(fileName);
		while (matcher.find()) {
			setSeqNumber(matcher.group(1));
			setType(matcher.group(2));
			setDay(matcher.group(3));
			setMonth(matcher.group(4));
			setYear(matcher.group(5));
			setAuthor(matcher.group(6));
			setSourceFileName(fileName);
		}
	}

	public String getGeneratedName() throws ParsedFileNameException {
		if (getYear() == null || getMonth() == null || getDay() == null
				|| getSourceFileName() == null) {
			throw new ParsedFileNameException(
					"Cannot generate file name. Parts of date are null.");
		}
		return getYear() + "/" + getMonth() + "/" + getDay() + "/"
				+ getSourceFileName();
	}

	public String toString() {
		return MessageFormat.format("{0}, {1}, {2}, {3}, {4}, {5}",
				getSeqNumber(), getType(), getDay(), getMonth(), getYear(),
				getAuthor());

	}
}
