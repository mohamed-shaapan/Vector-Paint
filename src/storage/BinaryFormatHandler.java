package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinaryFormatHandler {

	//01_Save Image
	//*****************************
	//*****************************************************************************
	public static boolean saveImage(Object image, String fileDirectory) {
		File imageFile=new File(fileDirectory);
		try{
			//open file
			FileOutputStream tmp=new FileOutputStream(imageFile);
			ObjectOutputStream fileWriter=new ObjectOutputStream(tmp);
			//write to file
			fileWriter.writeObject(image);
			//close file
			fileWriter.close();
			tmp.close();
			return true;
		}catch(Exception e){
			return false;
		}
	}
		
		
	//02_Load Image
	//*****************************
	//*****************************************************************************
	public static Object loadImage(String fileDirectory){
		File imageFile=new File(fileDirectory);
		try{
			//open file
			FileInputStream tmp=new FileInputStream(imageFile);
			ObjectInputStream fileReader=new ObjectInputStream(tmp);
			//read from file
			Object image=(Object)fileReader.readObject();
			//close file
			fileReader.close();
			tmp.close();
			return image;
		}catch (Exception e){
			return null;
		}
	}
	
	
	
	
	
}
