package com.studentrecord.project;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentsInfoDisplay extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox comboBoxCourse;
	private JComboBox comboBoxSem;

	/**
	 * Create the dialog.
	 */
	public StudentsInfoDisplay(){
		setBounds(100, 100, 1250, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		
		JLabel label = new JLabel("STUDENTS  BASED  ON");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, contentPanel);
		sl_contentPanel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, contentPanel);
		label.setForeground(Color.BLUE);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("COURSE");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, label);
		sl_contentPanel.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label);
		label_1.setForeground(Color.CYAN);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("YEAR LEVEL/SEM");
		sl_contentPanel.putConstraint(SpringLayout.NORTH, label_2, 0, SpringLayout.NORTH, label_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, label_2, 82, SpringLayout.EAST, label_1);
		label_2.setForeground(Color.CYAN);
		contentPanel.add(label_2);
		
		comboBoxSem = new JComboBox();
		comboBoxSem.setModel(new DefaultComboBoxModel(new String[] {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "SIXTH"}));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBoxSem, 6, SpringLayout.SOUTH, label_2);
		sl_contentPanel.putConstraint(SpringLayout.WEST, comboBoxSem, 0, SpringLayout.WEST, label_2);
		contentPanel.add(comboBoxSem);
		
		comboBoxCourse = new JComboBox();
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"BBA", "BCA", "BCOM", "BTECH", "B.ART/ED"}));
		sl_contentPanel.putConstraint(SpringLayout.NORTH, comboBoxCourse, 6, SpringLayout.SOUTH, label_1);
		sl_contentPanel.putConstraint(SpringLayout.WEST, comboBoxCourse, 0, SpringLayout.WEST, label);
		contentPanel.add(comboBoxCourse);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPanel.putConstraint(SpringLayout.NORTH, scrollPane, 13, SpringLayout.SOUTH, comboBoxSem);
		sl_contentPanel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, label);
		sl_contentPanel.putConstraint(SpringLayout.SOUTH, scrollPane, 470, SpringLayout.SOUTH, comboBoxSem);
		sl_contentPanel.putConstraint(SpringLayout.EAST, scrollPane, 995, SpringLayout.EAST, label_2);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.DARK_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, "", null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STUDENT ID", "STUDENT NAME", "GENDER", "COURSE", "YEAR LEVEL"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRefreshactionPerformed();
			}
		});
		sl_contentPanel.putConstraint(SpringLayout.NORTH, btnRefresh, -1, SpringLayout.NORTH, comboBoxSem);
		sl_contentPanel.putConstraint(SpringLayout.WEST, btnRefresh, 56, SpringLayout.EAST, comboBoxSem);
		contentPanel.add(btnRefresh);
	}

	protected void btnRefreshactionPerformed() {
		// TODO Auto-generated method stub
		String course = (String) comboBoxCourse.getSelectedItem();
		String semester = (String) comboBoxSem.getSelectedItem();

		java.sql.Connection conObj = JdbcConnect.createConnection();
		try {
			DisplayTableSelect.displayData(conObj, table, course, semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Academic table still epmty... no records to display", "Internal error", JOptionPane.ERROR_MESSAGE);
		}	
	}
}
