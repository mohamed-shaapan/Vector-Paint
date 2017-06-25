package polygonShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import shapeEventHandlers.ShapeEventHandler;
import shapeRestrictionsHandlers.AnchorRestricitions;

public abstract class JPolygon extends JShape{
	
	//***********************************************************************
	//private Polygon shape;
	private ArrayList<WrapPoint> anchorShapes;
	private SimpleDoubleProperty[] observableBindingPoints;
	private AnchorRestricitions anchorRestrictions;
	
	

	//***********************************************************************
	public JPolygon(SimpleDoubleProperty observableBindingPoints[], StrokeProperties strokeProperties, ArrayList<JShape> selectedCanvasElements){
		
		this.observableBindingPoints=observableBindingPoints;
		Polygon shape=new Polygon();
		for(int i=1; i<=observableBindingPoints.length; i++){
			shape.getPoints().add(observableBindingPoints[i-1].getValue());
		}
		setMainDisplayShape(shape);
		
		setStrokeProperties(strokeProperties);

		anchorRestrictions=setAnchorRestrictions();
	   
		anchorShapes=anchorRestrictions.generateAnchorShapes();
		
		setCanvasSelectedElements(selectedCanvasElements);
	
		ShapeEventHandler eventHandler=setEventHandler(selectedCanvasElements);
	    eventHandler.generateEvents();
	    
	}
	
	//***********************************************************************
	public ArrayList<Shape> getShapesToDisplay(){
		ArrayList<Shape> result=new ArrayList<>();
		result.add(getMainDisplayShape());
		for(WrapPoint anchorPoint:anchorShapes){
			result.add(anchorPoint.getShape());
		}
		return result;
	}
	
	public SimpleDoubleProperty[] getBindingPoints(){
		return observableBindingPoints;
	}
	
	public ArrayList<WrapPoint> getAnchorShapes(){
		return anchorShapes;
	}
	//***********************************************************************
	public abstract AnchorRestricitions setAnchorRestrictions();
	//***********************************************************************
	public abstract ShapeEventHandler setEventHandler(ArrayList<JShape> selectedCanvasElements);
	
}
