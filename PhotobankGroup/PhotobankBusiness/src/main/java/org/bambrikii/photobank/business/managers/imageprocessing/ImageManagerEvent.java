package org.bambrikii.photobank.business.managers.imageprocessing;

import java.util.Map;

public class ImageManagerEvent {

	private ParsedFileName parsedFileName;
	private Map<String, Map<String, String>> metadataMap;

	public void setMetadataMap(Map<String, Map<String, String>> metadataMap) {
		this.metadataMap = metadataMap;
	}

	public Map<String, Map<String, String>> getMetadataMap() {
		return metadataMap;
	}

	public ParsedFileName getParsedFileName() {
		return parsedFileName;
	}

	public void setParsedFileName(ParsedFileName parsedFileName) {
		this.parsedFileName = parsedFileName;
	}
}
