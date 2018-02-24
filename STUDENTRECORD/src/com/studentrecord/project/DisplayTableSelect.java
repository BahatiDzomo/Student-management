package com.studentrecord.project;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTable;

public class DisplayTableSelect {

	private static String str;
	
	public static void displayData(Connection conObj, JTable table, String course, String semester) throws SQLException {
		// TODO Auto-generated method stub
		course="\'"+course+"\'";
		semester="\'"+semester+"\'";
		
		str = ("SELECT * FROM MAINRECORD WHERE STUDENT_COURSE="+course+" AND YEAR_LEVEL="+semester+" ORDER BY ROLL_NUMBER ASC");
		
//		ReadACADEMI_TB.readData(conObj,str,table,courseSem);
	}
}
