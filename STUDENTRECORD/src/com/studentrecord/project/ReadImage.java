package com.studentrecord.project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ReadImage {
	private static String backgroungImage_Path;
	
	private static void setBackgroungImage_Path(String panelName) {
		if ("SRMAuthentication".equals(panelName)) {
			backgroungImage_Path = "images//authenticate_background.JPG";
		}
		else if ("StudentRecordProject".equals(panelName)) {
			backgroungImage_Path = "images//record_background.JPG";
		}
	}
	
	public static JLabel readBackground_Image(String panelName) {
		setBackgroungImage_Path(panelName);
		File backgroundImage_File = new File(backgroungImage_Path);	
		BufferedImage backgroungImage_Buffered = null;
		try {
			backgroungImage_Buffered = ImageIO.read(backgroundImage_File);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel backgroungImage_Label = new JLabel(new ImageIcon(backgroungImage_Buffered));

		return backgroungImage_Label;
	}

	private ReadImage() {
	}
}
