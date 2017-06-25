package application;

public class ApplicationInitializer {
	
	//***********************************************************************
	private MAIN application;
	private ElementInitializer elements;
	private ActionListenerInitializer actionListeners;
	private CanvasControlsHandler canvasControls;
	//private HotKeysHandler hotKeys;
	private LayoutInitializer layout;
	
	//***********************************************************************
	public ApplicationInitializer(MAIN application){
		this.application=application;
		elements=new ElementInitializer();
		actionListeners=new ActionListenerInitializer(elements);
		canvasControls=new CanvasControlsHandler(elements);
		//hotKeys=new HotKeysHandler(elements);
		layout=new LayoutInitializer(elements);	
	}
	
	//***********************************************************************
	public void initialize(){
		elements.initialize();
		actionListeners.initialize();
		canvasControls.initialize();
		//hotKeys.initialize();
		layout.initialize();
		application.setLayout(elements.getLayout());
	}
	
	
}
