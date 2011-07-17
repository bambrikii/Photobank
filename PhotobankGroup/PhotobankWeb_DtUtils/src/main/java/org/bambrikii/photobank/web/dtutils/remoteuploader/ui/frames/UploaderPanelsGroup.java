package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.frames;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.bambrikii.photobank.web.dtutils.remoteuploader.ui.filespanels.FilesOrderPanel;
import org.bambrikii.photobank.web.dtutils.remoteuploader.ui.filespanels.FilesWebPanel;

public class UploaderPanelsGroup extends JPanel {
	private static final long serialVersionUID = 7280044330337094456L;

	public UploaderPanelsGroup(final JTextField url) {
		final FilesWebPanel wp = new FilesWebPanel();
		final FilesOrderPanel orderp = new FilesOrderPanel();

		url.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wp.setUrl(url.getText());
				orderp.setUrl(url.getText());
			}
		});

		this.add(wp);
		this.add(orderp);
		this.setSize(500, 500);
		this.setLayout(new GridLayout(1, 2));
	}
}
