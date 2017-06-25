package polygonShapes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class WrapPoint {
	
	//***********************************************************
	public Circle shape;
	private SimpleDoubleProperty p1X;
	private SimpleDoubleProperty p1Y;
	//cursor drag event
	public double cursorOriginalX;
	public double cursorOriginalY;
	public double p1XOriginalValue;
	public double p1YOriginalValue;
	
	
	//***********************************************************
	public WrapPoint(SimpleDoubleProperty p1X, SimpleDoubleProperty p1Y){
		//initialize wrapper point properties
		this.p1X=p1X; this.p1Y=p1Y;
		shape=new Circle(5);
		shape.setStroke(Color.BLACK);
		shape.setFill(Color.AQUA);
		shape.centerXProperty().bind(p1X);
		shape.centerYProperty().bind(p1Y);
		//initialize cursor event values
		cursorOriginalX=0; cursorOriginalY=0;
		p1XOriginalValue=0; p1YOriginalValue=0;
		setDragEvent();
	}
	
	//***********************************************************
	public Circle getShape(){
		return this.shape;
	}
	
	private void setDragEvent(){
		
		shape.setOnMousePressed(e ->{
			cursorOriginalX=e.getX();
			cursorOriginalY=e.getY();
			p1XOriginalValue=p1X.getValue();
			p1YOriginalValue=p1Y.getValue();
			
		});
		
		shape.setOnMouseDragged(e ->{
			double deltaX=e.getX()-cursorOriginalX;
			double deltaY=e.getY()-cursorOriginalY;
			
			double newP1X=p1XOriginalValue+deltaX;
			double newP1Y=p1YOriginalValue+deltaY;
			
			p1X.setValue(newP1X);
			p1Y.setValue(newP1Y);
			
		});
	}

}
