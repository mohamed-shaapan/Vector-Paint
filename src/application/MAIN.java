package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class MAIN extends Application {
	
	//01_Image Attributes
	//************************************
	//*************************************************************************************************
	private ApplicationInitializer initializer;
	private BorderPane layout;
	//private Pane drawingCanvas;
	//private ArrayList<Shape> shapeList;
	//private Stage primaryStage;
	
	//02_Application Controller
	//************************************
	//*************************************************************************************************
	public static void main(String[] args) {
		launch(args);
	}

	//***********************************************************************
	public void start(Stage primaryStage) throws Exception {
		//01_Initialize Application
		initializer=new ApplicationInitializer(this);
		initializer.initialize();
		
		//02_Create Shapes
		
		//02_show final window
		Scene scene=new Scene(layout, 1100, 600);
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false);
		primaryStage.setMinHeight(550);
		primaryStage.setMinWidth(900);
		primaryStage.show();
		
	}
	//*************************************************************************************************
	public void setLayout(BorderPane layout){
		this.layout=layout;
	}
	
	

	
}


