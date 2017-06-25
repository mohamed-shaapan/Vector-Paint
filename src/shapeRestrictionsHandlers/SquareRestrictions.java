package shapeRestrictionsHandlers;

import java.util.ArrayList;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Polygon;
import polygonShapes.WrapPoint;

public class SquareRestrictions implements AnchorRestricitions{
	
	//***********************************************************************
	private Polygon shape;
	private SimpleDoubleProperty observableBindingPoints[];
	//private DoubleBinding edge;
		
	//***********************************************************************
	public SquareRestrictions(Polygon shape, SimpleDoubleProperty observableBindingPoints[]/*, DoubleBinding edge*/) {
		this.shape=shape;
		this.observableBindingPoints=observableBindingPoints;
		//this.edge=edge;
	}
		
	//***********************************************************************

	@Override
	public ArrayList<WrapPoint> generateAnchorShapes() {
		ArrayList<WrapPoint> anchorShapes=new ArrayList<>();
	    
		SimpleDoubleProperty p1X=observableBindingPoints[0];
		SimpleDoubleProperty p1Y=observableBindingPoints[1];
		SimpleDoubleProperty p2X=observableBindingPoints[2];
		SimpleDoubleProperty p2Y=observableBindingPoints[3];
		SimpleDoubleProperty p3X=observableBindingPoints[4];
		SimpleDoubleProperty p3Y=observableBindingPoints[5];
		SimpleDoubleProperty p4X=observableBindingPoints[6];
		SimpleDoubleProperty p4Y=observableBindingPoints[7];
		
		//DoubleBinding edge=(observableBindingPoints[2].add(observableBindingPoints[0])).divide(2.0);
		
		p1X.bindBidirectional(p4X);
		p1Y.bindBidirectional(p2Y);
		p2X.bindBidirectional(p3X);
		p3Y.bindBidirectional(p4Y);
		
		
		
		//p1X.bindBidirectional(p1Y);
		//p2X.bindBidirectional(p2Y);
		//p3X.bindBidirectional(p3Y);
		//p4X.bindBidirectional(p4Y);

		//P1 Action Listeners*************************************	
		p1X.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) { 
				//Double change=((Double) x)-((Double) oldX);
				//p1Y.setValue(p1Y.getValue()+change);
				shape.getPoints().set(0, (Double)x);
				shape.getPoints().set(6, (Double)x);
			}
		});
		p1Y.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {
				//Double change=((Double) y)-((Double) oldY);
				//p1X.setValue(p1X.getValue()+change);
				shape.getPoints().set(1, (Double)y);
				shape.getPoints().set(3, (Double)y);
			}
		});
		anchorShapes.add(new WrapPoint(p1X, p1Y));
		//P2 Action Listeners*************************************
		p2X.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {  
				shape.getPoints().set(2, (Double)x);
				shape.getPoints().set(4, (Double)x);
			}
		});
		p2Y.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {  
				shape.getPoints().set(3, (Double)y);
				shape.getPoints().set(1, (Double)y);
			}
		});
		anchorShapes.add(new WrapPoint(p2X, p2Y));
		//P3 Action Listeners*************************************
		p3X.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {  
				shape.getPoints().set(4, (Double)x);
				shape.getPoints().set(2, (Double)x);
			}
		});
		p3Y.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {  
				shape.getPoints().set(5, (Double)y);
				shape.getPoints().set(7, (Double)y);
			}
		});
		anchorShapes.add(new WrapPoint(p3X, p3Y));
		//P4 Action Listeners*************************************
		p4X.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldX, Number x) {  
				shape.getPoints().set(6, (Double)x);
				shape.getPoints().set(0, (Double)x);
			}
		});
		p4Y.addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number oldY, Number y) {  
				shape.getPoints().set(7, (Double)y);
				shape.getPoints().set(5, (Double)y);
			}
		});
		anchorShapes.add(new WrapPoint(p4X, p4Y));
		//*******************************************************
			
		return anchorShapes;
	}

}
