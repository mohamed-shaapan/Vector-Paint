package polygonShapes;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import shapeEventHandlers.PolygonEventHandler;
import shapeEventHandlers.ShapeEventHandler;
import shapeRestrictionsHandlers.AnchorRestricitions;
import shapeRestrictionsHandlers.RectangleRestrictions;

public class JRectangle extends JPolygon{
	
	//Serialization Attributes***********************************************
	private ObjectProperty<Paint> fillColor;
	private ObjectProperty<Paint> borderColor;
	private DoubleProperty borderWidth;
	SimpleDoubleProperty[] observableBindingPoints;
	

	public JRectangle(SimpleDoubleProperty[] observableBindingPoints, StrokeProperties strokeProperties,
			ArrayList<JShape> selectedCanvasElements) {
		super(observableBindingPoints, strokeProperties, selectedCanvasElements);
		
		fillColor=this.getMainDisplayShape().fillProperty();
		borderColor=this.getMainDisplayShape().strokeProperty();
		borderWidth=this.getMainDisplayShape().strokeWidthProperty();
		this.observableBindingPoints=observableBindingPoints;
	}

	

	//***********************************************************************

	
	//***********************************************************************

	@Override
	public AnchorRestricitions setAnchorRestrictions() {
		return new RectangleRestrictions((Polygon)(getMainDisplayShape()), getBindingPoints());
	}

	@Override
	public ShapeEventHandler setEventHandler(ArrayList<JShape> selectedCanvasElements) {
		return new PolygonEventHandler(this, selectedCanvasElements);
	}

}
