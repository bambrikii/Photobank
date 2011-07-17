package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.frames;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class UploaderFrame extends JFrame {
	private static final long serialVersionUID = 5504193693722709974L;

	public UploaderFrame() {

		JTextField url = new JTextField();
		this.add(url);

		url.setText("http://localhost:8080/photobank");

		UploaderPanelsGroup grp1 = new UploaderPanelsGroup(url);
		this.add(grp1);
		this.setLayout(new GridLayout(2, 1));
		pack();
		setVisible(true);
	}
}
