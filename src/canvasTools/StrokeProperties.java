package canvasTools;


import javafx.scene.paint.Color;

public class StrokeProperties {
	
	//***********************************************************************
	private Color fillColor;
	private double borderSize;
	private Color borderColor;
	private double dotSpacing;
	//shape.getStrokeDashArray().add(10.0);
	
	//***********************************************************************
	public StrokeProperties(Color fillColor, double borderSize, Color borderColor, double dotSpacing){
		this.fillColor=fillColor;
		this.borderSize=borderSize;
		this.borderColor=borderColor;
		this.dotSpacing=dotSpacing;
		
	}

	//***********************************************************************
	public Color getFillColor() {
		return fillColor;
	}

	public double getBorderSize() {
		return borderSize;
	}

	public Color getBorderColor() {
		return borderColor;
	}
	
	public double getDotSpacing() {
		return dotSpacing;
	}
	
	
}
