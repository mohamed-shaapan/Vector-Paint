package polygonShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import shapeEventHandlers.PolygonEventHandler;
import shapeEventHandlers.ShapeEventHandler;
import shapeRestrictionsHandlers.AnchorRestricitions;
import shapeRestrictionsHandlers.SquareRestrictions;

public class JSquare extends JPolygon{
	
	//***********************************************************************
	//private DoubleBinding edge; //=(observableBindingPoints[2].add(observableBindingPoints[0])).divide(2.0);
	//private double p1X; private double p1Y;
	//private double p2X; private double p2Y;
	//private StrokeProperties strokeProperties;
	
	//***********************************************************************
	public JSquare(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		//edge=observableBindingPoints[2].subtract(observableBindingPoints[0]);
	}
	//***********************************************************************

	//***********************************************************************
	@Override
	public AnchorRestricitions setAnchorRestrictions() {
		return new SquareRestrictions((Polygon)(getMainDisplayShape()), getBindingPoints()/*, edge*/);
	}
	@Override
	public ShapeEventHandler setEventHandler(ArrayList<JShape> selectedCanvasElements) {
		return new PolygonEventHandler(this, selectedCanvasElements);
	}

}
