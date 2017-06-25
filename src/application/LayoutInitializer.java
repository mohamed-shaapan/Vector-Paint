package application;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class LayoutInitializer {

	//***********************************************************************
	private ElementInitializer appElements;
		
		
	//***********************************************************************
	public LayoutInitializer(ElementInitializer appElements){
		this.appElements=appElements;
	}
		

	//***********************************************************************
	
	public void initialize(){
		HBox windowControls=new HBox();
		windowControls.getChildren().addAll(appElements.getCreateNewImageBtn(), appElements.getSaveImageBtn(), appElements.getLoadImageBtn());
		windowControls.getChildren().addAll(appElements.getUndoActionBtn(), appElements.getRedoActionBtn());
		windowControls.setSpacing(10);
		windowControls.setPadding(new Insets(20,10,20,10));
		
		HBox addShapesControls=new HBox();
		addShapesControls.getChildren().addAll(appElements.getAddLineBtn(), appElements.getAddTriangleBtn(), appElements.getAddSquareBtn(), appElements.getAddRectangleBtn());
		addShapesControls.getChildren().addAll(appElements.getAddEllipseBtn(), appElements.getAddCircleBtn());
		addShapesControls.setSpacing(10);
		addShapesControls.setPadding(new Insets(20,10,20,10));
		
		VBox resizeControls=new VBox();
		resizeControls.getChildren().addAll(appElements.getResizeControlsLabel(), appElements.getFullResizeSlider(), appElements.getWidthResizeSlider(), appElements.getHeightResizeSlider());
		resizeControls.setSpacing(10);
		resizeControls.setPadding(new Insets(20,20,20,20));
		
		VBox borderControls=new VBox();
		borderControls.getChildren().addAll(appElements.getBorderControlsLabel(), appElements.getBorderThicknessSlider(), appElements.getBorderColorPicker());
		borderControls.setSpacing(10);
		borderControls.setPadding(new Insets(20,20,20,20));
		
		VBox fillElementControls=new VBox();
		fillElementControls.getChildren().addAll(appElements.getFillControlsLabel(), appElements.getFillColorPicker());
		fillElementControls.setSpacing(10);
		fillElementControls.setPadding(new Insets(20,20,20,20));
		
		VBox removeElementControls=new VBox();
		removeElementControls.getChildren().addAll(appElements.getMiscControlsLabel(), appElements.getRemoveShapeBtn());
		removeElementControls.setSpacing(10);
		removeElementControls.setPadding(new Insets(20,20,20,20));
		
		appElements.getCanvas().setMinSize(600, 400);
		appElements.getCanvas().setClip(new Rectangle(3000,3000));
		appElements.getCanvas().setPadding(new Insets(30,30,30,30));
		
		HBox drawingCanvas=new HBox();
		drawingCanvas.getChildren().add(appElements.getCanvas());
		drawingCanvas.setStyle("-fx-background-color: white;");
		
		//-----------------------------------
		AnchorPane topPanel=new AnchorPane();
		topPanel.getChildren().addAll(windowControls, addShapesControls);
		//topPanel.setLeftAnchor(windowControls, 20.0);
		//topPanel.setRightAnchor(addShapesControls, 100.0);
		AnchorPane.setLeftAnchor(windowControls, 20.0);
		AnchorPane.setRightAnchor(addShapesControls, 100.0);
		topPanel.setStyle("-fx-background-color: #292751;");
		
		VBox sidePanel=new VBox();
		sidePanel.getChildren().addAll(resizeControls, borderControls, fillElementControls, removeElementControls);
		sidePanel.setMinWidth(250);
		sidePanel.setMaxWidth(250);
		sidePanel.setStyle("-fx-background-color: #dddddd;");

		//-----------------------------------
		appElements.getLayout().setTop(topPanel);
		appElements.getLayout().setLeft(sidePanel);
		appElements.getLayout().setCenter(drawingCanvas);
		appElements.getLayout().setPrefSize(900, 550);

	}
	
	
	
}
