package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.filespanels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import org.bambrikii.photobank.web.dtutils.RemoteUploader;
import org.bambrikii.photobank.web.dtutils.remoteuploader.ui.dirchooser.DirChooser;

public abstract class FilesAbstractPanel extends JPanel {
	private static final long serialVersionUID = 7691722521434056406L;

	protected String url = "http://localhost:8080/photobank";
	protected RemoteUploader uploader;
	protected DirChooser chooser;

	public FilesAbstractPanel() {
		uploader = new RemoteUploader();

		chooser = new DirChooser();
		// chooser.add
		this.add(chooser);

		JProgressBar progress = new JProgressBar();
		this.add(progress);

		JList loggingArea = new JList();
		loggingArea.setSize(250, 500);
		this.add(loggingArea);

		JTextArea errorArea = new JTextArea();
		errorArea.setSize(250, 180);
		this.add(errorArea);

		JButton go = new JButton("Go");
		this.add(go);
		go.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					upload();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		this.setLayout(new GridLayout(8, 1));
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public abstract void upload() throws Exception;
}
