package org.bambrikii.photobank.web.dtutils;

import java.util.Date;
import java.util.GregorianCalendar;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.iptc.IptcDirectory;
import com.drew.metadata.iptc.IptcReader;

public class IptcReader2 extends IptcReader {
	public byte[] _data;

	public IptcReader2(byte[] data) {
		super(data);
		_data = data;
		// TODO Auto-generated constructor stub
	}

	public Metadata extract() {
		return extract(new Metadata());
	}

	public Metadata extract(Metadata paramMetadata) {
		if (this._data == null)
			return paramMetadata;
		Directory localDirectory = paramMetadata
				.getDirectory(IptcDirectory.class);
		int i = 0;
		try {
			while ((i < this._data.length - 1) && (get32Bits(i) != 7170))
				i++;
		} catch (MetadataException localMetadataException1) {
			localDirectory
					.addError("Couldn't find start of Iptc data (invalid segment)");
			return paramMetadata;
		}
		while ((i < this._data.length) && (this._data[i] == 28)
				&& (i + 5 < this._data.length)) {
			i++;
			int j;
			int k;
			int m;
			try {
				j = this._data[(i++)];
				k = this._data[(i++)];
				m = get32Bits(i);
			} catch (MetadataException localMetadataException2) {
				localDirectory
						.addError("Iptc data segment ended mid-way through tag descriptor");
				return paramMetadata;
			}
			i += 2;
			if (i + m > this._data.length) {
				localDirectory
						.addError("data for tag extends beyond end of iptc segment");
				break;
			}
			processTag(localDirectory, j, k, i, m);
			i += m;
		}
		return paramMetadata;
	}

	private int get32Bits(int paramInt) throws MetadataException {
		if (paramInt >= this._data.length)
			throw new MetadataException(
					"Attempt to read bytes from outside Iptc data buffer");
		return (this._data[paramInt] & 0xFF) << 8 | this._data[(paramInt + 1)]
				& 0xFF;
	}

	private void processTag(Directory paramDirectory, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		int i = paramInt2 | paramInt1 << 8;
		Object localObject;
		switch (i) {
		case 512:
			int j = (short) (this._data[paramInt3] << 8 | this._data[(paramInt3 + 1)]);
			paramDirectory.setInt(i, j);
			return;
		case 522:
			paramDirectory.setInt(i, this._data[paramInt3]);
			return;
		case 542:
		case 567:
			if (paramInt4 >= 8) {
				localObject = new String(this._data, paramInt3, paramInt4);
				try {
					int k = Integer.parseInt(((String) localObject).substring(
							0, 4));
					int m = Integer.parseInt(((String) localObject).substring(
							4, 6)) - 1;
					int i1 = Integer.parseInt(((String) localObject).substring(
							6, 8));
					Date localDate = new GregorianCalendar(k, m, i1).getTime();
					paramDirectory.setDate(i, localDate);
					return;
				} catch (NumberFormatException localNumberFormatException) {
				}
			}
		case 547:
		case 572:
		}
		String str;
		if (paramInt4 < 1)
			str = "";
		else
			str = new String(this._data, paramInt3, paramInt4);
		if (paramDirectory.containsTag(i)) {
			try {
				localObject = paramDirectory.getStringArray(i);
			} catch (MetadataException localMetadataException) {
				localObject = null;
			}
			String[] arrayOfString;
			if (localObject == null) {
				arrayOfString = new String[1];
			} else {
				arrayOfString = new String[((String[]) localObject).length + 1];
				for (int n = 0; n < ((String[]) localObject).length; n++)
					arrayOfString[n] = ((String[]) localObject)[n];
			}
			arrayOfString[(arrayOfString.length - 1)] = str;
			paramDirectory.setStringArray(i, arrayOfString);
		} else {
			paramDirectory.setString(i, str);
		}
	}
}
