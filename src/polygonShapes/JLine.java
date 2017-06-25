package polygonShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import shapeEventHandlers.PolygonEventHandler;
import shapeEventHandlers.ShapeEventHandler;
import shapeRestrictionsHandlers.AnchorRestricitions;
import shapeRestrictionsHandlers.FreeRestrictions;

public class JLine extends JPolygon{
	


	public JLine(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		// TODO Auto-generated constructor stub
	}

	//***********************************************************************
	//private double p1X; private double p1Y;
	//private double p2X; private double p2Y;
	//private StrokeProperties strokeProperties;
	
	//***********************************************************************

	
	//***********************************************************************
	@Override
	public AnchorRestricitions setAnchorRestrictions() {
		return new FreeRestrictions((Polygon)(getMainDisplayShape()), getBindingPoints());
	}

	@Override
	public ShapeEventHandler setEventHandler(ArrayList<JShape> selectedCanvasElements) {
		return new PolygonEventHandler(this, selectedCanvasElements);
	}

}
