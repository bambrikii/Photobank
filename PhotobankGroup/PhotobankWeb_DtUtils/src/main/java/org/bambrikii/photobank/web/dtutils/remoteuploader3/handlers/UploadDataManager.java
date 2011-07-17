package org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.bambrikii.photobank.web.dtutils.remoteuploader3.core.CustomUploadException;
import org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer.PersistenceContainer;

public class UploadDataManager {
	public static void marshal(PersistenceContainer pc1, String dstfilename)
			throws CustomUploadException {
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(PersistenceContainer.class);
		} catch (JAXBException e) {
			throw new CustomUploadException("Failed to get JAXB context.");
		}

		java.io.FileOutputStream fos;
		try {
			fos = new FileOutputStream(dstfilename);
			try {

				Marshaller marshaller = ctx.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
				marshaller.marshal(pc1, fos);
			} finally {
				if (fos != null) {
					fos.close();
				}
			}
		} catch (JAXBException e) {
			throw new CustomUploadException("Marshalling failed", e);
		} catch (FileNotFoundException e) {
			throw new CustomUploadException("Marshalling failed", e);
		} catch (IOException e) {
			throw new CustomUploadException("Marshalling failed", e);
		}
	}

	public static PersistenceContainer unmarshal(String srcfilename)
			throws CustomUploadException {
		JAXBContext ctx;
		try {
			ctx = JAXBContext.newInstance(PersistenceContainer.class);
		} catch (JAXBException e) {
			throw new CustomUploadException("Failed to get JAXB context.");
		}
		try {
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			PersistenceContainer pc1 = (PersistenceContainer) unmarshaller
					.unmarshal(new File(srcfilename));
			return pc1;
		} catch (JAXBException e) {
			throw new CustomUploadException("Marshalling failed", e);
		}

	}
}
