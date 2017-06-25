package storage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JSONFormatHandler {

	//01_Save Image
	//*****************************
	//*****************************************************************************
	public static void saveImage(Object image, String fileDirectory){
		try {
			//01_Open file
			XMLEncoder outputFile=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileDirectory)));
			//02_Write to file
			outputFile.writeObject(image);
			//03_Close file
			outputFile.close();	
		} catch (Exception e) {
			//System.out.println("Error creating or opening file");
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
	
	
	//********************************************************************************************
	
	/*public void saveImageJSON(String fileName){
		try{
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(fileName), this.shapesContainer);
		}catch(Exception ex){}
		
	}

	public void loadImageJSON(String fileLocation){
		
		ArrayList<Object> tmp;
		try{
			ObjectMapper mapper = new ObjectMapper();
			tmp=mapper.readValue(new File(fileLocation), new TypeReference<ArrayList<Object>>(){});
			VEllipse tmp2=(VEllipse)tmp.get(0);
			tmp2.getTranslateX();
			System.out.println("Success");
			//this.setShapesContainer(tmp);
			//ArrayList<VShape> tmp=mapper.readValue(new File(fileLocation), typeFactory.constructCollectionType(ArrayList.class, VShape.class));
			//ArrayList<VShape> tmp=mapper.readValue(new File(fileLocation), ArrayList.class);
			
			
			//private ArrayList<VShape> shapesContainer;
		}catch(Exception ex){
			System.out.println("Could Not Load File");
		}
		
	}
	*/
	
	
}
