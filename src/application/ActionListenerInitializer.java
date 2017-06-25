package application;

import java.util.ArrayList;

import genericShape.JShape;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import ovalShapes.JOval;
import polygonShapes.JPolygon;

public class ActionListenerInitializer {
	
	//***********************************************************************
	private ElementInitializer appElements;
	
	
	//***********************************************************************
	public ActionListenerInitializer(ElementInitializer appElements){
		this.appElements=appElements;
	}
	

	//***********************************************************************
	public void initialize(){
		//01_Control Bar Buttons
		
		//02_Add Shape Buttons
		//**********************************
		appElements.getAddLineBtn().setOnMouseClicked(e ->{
			JPolygon shape=appElements.getPolygonFactory().makeShape("line", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		appElements.getAddTriangleBtn().setOnMouseClicked(e ->{
			JPolygon shape=appElements.getPolygonFactory().makeShape("triangle", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		appElements.getAddSquareBtn().setOnMouseClicked(e ->{
			JPolygon shape=appElements.getPolygonFactory().makeShape("square", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		appElements.getAddRectangleBtn().setOnMouseClicked(e ->{
			JPolygon shape=appElements.getPolygonFactory().makeShape("rectangle", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		//*******************************
		appElements.getAddEllipseBtn().setOnMouseClicked(e ->{
			JOval shape=appElements.getOvalFactory().makeShape("ellipse", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		appElements.getAddCircleBtn().setOnMouseClicked(e ->{
			JOval shape=appElements.getOvalFactory().makeShape("circle", appElements.getStrokeProperties());
			appElements.getCanvas().getChildren().addAll(shape.getShapesToDisplay());
			appElements.getCanvasShapes().add(shape);
		});
		//03_Border Control
		appElements.getBorderThicknessSlider().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				try{
					JShape selectedShape=appElements.getSelectedElements().get(0);
	            	selectedShape.setBorderWidth((double)new_val);
				}catch(Exception ex){}
			}
        });
		
		appElements.getBorderColorPicker().setOnAction(e ->{
			try{
				JShape selectedShape=appElements.getSelectedElements().get(0);
	        	selectedShape.setBorderColor(appElements.getBorderColorPicker().getValue());
			}catch(Exception ex){}
		});
		//04_Shape Fill Control
		appElements.getFillColorPicker().setOnAction(e ->{
			try{
				JShape selectedShape=appElements.getSelectedElements().get(0);
	        	selectedShape.setFillColor(appElements.getFillColorPicker().getValue());
			}catch(Exception ex){}
		});
		//05_MISC Controls
		appElements.getRemoveShapeBtn().setOnMouseClicked(e ->{
			try{
				ObservableList<Node> canvas=appElements.getCanvas().getChildren();
				JShape selectedJShape=appElements.getSelectedElements().get(0);
				ArrayList<Shape> shapesToRemove=selectedJShape.getShapesToDisplay();
				canvas.removeAll(shapesToRemove);
				appElements.getSelectedElements().clear();
				appElements.getCanvasShapes().remove(selectedJShape);
			}catch(Exception ex){}
		});
		//06_Resize Controls
		appElements.getFullResizeSlider().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				/*double heightIncrement=(double)new_val-(double)old_val;
		        if(applyHeightResize(heightIncrement)){
		        appEngine.modifyShapeHeight(engineSelectedElement, heightIncrement);
		        }*/
			}
		});
		appElements.getWidthResizeSlider().valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				/*double heightIncrement=(double)new_val-(double)old_val;
		        if(applyHeightResize(heightIncrement)){
		        appEngine.modifyShapeHeight(engineSelectedElement, heightIncrement);
		        }*/
			}
		});
		
		appElements.getHeightResizeSlider().valueProperty().addListener(new ChangeListener<Number>() {   
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				/*double heightIncrement=(double)new_val-(double)old_val;
		        if(applyHeightResize(heightIncrement)){
		        appEngine.modifyShapeHeight(engineSelectedElement, heightIncrement);
		        }*/
			}
		});
	}	
	
}
