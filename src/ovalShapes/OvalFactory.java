package ovalShapes;


import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;

public class OvalFactory {
	
	
	private ArrayList<JShape> selectedCanvasElements;
	
	//**************************************************************
	public OvalFactory(ArrayList<JShape> selectedCanvasElements){
		this.selectedCanvasElements=selectedCanvasElements;
	}

	public JOval makeShape(String shapeName, StrokeProperties strokeProperties){
		//**************************************************************
		if(shapeName.contentEquals("ellipse")){
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[8];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(50.0); points[1].setValue(50.0);
			points[2].setValue(300.0); points[3].setValue(50.0);
			points[4].setValue(300.0); points[5].setValue(250.0);
			points[6].setValue(50.0); points[7].setValue(250.0);
			return new JEllipse(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		if(shapeName.contentEquals("circle")){
			SimpleDoubleProperty points[]=new SimpleDoubleProperty[8];
			for(int i=1; i<=points.length; i++){
				points[i-1]=new SimpleDoubleProperty();
			}
			
			points[0].setValue(50.0); points[1].setValue(50.0);
			points[2].setValue(250.0); points[3].setValue(50.0);
			points[4].setValue(250.0); points[5].setValue(250.0);
			points[6].setValue(50.0); points[7].setValue(250.0);
			return new JCircle(points, strokeProperties, selectedCanvasElements);
		}
		//**************************************************************
		return null;
	}
	
	

}
