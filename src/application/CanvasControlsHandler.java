package application;

public class CanvasControlsHandler {

	//***********************************************************************
	private ElementInitializer appElements;
		
		
	//***********************************************************************
	public CanvasControlsHandler(ElementInitializer appElements){
		this.appElements=appElements;
	}
	
	//***********************************************************************
	public void initialize(){
		//01_Control Bar Buttons
		appElements.getCreateNewImageBtn().setOnMouseClicked(e ->{
			createNewImage();
		});
		appElements.getSaveImageBtn().setOnMouseClicked(e ->{
			saveImage();
		});
		appElements.getLoadImageBtn().setOnMouseClicked(e ->{
			loadImage();
		});
		appElements.getUndoActionBtn().setOnMouseClicked(e ->{
			undoAction();
			//renderImageFromEngine();
		});
		appElements.getRedoActionBtn().setOnMouseClicked(e ->{
			redoAction();
			//renderImageFromEngine();
		});
	}
	
	//***********************************************************************
	public void createNewImage(){
		appElements.getCanvas().getChildren().clear();
		appElements.getSelectedElements().clear();
	}
		
	public void saveImage(){
			
	}
	
	public void loadImage(){
		
	}
	
	public void undoAction(){
		
	}
	
	public void redoAction(){
		
	}
	
	
}
