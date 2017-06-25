package shapeRestrictionsHandlers;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Polygon;
import polygonShapes.WrapPoint;

public class FreeRestrictions implements AnchorRestricitions{
	
	//***********************************************************************
	private Polygon shape;
	private SimpleDoubleProperty observableBindingPoints[];
	
	//***********************************************************************
	public FreeRestrictions(Polygon shape, SimpleDoubleProperty observableBindingPoints[]) {
		this.shape=shape;
		this.observableBindingPoints=observableBindingPoints;
	}

	//***********************************************************************
	@Override
	public ArrayList<WrapPoint> generateAnchorShapes() {
	    
		ArrayList<WrapPoint> anchorShapes=new ArrayList<>();
		
		for (int i=1; i<=observableBindingPoints.length; i+=2) {
			
			SimpleDoubleProperty coordinateX=observableBindingPoints[i-1];
			SimpleDoubleProperty coordinateY=observableBindingPoints[i];
			
			final int tmp=i;
			coordinateX.addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {  
					shape.getPoints().set(tmp-1, (Double)x);
				}
			});
			
			coordinateY.addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {  
					shape.getPoints().set(tmp, (Double)y);
				}
			});
			
			anchorShapes.add(new WrapPoint(coordinateX, coordinateY));

		}
		    
		return anchorShapes;
	  
	}

}
