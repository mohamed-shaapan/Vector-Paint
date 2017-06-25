package ovalShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import polygonShapes.JPolygon;
import polygonShapes.JRectangle;

public class JEllipse extends JOval{

	//***********************************************************************
	public JEllipse(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		// TODO Auto-generated constructor stub
	}

	//***********************************************************************
	public Shape defineDisplayShape(){
		return new Ellipse();
	}
	
	//***********************************************************************
	@Override
	public JPolygon setEnclosureShape(SimpleDoubleProperty[] observableBindingPoints) {
		StrokeProperties enclosureStroke=new StrokeProperties(null, 1, Color.RED, 10.0);
		return new JRectangle(observableBindingPoints, enclosureStroke, null);
	}
	
	//***********************************************************************
	public void setShapeBinding(SimpleDoubleProperty[] observableBindingPoints){
		DoubleBinding centerX=(observableBindingPoints[2].add(observableBindingPoints[0])).divide(2.0);
		DoubleBinding centerY=(observableBindingPoints[5].add(observableBindingPoints[3])).divide(2.0);
		((Ellipse)getMainDisplayShape()).centerXProperty().bind(centerX);
		((Ellipse)getMainDisplayShape()).centerYProperty().bind(centerY);
		
		DoubleBinding widthProperty=(observableBindingPoints[2].subtract(observableBindingPoints[0])).divide(2.0);
		DoubleBinding heightProperty=(observableBindingPoints[5].subtract(observableBindingPoints[3])).divide(2.0);
		((Ellipse)getMainDisplayShape()).radiusXProperty().bind(widthProperty);
		((Ellipse)getMainDisplayShape()).radiusYProperty().bind(heightProperty);
	}

}
