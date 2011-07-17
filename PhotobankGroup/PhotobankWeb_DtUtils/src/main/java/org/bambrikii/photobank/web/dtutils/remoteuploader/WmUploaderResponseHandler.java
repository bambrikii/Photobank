package org.bambrikii.photobank.web.dtutils.remoteuploader;

public class WmUploaderResponseHandler implements RemoteUploaderResponseListener {
	public void uploaded(String filename, long length, String response) {
		System.out.printf("%s, File1 Length = %s. %s\n", filename, length,
				response);
	}
}
