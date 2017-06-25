package shapeEventHandlers;

import java.util.ArrayList;

import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Shape;
import ovalShapes.JOval;
import polygonShapes.JPolygon;

public class OvalEventHandler implements ShapeEventHandler{
	
	//***********************************************************************
	private JOval jOval;
	private Shape shape;
	private SimpleDoubleProperty observableBindingPoints[];
	private JPolygon enclosure;
	
	private double cursorOriginalX;
	private double cursorOriginalY;
	
	private Double[] priorDragPointLocation;
	
	private boolean enclosureShown;
	private ArrayList<JShape> selectedCanvasElements;
	
	//***********************************************************************
	public OvalEventHandler(JOval jOval, ArrayList<JShape> selectedCanvasElements){
		this.jOval=jOval;
		this.shape=jOval.getMainDisplayShape();
		this.observableBindingPoints=jOval.getBindingPoints();
		this.enclosure=jOval.getEnclosure();
		cursorOriginalX=0;
		cursorOriginalY=0;
		priorDragPointLocation=new Double[observableBindingPoints.length]; 
		this.selectedCanvasElements=selectedCanvasElements;
	}
	
	public void generateEvents(){
		setDragEvent();
		setShapeHighlightingEvent();
		hideEnclosure();
	}
	
	//***********************************************************************
	private void setDragEvent(){
		
		shape.setOnMousePressed(e ->{
			cursorOriginalX=e.getX();
			cursorOriginalY=e.getY();
			
			for(int i=1; i<=priorDragPointLocation.length; i++){
				priorDragPointLocation[i-1]=observableBindingPoints[i-1].getValue();
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
				if(enclosureShown==true){
					try{
						selectedCanvasElements.clear();
					}catch(Exception ex){}
					hideEnclosure();
				}else{
					jOval.setCanvasSelectedElements(selectedCanvasElements);
					showEnclosure();
				}
			}	
		});
	}
	public void hideEnclosure(){
		for(Shape subShape:enclosure.getShapesToDisplay()){
			subShape.setVisible(false);
		}
		enclosureShown=false;
	}
	public void showEnclosure(){
		for(Shape subShape:enclosure.getShapesToDisplay()){
			subShape.setVisible(true);
		}
		enclosureShown=true;
	}
	

}
