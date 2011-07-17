package org.bambrikii.photobank.web.dtutils.remoteuploader.ui.dirchooser;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DirChooser extends JPanel implements ActionListener {
	private static final long serialVersionUID = 4157165469047100844L;

	JButton go;

	JFileChooser chooser;
	String choosertitle;
	JTextField path;

	public DirChooser() {
		go = new JButton("Select directory");
		go.addActionListener(this);
		add(go);

		path = new JTextField();
		path.setSize(250, 25);
		add(path);

		this.setLayout(new GridLayout(2, 1));
		this.setSize(new Dimension(250, 25));
	}

	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File(
				"D:\\Temporary Files\\personastars.com"));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): "
					+ chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : "
					+ chooser.getSelectedFile());
			path.setText(chooser.getSelectedFile().getAbsolutePath());
		} else {
			System.out.println("No Selection ");
			path.setText("");
		}

	}

	public String getPath() {
		return path.getText();
	}

}
