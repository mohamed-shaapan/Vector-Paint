package canvasTools;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ovalShapes.JOval;
import ovalShapes.OvalFactory;

public class Tester extends Application {
	
	//**********************************************************************************
	public void start(Stage stage) throws Exception {
		
		//***************************************************
		
		StrokeProperties strokeProperties=new StrokeProperties(Color.YELLOW, 3, Color.BLUE, 0);
		
		/*PolygonFactory shapeFactory=new PolygonFactory(null);
		JPolygon shape=shapeFactory.makeShape("triangle", strokeProperties);*/
		
		OvalFactory shapeFactory=new OvalFactory(null);
		JOval shape=shapeFactory.makeShape("ellipse", strokeProperties);
	
		//***************************************************
		Group root = new Group();
		root.getChildren().addAll(shape.getShapesToDisplay());
		
		stage.setTitle("Vector Paint");
		stage.setScene(new Scene(root, 800, 400));
		stage.show();
	  
	}
	
	//**********************************************************************************
	public static void main(String[] args) throws Exception {
		launch(args);
	}

  
}