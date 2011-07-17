package org.bambrikii.photobank.web.dtutils.remoteuploader;

public interface RemoteUploaderResponseListener {
	void uploaded(String name, long length, String response);
}