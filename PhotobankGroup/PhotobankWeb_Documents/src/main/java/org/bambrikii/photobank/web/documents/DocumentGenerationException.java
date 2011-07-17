package org.bambrikii.photobank.web.documents;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.lowagie.text.DocumentException;

public class DocumentGenerationException extends Exception {
	private static final long serialVersionUID = -4352447024862481454L;

	public DocumentGenerationException(String message, FileNotFoundException e) {
		super(message, e);
	}

	public DocumentGenerationException(String message, DocumentException e) {
		super(message, e);
	}

	public DocumentGenerationException(String message, IOException e) {
		super(message, e);
	}

}
