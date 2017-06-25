package genericShape;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.shape.Polygon;
import polygonShapes.JPolygon;
import shapeEventHandlers.EnclosureEventHandler;
import shapeEventHandlers.ShapeEventHandler;
import shapeRestrictionsHandlers.AnchorRestricitions;
import shapeRestrictionsHandlers.RectangleRestrictions;

public class RectangleEnclosure extends JPolygon{

	public RectangleEnclosure(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AnchorRestricitions setAnchorRestrictions() {
		return new RectangleRestrictions((Polygon)(getMainDisplayShape()), getBindingPoints());
	}

	@Override
	public ShapeEventHandler setEventHandler(ArrayList<JShape> selectedCanvasElements) {
		return new EnclosureEventHandler(this);
	}


}
