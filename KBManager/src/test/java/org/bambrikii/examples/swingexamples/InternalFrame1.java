package org.bambrikii.examples.swingexamples;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class InternalFrame1 extends JInternalFrame {
	private static final long serialVersionUID = -1196648890306834691L;
	private JTable table;

	public InternalFrame1() throws PropertyVetoException {
		setClosable(false);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setIcon(true);
		setClosable(true);
		setBounds(12, 12, 553, 437);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 543, 0 };
		gridBagLayout.rowHeights = new int[] { 404, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		JTextArea txtrFtghfgFghFgh = new JTextArea();
		txtrFtghfgFghFgh.setBounds(12, 13, 516, 120);
		panel.add(txtrFtghfgFghFgh);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelect.setBounds(12, 144, 98, 26);
		panel.add(btnSelect);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"id", "Title", "key" }) {
			private static final long serialVersionUID = -3476073153974392506L;
			Class<?>[] columnTypes = new Class<?>[] { Integer.class,
					String.class, Object.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(223);
		table.getColumnModel().getColumn(2).setPreferredWidth(196);
		table.setBounds(12, 182, 516, 95);
		panel.add(table);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		setVisible(true);
	}
}
