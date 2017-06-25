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

public class JTriangle extends JPolygon{

	
	

	public JTriangle(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		// TODO Auto-generated constructor stub
	}

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
