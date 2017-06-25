package shapeEventHandlers;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import polygonShapes.JPolygon;

public class EnclosureEventHandler implements ShapeEventHandler{
	
	//***********************************************************************
	private Shape shape;
	private SimpleDoubleProperty observableBindingPoints[];
	
	private double cursorOriginalX;
	private double cursorOriginalY;
	
	private Double[] priorDragPointLocation;
	
	//***********************************************************************
	public EnclosureEventHandler(JPolygon jPolygon){
		this.shape=jPolygon.getMainDisplayShape();
		this.observableBindingPoints=jPolygon.getBindingPoints();
		cursorOriginalX=0;
		cursorOriginalY=0;
		priorDragPointLocation=new Double[observableBindingPoints.length];
	}
	
	public void generateEvents(){
		setDragEvent();
		//setShapeHighlightingEvent();
		//hideAnchorPoints();
	}
	
	//***********************************************************************
	private void setDragEvent(){
		
		shape.setOnMousePressed(e ->{
			cursorOriginalX=e.getX();
			cursorOriginalY=e.getY();
			
			Polygon polygonShape=(Polygon)shape;
			for(int i=1; i<=priorDragPointLocation.length; i++){
				priorDragPointLocation[i-1]=polygonShape.getPoints().get(i-1);
			}
		
		});
		
		shape.setOnMouseDragged(e ->{
			double deltaX=e.getX()-cursorOriginalX;
			double deltaY=e.getY()-cursorOriginalY;
			
			for(int i=1; i<=priorDragPointLocation.length; i+=2){
				//for each point
				Double newX=priorDragPointLocation[i-1]+deltaX;;
				Double newY=priorDragPointLocation[i]+deltaY;
				
				observableBindingPoints[i-1].setValue(newX);
				observableBindingPoints[i].setValue(newY);
			}
			
		});
	}
	
	//***********************************************************************

}
