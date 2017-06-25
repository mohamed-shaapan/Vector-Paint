package storage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLFormatHandler {

	
	//01_Save Image
	//*****************************
	//*****************************************************************************
	public static boolean saveImage(Object image, String fileDirectory){
		try {
			//01_Open file
			XMLEncoder outputFile=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileDirectory)));
			//02_Write to file
			outputFile.writeObject(image);
			//03_Close file
			outputFile.close();
			return true;
		} catch (Exception e) {
			//System.out.println("Error creating or opening file");
			return false;
		}
	}
	
	
	//02_Load Image
	//*****************************
	//*****************************************************************************
	public static Object loadImage(String fileDirectory){
		try {
			//01_Open file
			XMLDecoder inputFile=new XMLDecoder(new BufferedInputStream(new FileInputStream(fileDirectory)));
			//02_Write to file
			Object  image=(Object)(inputFile.readObject());
			//03_Close file
			inputFile.close();
			//04_Return Image
			return image;
		} catch (Exception e) {
			//System.out.println("Error creating or opening file");
			return null;
		}
	}
	
	
	
}
