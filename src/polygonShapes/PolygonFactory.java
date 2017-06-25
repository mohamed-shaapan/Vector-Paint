package polygonShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;

public class PolygonFactory {
	
	private ArrayList<JShape> selectedCanvasElements;
	
	//**************************************************************
	public PolygonFactory(ArrayList<JShape> selectedCanvasElements){
		this.selectedCanvasElements=selectedCanvasElements;
	}
	

	//**************************************************************
	public JPolygon makeShape(String shapeName, StrokeProperties strokeProperties){
		//**************************************************************
		if(shapeName.contentEquals("line")){
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[4];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(100.0); points[1].setValue(100.0);
			points[2].setValue(350.0); points[3].setValue(75.0);
			return new JLine(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		if(shapeName.contentEquals("triangle")){
			
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[6];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(100.0); points[1].setValue(100.0);
			points[2].setValue(350.0); points[3].setValue(75.0);
			points[4].setValue(250.0); points[5].setValue(300.0);
			return new JTriangle(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		if(shapeName.contentEquals("rectangle")){
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[8];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(50.0); points[1].setValue(50.0);
			points[2].setValue(300.0); points[3].setValue(50.0);
			points[4].setValue(300.0); points[5].setValue(250.0);
			points[6].setValue(50.0); points[7].setValue(250.0);
			return new JRectangle(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		if(shapeName.contentEquals("square")){
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[8];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(50.0); points[1].setValue(50.0);
			points[2].setValue(250.0); points[3].setValue(50.0);
			points[4].setValue(250.0); points[5].setValue(250.0);
			points[6].setValue(50.0); points[7].setValue(250.0);
			return new JSquare(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		return null;
	}
	
	

}
