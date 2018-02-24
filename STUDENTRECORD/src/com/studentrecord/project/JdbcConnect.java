/**
 * @author Akida M Jafar
 * projectIndia connection class
 */
package com.studentrecord.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 *public class JdbcConnect{...};
 */
public class JdbcConnect {

	private JdbcConnect(){

	}
	/*
	 * Initialization of
	 * CONSTANT variables
	 * i. 	db_driver
	 * ii. 	db_url
	 * iii. db_user
	 * iv. 	db_password  
	 */

	/*
	 * Can also use
	 * oracle.jdbc.driver.OracleDriver
	 * Type driver for Oracle_DB
	 */
	//	private static final String DB_DRIVER="sun.jdbc.odbc.JdbcOdbcDriver";
	private static final String DB_DRIVER="oracle.jdbc.driver.OracleDriver";
	public static String db_user = "BAHATI";
	public static String db_password = "dzomo12";
	//	public static String db_url = "jdbc:oracle:thin:localized:1521:oral";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	/*
	 * createConnection() method for establishment of DB connection
	 * its a public method 
	 * returns Connection object as a value
	 * takes no arguments
	 */
	protected static Connection createConnection()
 	{	

		/*		
		Vector usrnamePassword = G_PropertiesFile.getPropetiesFile();

		db_user = (String) usrnamePassword.elementAt(0);
		db_password = (String) usrnamePassword.elementAt(1);

		 */
		/*
		 * Connection conObj local variable
		 * nullified
		 */
		Connection conObj = null;

		/*
		 * registration of the sun.jdbc.odbc.JdbcOdbcDriver
		 * & the creation of the connection to the DB
		 */
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			//user friendly error message
			JOptionPane.showMessageDialog(null, DB_DRIVER+" driver unavailble", "Internal Error", JOptionPane.ERROR_MESSAGE);
		}
		try {
			conObj = DriverManager.getConnection(DB_URL,db_user,db_password);
		} catch (SQLException e) {
			// user friendly error message
			JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
		//returning final value of conObj
		 return conObj;
	}
}
