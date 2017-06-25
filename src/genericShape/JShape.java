package genericShape;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class JShape {
	
	//*********************************************************
	private Shape mainDisplayShape;
	private Color fillColor;
	private Color borderColor;
	private double borderWidth;
	
	//*********************************************************
	public abstract ArrayList<Shape> getShapesToDisplay();
	public JShape getJShape(){
		return this;
	}
	public void setMainDisplayShape(Shape shape){
		mainDisplayShape=shape;
	}
	public Shape getMainDisplayShape(){
		return mainDisplayShape;
	}
	public void setCanvasSelectedElements(ArrayList<JShape> selectedCanvasElements){
		try{
			selectedCanvasElements.clear();
			selectedCanvasElements.add(this);
		}catch(Exception ex){}
	}
	//*********************************************************
	public void setFillColor(Color color){
		mainDisplayShape.setFill(color);
	}
	public void setBorderWidth(double width){
		mainDisplayShape.setStrokeWidth(width);
	}
	public void setBorderColor(Color color){
		mainDisplayShape.setStroke(color);
	}
	public Color getFillColor() {
		return fillColor;
	}
	public Color getBorderColor() {
		return borderColor;
	}
	public double getBorderWidth() {
		return borderWidth;
	}
	//*********************************************************
	public void setStrokeProperties(StrokeProperties strokeProperties){
		mainDisplayShape.setStrokeWidth(strokeProperties.getBorderSize());
		mainDisplayShape.setStroke(strokeProperties.getBorderColor());
		mainDisplayShape.setFill(strokeProperties.getFillColor());
	    if(strokeProperties.getDotSpacing()!=0){
	    	mainDisplayShape.getStrokeDashArray().add(strokeProperties.getDotSpacing());
	    }
	}

}
