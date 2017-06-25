package application;

import java.util.ArrayList;

import canvasTools.StrokeProperties;
import genericShape.JShape;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ovalShapes.OvalFactory;
import polygonShapes.PolygonFactory;

public class ElementInitializer {

	//***********************************************************************
	//A_Control Bar Buttons
	private Button createNewImageBtn;
	private Button saveImageBtn;
	private Button loadImageBtn;
	private Button undoActionBtn;
	private Button redoActionBtn;


	//B_Add & Delete Buttons
	private Button addLineBtn;
	private Button addTriangleBtn;
	private Button addSquareBtn;
	private Button addRectangleBtn;
	private Button addEllipseBtn;
	private Button addCircleBtn;

	//C_Size Controls
	private Label resizeControlsLabel;
	private Slider fullResizeSlider;
	private Slider widthResizeSlider;
	private Slider heightResizeSlider;

	//D_Border Controls
	private Label borderControlsLabel;
	private Slider borderThicknessSlider;
	private ColorPicker borderColorPicker;

	//E_Shape Fill Controls
	private Label fillControlsLabel;
	private ColorPicker fillColorPicker;

	//F_Misc Controls
	private Label miscControlsLabel;
	private Button removeShapeBtn;

	//G_More Attributes
	private BorderPane layout;
	private Pane canvas;
	private Stage primaryWindow;

	//H_Engine Related
	private ArrayList<JShape> canvasShapes;
	private ArrayList<JShape> selectedElements;
	private StrokeProperties strokeProperties;
	private PolygonFactory polygonFactory;
	private OvalFactory ovalFactory;
	
	
	//***********************************************************************
	public void initialize(){
		//01_Control Bar Buttons
		createNewImageBtn=new Button("N");
		saveImageBtn=new Button("S");
		loadImageBtn=new Button("L");
		undoActionBtn=new Button("U");
		redoActionBtn=new Button("R");
		
		//02_Add Shape Buttons
		addLineBtn=new Button("Line");
		addTriangleBtn=new Button("Triangle");
		addSquareBtn=new Button("Square");
		addRectangleBtn=new Button("Rectangle");
		addEllipseBtn=new Button("Ellipse");
		addCircleBtn=new Button("Circle");
		//02_Resize Controls
		resizeControlsLabel=new Label("Resize Controls");
		fullResizeSlider=new Slider();
		fullResizeSlider.setMinWidth(200);fullResizeSlider.setMaxWidth(200);
		fullResizeSlider.setMin(-1000);fullResizeSlider.setMax(1000);
		widthResizeSlider=new Slider();
		widthResizeSlider.setMinWidth(200);widthResizeSlider.setMaxWidth(200);
		widthResizeSlider.setMin(-1000);widthResizeSlider.setMax(1000);
		heightResizeSlider=new Slider();
		heightResizeSlider.setMinWidth(200);heightResizeSlider.setMaxWidth(200);
		heightResizeSlider.setMin(-1000);heightResizeSlider.setMax(1000);
		//03_Border Control
		borderControlsLabel=new Label("Border Controls");
		borderThicknessSlider=new Slider();
		borderThicknessSlider.setMinWidth(200);borderThicknessSlider.setMaxWidth(200);
		borderThicknessSlider.setMin(1);borderThicknessSlider.setMax(10);
		borderColorPicker=new ColorPicker();
		//04_Shape Fill Control
		fillControlsLabel=new Label("Fill Controls");
		fillColorPicker=new ColorPicker();
		//05_MISC Controls
		miscControlsLabel=new Label("Misc Controls");
		removeShapeBtn=new Button("Remove");
		//06_More Attributes
		canvas=new Pane();
		primaryWindow=new Stage();
		//07_Engine Related
		canvasShapes=new ArrayList<JShape>();
		selectedElements=new ArrayList<JShape>();
		layout=new BorderPane();
		strokeProperties=new StrokeProperties(Color.YELLOW, 3, Color.BLUE, 0);
		polygonFactory=new PolygonFactory(selectedElements);
		ovalFactory=new OvalFactory(selectedElements);

	}


	//***********************************************************************
	public Button getCreateNewImageBtn() {
		return createNewImageBtn;
	}


	public Button getSaveImageBtn() {
		return saveImageBtn;
	}


	public Button getLoadImageBtn() {
		return loadImageBtn;
	}


	public Button getUndoActionBtn() {
		return undoActionBtn;
	}


	public Button getRedoActionBtn() {
		return redoActionBtn;
	}


	public Button getAddLineBtn() {
		return addLineBtn;
	}


	public Button getAddTriangleBtn() {
		return addTriangleBtn;
	}


	public Button getAddSquareBtn() {
		return addSquareBtn;
	}


	public Button getAddRectangleBtn() {
		return addRectangleBtn;
	}


	public Button getAddEllipseBtn() {
		return addEllipseBtn;
	}


	public Button getAddCircleBtn() {
		return addCircleBtn;
	}


	public Label getResizeControlsLabel() {
		return resizeControlsLabel;
	}


	public Slider getFullResizeSlider() {
		return fullResizeSlider;
	}


	public Slider getWidthResizeSlider() {
		return widthResizeSlider;
	}


	public Slider getHeightResizeSlider() {
		return heightResizeSlider;
	}


	public Label getBorderControlsLabel() {
		return borderControlsLabel;
	}


	public Slider getBorderThicknessSlider() {
		return borderThicknessSlider;
	}


	public ColorPicker getBorderColorPicker() {
		return borderColorPicker;
	}


	public Label getFillControlsLabel() {
		return fillControlsLabel;
	}


	public ColorPicker getFillColorPicker() {
		return fillColorPicker;
	}


	public Label getMiscControlsLabel() {
		return miscControlsLabel;
	}


	public Button getRemoveShapeBtn() {
		return removeShapeBtn;
	}


	public BorderPane getLayout() {
		return layout;
	}


	public Pane getCanvas() {
		return canvas;
	}


	public Stage getPrimaryWindow() {
		return primaryWindow;
	}


	public ArrayList<JShape> getCanvasShapes() {
		return canvasShapes;
	}


	public ArrayList<JShape> getSelectedElements() {
		return selectedElements;
	}


	public StrokeProperties getStrokeProperties() {
		return strokeProperties;
	}


	public PolygonFactory getPolygonFactory() {
		return polygonFactory;
	}


	public OvalFactory getOvalFactory() {
		return ovalFactory;
	}
	
	
}
