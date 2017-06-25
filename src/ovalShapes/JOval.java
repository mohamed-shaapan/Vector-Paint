package ovalShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Shape;
import polygonShapes.JPolygon;
import shapeEventHandlers.OvalEventHandler;
import shapeEventHandlers.ShapeEventHandler;

public abstract class JOval extends JShape{
	
	//***********************************************************************
	private Shape shape;
	private JPolygon enclosure;
	private SimpleDoubleProperty[] observableBindingPoints;
	
	//***********************************************************************
	public JOval(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties, ArrayList<JShape> selectedCanvasElements){

		shape=initializeShape(strokeProperties, observableBindingPoints);
			
		enclosure=setEnclosureShape(observableBindingPoints);
		
		setShapeBinding(observableBindingPoints);
		
		setCanvasSelectedElements(selectedCanvasElements);
		
		ShapeEventHandler eventHandler=new OvalEventHandler(this, selectedCanvasElements);
	    eventHandler.generateEvents();  
	}
	
	//***********************************************************************
	public ArrayList<Shape> getShapesToDisplay(){
		ArrayList<Shape> result=new ArrayList<Shape>();
		for(Shape tmp:enclosure.getShapesToDisplay()){
			result.add(tmp);
		}
		result.add(shape);
		return result;
	}
	public SimpleDoubleProperty[] getBindingPoints(){
		return observableBindingPoints;
	}
	public JPolygon getEnclosure(){
		return this.enclosure;
	}
	//***********************************************************************
	public Shape initializeShape(StrokeProperties strokeProperties, SimpleDoubleProperty[] observableBindingPoints){
		this.observableBindingPoints=observableBindingPoints;
		shape=defineDisplayShape();
		setMainDisplayShape(shape);
		setStrokeProperties(strokeProperties);
		return shape;
	}
	public abstract Shape defineDisplayShape();
	//***********************************************************************
	public abstract JPolygon setEnclosureShape(SimpleDoubleProperty[] observableBindingPoints);
	//***********************************************************************
	public  abstract void setShapeBinding(SimpleDoubleProperty[] observableBindingPoints);
	//***********************************************************************
	

}
