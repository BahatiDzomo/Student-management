package com.studentrecord.project;

import javax.swing.JDialog;
import javax.swing.SpringLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SRMAuthentication extends JDialog {
	private JTextField usernametextField;
	private JTextField passwordField;
	private Connection conObj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JLabel backgroungImage_Label = ReadImage.readBackground_Image("SRMAuthentication");

			SRMAuthentication dialog = new SRMAuthentication();
			dialog.getContentPane().add(backgroungImage_Label);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setSize(1350,700);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SRMAuthentication() {
		getContentPane().setBackground(Color.MAGENTA);
		setBounds(100, 100, 450, 300);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JLabel lblUserName = new JLabel("user name");
		springLayout.putConstraint(SpringLayout.NORTH, lblUserName, 13, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblUserName, -178, SpringLayout.EAST, getContentPane());
		getContentPane().add(lblUserName);

		usernametextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, usernametextField, -3, SpringLayout.NORTH, lblUserName);
		springLayout.putConstraint(SpringLayout.WEST, usernametextField, 6, SpringLayout.EAST, lblUserName);
		springLayout.putConstraint(SpringLayout.EAST, usernametextField, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(usernametextField);
		usernametextField.setColumns(10);

		JLabel lblPassword = new JLabel("password");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 12, SpringLayout.SOUTH, lblUserName);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, lblUserName);
		getContentPane().add(lblPassword);

		JButton btnLogIn = new JButton("log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLogInactionPerformed();
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnLogIn, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnLogIn);

		JButton btnGuest = new JButton("guest");
		springLayout.putConstraint(SpringLayout.NORTH, btnGuest, 62, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnLogIn, 0, SpringLayout.NORTH, btnGuest);
		springLayout.putConstraint(SpringLayout.WEST, btnGuest, 0, SpringLayout.WEST, lblUserName);
		getContentPane().add(btnGuest);

		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 6, SpringLayout.SOUTH, usernametextField);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 10, SpringLayout.EAST, lblPassword);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 172, SpringLayout.EAST, lblPassword);
		getContentPane().add(passwordField);
		passwordField.setColumns(10);
	}

	protected void btnLogInactionPerformed() {
		// TODO Auto-generated method stub
		conObj = JdbcConnect.createConnection();
		try {
			JdbcSearchT.searchTable("USERACCOUNTS",conObj,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Unabale to establish connection", "Internal error", JOptionPane.ERROR_MESSAGE);	
		}
		checkingAuthentication(conObj);
	}
	protected void checkingAuthentication(Connection conObj) {
		// TODO add your handling code here:

		String usrName =usernametextField.getText();
		String pswd = passwordField.getText();

		java.sql.ResultSet rs = null;
		try {
			rs = JdbcSelectLoginAccount.selectRecordFromTable(conObj,usrName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (rs.next())
			{
				if (pswd.equals(rs.getString(2)))
				{	
					dispose();	
					JLabel backgroungImage_Label = ReadImage.readBackground_Image("StudentRecordProject");
					
					StudentRecordProject frame = new StudentRecordProject();
					frame.getContentPane().add(backgroungImage_Label);
					frame.setSize(1300,700);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}

				else {
					javax.swing.JOptionPane.showMessageDialog(null, "Incorrect password", "Login error", javax.swing.JOptionPane.ERROR_MESSAGE);
				}
			}

			else {
				javax.swing.JOptionPane.showMessageDialog(null, "User not in the system", "Login error", javax.swing.JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}
