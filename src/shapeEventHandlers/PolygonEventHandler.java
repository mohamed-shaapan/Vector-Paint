package shapeEventHandlers;

import java.util.ArrayList;

import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import polygonShapes.JPolygon;
import polygonShapes.WrapPoint;

public class PolygonEventHandler implements ShapeEventHandler{
	
	//***********************************************************************
	private JPolygon jPolygon;
	private Shape shape;
	private SimpleDoubleProperty observableBindingPoints[];
	private ArrayList<WrapPoint> anchorPoints;
	
	private double cursorOriginalX;
	private double cursorOriginalY;
	
	private Double[] priorDragPointLocation;
	
	private boolean pointsShown;
	
	private ArrayList<JShape> selectedCanvasElements;
	
	//***********************************************************************
	public PolygonEventHandler(JPolygon jPolygon, ArrayList<JShape> selectedCanvasElements){
		this.jPolygon=jPolygon;
		this.shape=jPolygon.getMainDisplayShape();
		this.observableBindingPoints=jPolygon.getBindingPoints();
		this.anchorPoints=jPolygon.getAnchorShapes();
		cursorOriginalX=0;
		cursorOriginalY=0;
		priorDragPointLocation=new Double[observableBindingPoints.length];
		this.selectedCanvasElements=selectedCanvasElements;
	}
	
	public void generateEvents(){
		setDragEvent();
		setShapeHighlightingEvent();
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
	private void setShapeHighlightingEvent(){
		shape.setOnMouseClicked(e ->{
			if(e.getClickCount()==2){
				if(pointsShown==true){
					try{
						selectedCanvasElements.clear();
					}catch(Exception ex){}
					hideAnchorPoints();
				}else{
					jPolygon.setCanvasSelectedElements(selectedCanvasElements);
					showAnchorPoints();
				}
			}	
		});
	}
	public void hideAnchorPoints(){
		for(WrapPoint anchor:anchorPoints){
			anchor.getShape().setVisible(false);
		}
		pointsShown=false;
	}
	public void showAnchorPoints(){
		for(WrapPoint anchor:anchorPoints){
			anchor.getShape().setVisible(true);
		}
		pointsShown=true;
	}
	

}
