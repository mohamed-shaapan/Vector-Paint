package application;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class HotKeysHandler {

	//***********************************************************************
	private ElementInitializer appElements;
			
			
	//***********************************************************************
	public HotKeysHandler(ElementInitializer appElements){
		this.appElements=appElements;
	}
	
			

	//***********************************************************************
	
	public void initialize(){
		appElements.getCreateNewImageBtn().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//createNewImage();
				}
			}
		);

		appElements.getSaveImageBtn().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//saveImage();
				}
			}
		);

		appElements.getLoadImageBtn().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//loadImage();
				}
			}
		);

		appElements.getUndoActionBtn().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//appEngine.undoAction();
					//renderImageFromEngine();
				}
			}
		);

		appElements.getRedoActionBtn().getScene().getAccelerators().put(
			new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN), 
			new Runnable() {
				@Override public void run() {
					//appEngine.redoAction();
					//renderImageFromEngine();
				}
			}
		);
	}
	
}
