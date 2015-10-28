package framework;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public abstract class MyScene extends Scene {
	protected Stage parent;

	public MyScene() {
		super(new HBox());
	}
	
	public void init(){
		createModel();
		setRoot(createView());
		createPresenter();
	}
	
	protected abstract void createModel();
	protected abstract Parent createView();
	protected abstract void createPresenter();
	
	/**
	 * Shows this scene to the user
	 * @param parent which stage to use
	 */
	public void show(Stage parent){
		this.parent = parent;
		parent.hide();
		
		this.init();
		parent.setScene(this);
		parent.setWidth(510);
		parent.setHeight(510);
		parent.show();
	}
}
