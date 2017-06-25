package storage;

public class ImageFileHandler {

	
	//01_Save Image
	//*****************************
	//*****************************************************************************
	public static boolean saveImage(Object image, String fileDirectory, String fileFormat){
		if(fileFormat.equalsIgnoreCase("xml")){
			return XMLFormatHandler.saveImage(image, fileDirectory);
		}else if(fileFormat.equalsIgnoreCase("json")){
			return false;
		}else if(fileFormat.equalsIgnoreCase("bin")){
			return BinaryFormatHandler.saveImage(image, fileDirectory);
		}
		return false;
	}
	
	
	//02_Load Image
	//*****************************
	//*****************************************************************************
	public static Object loadImage(String fileDirectory, String fileFormat){
		if(fileFormat.equalsIgnoreCase("xml")){
			return XMLFormatHandler.loadImage(fileDirectory);
		}else if(fileFormat.equalsIgnoreCase("json")){
			return null;
		}else if(fileFormat.equalsIgnoreCase("bin")){
			return BinaryFormatHandler.loadImage(fileDirectory);
		}
		return null;
	}
	
	
}
