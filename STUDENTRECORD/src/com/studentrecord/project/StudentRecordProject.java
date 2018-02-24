package com.studentrecord.project;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentRecordProject extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField rollNOTextField;
	private JTextField courseTextField;
	private JTextField crTextField;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnF;
	private String gender;
	
	/**
	 * Create the frame.
	 */
	
	public StudentRecordProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("STUDENT RECORD MANAGEMENT SYSTEM");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 500, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 29, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -341, SpringLayout.EAST, contentPane);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStudentId, -1124, SpringLayout.EAST, contentPane);
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblStudentId);
		
		JLabel lblCourse = new JLabel("NAME");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCourse, 57, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCourse, -910, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblStudentId, 0, SpringLayout.NORTH, lblCourse);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblCourse);
		
		nameTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, nameTextField, -1, SpringLayout.NORTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.WEST, nameTextField, 6, SpringLayout.EAST, lblCourse);
		sl_contentPane.putConstraint(SpringLayout.EAST, nameTextField, -733, SpringLayout.EAST, contentPane);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		rollNOTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, rollNOTextField, -1, SpringLayout.NORTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.WEST, rollNOTextField, 6, SpringLayout.EAST, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.EAST, rollNOTextField, -22, SpringLayout.WEST, lblCourse);
		contentPane.add(rollNOTextField);
		rollNOTextField.setColumns(10);
		
		JLabel lblCourse_1 = new JLabel("COURSE");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCourse_1, -664, SpringLayout.EAST, contentPane);
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblCourse_1, 0, SpringLayout.SOUTH, lblStudentId);
		contentPane.add(lblCourse_1);
		
		courseTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, courseTextField, 622, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, courseTextField, -1, SpringLayout.NORTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.EAST, courseTextField, 119, SpringLayout.EAST, lblCourse_1);
		contentPane.add(courseTextField);
		courseTextField.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSaveactionPerformed();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSave, 0, SpringLayout.NORTH, lblStudentId);
		contentPane.add(btnSave);
		
		JButton btnNew = new JButton("NEW");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rollNOTextField.setText("");
				nameTextField.setText("");
				courseTextField.setText("");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNew, 0, SpringLayout.NORTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNew, 16, SpringLayout.EAST, btnSave);
		contentPane.add(btnNew);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdateactionPerformed();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnUpdate, 15, SpringLayout.EAST, btnNew);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUpdate, 0, SpringLayout.SOUTH, btnSave);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("Check Record");
		lblNewLabel_1.setForeground(Color.RED);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 17, SpringLayout.SOUTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblStudentId);
		contentPane.add(lblNewLabel_1);
		
		crTextField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, crTextField, 6, SpringLayout.SOUTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, crTextField, 0, SpringLayout.WEST, rollNOTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, crTextField, 0, SpringLayout.EAST, rollNOTextField);
		contentPane.add(crTextField);
		crTextField.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConfirmactionPerformed();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnConfirm, -1, SpringLayout.NORTH, crTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnConfirm, 6, SpringLayout.EAST, crTextField);
		contentPane.add(btnConfirm);
		
		JLabel lblStudentIdRequired = new JLabel("Student ID Required");
		lblStudentIdRequired.setForeground(Color.BLUE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblStudentIdRequired, 6, SpringLayout.SOUTH, crTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblStudentIdRequired, 0, SpringLayout.WEST, rollNOTextField);
		contentPane.add(lblStudentIdRequired);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 31, SpringLayout.SOUTH, lblStudentIdRequired);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, -1, SpringLayout.WEST, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -55, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, btnUpdate);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, "", "", "", null},
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
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblGender, 0, SpringLayout.NORTH, crTextField);
		contentPane.add(lblGender);
		
		rdbtnM = new JRadioButton("M",true);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblGender, -20, SpringLayout.WEST, rdbtnM);
		buttonGroup.add(rdbtnM );
		rdbtnM.setBackground(new Color(176, 224, 230));	
		
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnM, 0, SpringLayout.WEST, lblCourse_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnM, 0, SpringLayout.SOUTH, crTextField);
		contentPane.add(rdbtnM);
		
		rdbtnF = new JRadioButton("F");
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnF, 26, SpringLayout.EAST, rdbtnM);
		buttonGroup.add(rdbtnF);
		rdbtnF.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnF, 0, SpringLayout.SOUTH, crTextField);
		contentPane.add(rdbtnF);
		
		JButton btnDisplay = new JButton("DISPLAY");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDisplay, 6, SpringLayout.SOUTH, scrollPane);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDisplayactionPerformed();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDisplay, 0, SpringLayout.WEST, lblStudentId);
		contentPane.add(btnDisplay);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLogOutactionPerformed();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogOut, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLogOut, 0, SpringLayout.EAST, btnUpdate);
		contentPane.add(btnLogOut);
		
		JComboBox comboBox = new JComboBox();
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 87, SpringLayout.EAST, courseTextField);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSave, 29, SpringLayout.EAST, comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SEM I", "SEM II", "SEM III", "SEM IV ", "SEM V", "SEM VI", "1ST YEAR ", "2ND YEAR", "3RD YEAR"}));
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 0, SpringLayout.NORTH, lblStudentId);
		contentPane.add(comboBox);
		
		JLabel lblSemyear = new JLabel("SEM/YEAR");
		lblSemyear.setFont(new Font("Tahoma", Font.BOLD, 13));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSemyear, 0, SpringLayout.NORTH, lblStudentId);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSemyear, 9, SpringLayout.EAST, courseTextField);
		contentPane.add(lblSemyear);
		
		JButton btnTreasury = new JButton("TREASURY");
		btnTreasury.setFont(new Font("Tahoma", Font.PLAIN, 11));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTreasury, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTreasury, 0, SpringLayout.EAST, btnUpdate);
		contentPane.add(btnTreasury);
		
		JButton btnPrint = new JButton("PRINT");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPrint, 0, SpringLayout.SOUTH, btnDisplay);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPrint, 0, SpringLayout.EAST, lblStudentIdRequired);
		contentPane.add(btnPrint);
		
		JButton btnDelete = new JButton("DELETE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnDelete, -1, SpringLayout.NORTH, crTextField);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, btnUpdate);
		contentPane.add(btnDelete);
	}

	protected void btnDisplayactionPerformed() {
		// TODO Auto-generated method stub
		java.sql.ResultSet rs = null;
		java.sql.Connection conObj = JdbcConnect.createConnection();
		
		try {
			DisplayTable.displayData(conObj,table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
		}		
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void btnUpdateactionPerformed() {
		// TODO Auto-generated method stub
		if (rdbtnM.isSelected()) {
			gender = rdbtnM.getText();
		}
		
		else if(rdbtnF.isSelected()) {
			gender = rdbtnF.getText();
		}
		
		java.sql.Connection conObj = JdbcConnect.createConnection();
		
		java.util.Vector update_row = new java.util.Vector();
		
		update_row.add(nameTextField.getText().toUpperCase());
		update_row.add(gender);
		update_row.add(courseTextField.getText().toUpperCase());
		update_row.add(rollNOTextField.getText());
		
		int i=0;
		try {
			i = JdbcUpdate.updateRecordFromTable(conObj,update_row);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
		}
		
		if (i==0)
		{
				JOptionPane.showMessageDialog(null, "Internal Error", "", JOptionPane.ERROR_MESSAGE);
		}
		
		else {	
				JOptionPane.showMessageDialog(null, "Record NO. "+rollNOTextField.getText()+" updated successiful");
		}	
		
	}

	protected void btnConfirmactionPerformed() {
		// TODO Auto-generated method stub
		java.sql.Connection conObj = JdbcConnect.createConnection();
		
		String rno = crTextField.getText();
		java.sql.ResultSet rs=null;
		try {
			rs = JdbcSelect.selectRecordFromTable(conObj,rno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
		}

		try {
			if (rs.next())
			{
				rollNOTextField.setText(rs.getString(1));
				nameTextField.setText(rs.getString(2));
				courseTextField.setText(rs.getString(4));
			}

			else {
				JOptionPane.showMessageDialog(null, "Oops! Record NO. "+rno+" do not exist in the system", "Internal error", JOptionPane.ERROR_MESSAGE); 			
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
		}	
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void btnSaveactionPerformed() {
		// TODO Auto-generated method stub
		if (rdbtnM.isSelected()) {
			gender = rdbtnM.getText();
		}
		
		else if(rdbtnF.isSelected()) {
			gender = rdbtnF.getText();
		}
		
		java.sql.Connection conObj = JdbcConnect.createConnection();
		String rollnumber = rollNOTextField.getText();
		if (12==rollnumber.length())
		{
			Vector add_rows = new Vector();
			add_rows.add(rollnumber);
			add_rows.add(nameTextField.getText().toUpperCase());
			add_rows.add(gender);
			add_rows.add(courseTextField.getText().toUpperCase());
			try {
				JdbcSearchT.searchTable("MAINRECORD",conObj,add_rows);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage(), "Internal error", JOptionPane.ERROR_MESSAGE);
				JOptionPane.showMessageDialog(null, "Contact Support @whatsapp+254718569878/call +917310683187", "Internal error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Invalid roll number","", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void btnLogOutactionPerformed() {
		// TODO Auto-generated method stub
		dispose();
		JLabel backgroungImage_Label = ReadImage.readBackground_Image("SRMAuthentication");
		
		SRMAuthentication dialog = new SRMAuthentication();
		dialog.getContentPane().add(backgroungImage_Label);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(1350,700);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		
	}
}
